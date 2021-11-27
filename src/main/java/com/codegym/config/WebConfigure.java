package com.codegym.config;

import com.codegym.jwt_token.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebConfigure extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilterRequest jwtFilterRequest;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //phân quyền Account
                .authorizeRequests().antMatchers("/api/account/login","/api/account/userName").permitAll()
                .and().authorizeRequests().antMatchers("/api/account/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")

                //phân quyền Employee
                .and().authorizeRequests().antMatchers("/api/employee/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")

                //phân quyền Table
                .and().authorizeRequests().antMatchers("/api/table/delete", "/api/table/add").access("hasAnyRole('ROLE_ADMIN')")
                .and().authorizeRequests().antMatchers("/api/table/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")

                //phân quyền Category - linhDN
                .and().authorizeRequests().antMatchers("/api/category/menu").permitAll()
                .and().authorizeRequests().antMatchers("/api/category/list", "/api/category/delete").access("hasAnyRole('ROLE_USER')")
                .and().authorizeRequests().antMatchers("/api/category/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")

                //phân quyền FoodAndDrink - linhDN
                .and().authorizeRequests().antMatchers("/api/food-and-drink/find-top-five-new", "/api/food-and-drink/find-top-five-popular", "/api/food-and-drink/allFood").permitAll()
                .and().authorizeRequests().antMatchers("/api/food-and-drink/list", "/api/food-and-drink/delete").access("hasAnyRole('ROLE_USER')")
                .and().authorizeRequests().antMatchers("/api/food-and-drink/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")

                //phân quyền order - danhNT
                .and().authorizeRequests().antMatchers("/api/order/table").permitAll()
                .and().authorizeRequests().antMatchers("/api/order/list/**", "/api/order/find/**",
                "/api/order/income-date/**", "/api/order/income-statistics/**", "/api/order/on-service/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .and().authorizeRequests().antMatchers("/api/order/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")

                //phân quyền Feedback
                .and().authorizeRequests().antMatchers("/api/feed-back/add").permitAll()
                .and().authorizeRequests().antMatchers("/api/feed-back/list-by-date/**", "/api/feed-back/find-feed-back-by-id/**").access("hasAnyRole('ROLE_ADMIN')")

                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors();
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
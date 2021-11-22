package com.codegym.services.impls;
import com.codegym.entity.account.Account;
import com.codegym.entity.account.AccountDetail;
import com.codegym.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IAccountService accountService;
    //    Kiet login 23/10 AuthenticationManager user this function
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.accountService.findByUsername(username);
        if (account ==  null){
            throw  new UsernameNotFoundException("Can not find this username");
        }
        return new AccountDetail(account);
    }
}
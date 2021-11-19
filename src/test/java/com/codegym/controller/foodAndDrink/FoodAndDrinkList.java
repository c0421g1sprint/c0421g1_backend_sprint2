package com.codegym.controller.foodAndDrink;

import com.codegym.controllers.FoodAndDrinkController;
import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class FoodAndDrinkList {
    @Autowired
    FoodAndDrinkController foodAndDrinkController;
    //test tra ve danh sach rong - 4xxError - LinhDN
    @Test
    public void getListFoodAndDrink_1(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"","",null,null);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    //test tra ve danh sach thanh cong - 2xxOK - LinhDN
    @Test
    public void getListFoodAndDrink_2(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"","",null,null);

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<FoodAndDrink> foodAndDrinks =pageResponseEntity.getBody();
        Assertions.assertEquals(18,foodAndDrinks.getTotalElements());
        Assertions.assertEquals(9,foodAndDrinks.getTotalPages());
        Assertions.assertEquals("Bạc xỉu",foodAndDrinks.getContent().get(0).getFadName());
    }

    //test tra ve danh sach thanh cong theo ten - 2xxOK - LinhDN
    @Test
    public void getListFoodAndDrink_3(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"phê","",null,null);

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<FoodAndDrink> foodAndDrinks =pageResponseEntity.getBody();
        Assertions.assertEquals(4,foodAndDrinks.getTotalElements());
        Assertions.assertEquals(2,foodAndDrinks.getTotalPages());
        Assertions.assertEquals("Cà phê đen",foodAndDrinks.getContent().get(0).getFadName());
    }

    //test tra ve danh sach thanh cong theo code - 2xxOK - LinhDN
    @Test
    public void getListFoodAndDrink_4(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"","FAD-0004",null,null);

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<FoodAndDrink> foodAndDrinks =pageResponseEntity.getBody();
        Assertions.assertEquals(1,foodAndDrinks.getTotalElements());
        Assertions.assertEquals(1,foodAndDrinks.getTotalPages());
        Assertions.assertEquals("Espresso",foodAndDrinks.getContent().get(0).getFadName());
    }
    //test tra ve danh sach thanh cong theo gia - 2xxOK - LinhDN
    @Test
    public void getListFoodAndDrink_5(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"","", (double) 45000,null);

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<FoodAndDrink> foodAndDrinks =pageResponseEntity.getBody();
        Assertions.assertEquals(2,foodAndDrinks.getTotalElements());
        Assertions.assertEquals(1,foodAndDrinks.getTotalPages());
        Assertions.assertEquals("Espresso",foodAndDrinks.getContent().get(0).getFadName());
    }

    //test tra ve danh sach thanh cong theo category - 2xxOK - LinhDN
    @Test
    public void getListFoodAndDrink_6(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"","", null,3);

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<FoodAndDrink> foodAndDrinks =pageResponseEntity.getBody();
        Assertions.assertEquals(4,foodAndDrinks.getTotalElements());
        Assertions.assertEquals(2,foodAndDrinks.getTotalPages());
        Assertions.assertEquals("Choco đá xay",foodAndDrinks.getContent().get(0).getFadName());
    }

    //test tra ve danh sach khong thanh cong theo ten - 4xxError - LinhDN
    @Test
    public void getListFoodAndDrink_7(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"Lisa","",null,null);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());

    }

    //test tra ve danh sach khong thanh cong theo code - 4xxError - LinhDN
    @Test
    public void getListFoodAndDrink_8(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"","ĐV-007",null,null);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());

    }

    //test tra ve danh sach khong thanh cong theo gia - 4xxError - LinhDN
    @Test
    public void getListFoodAndDrink_9(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"","", (double) 18458,null);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());

    }

    //test tra ve danh sach khong thanh cong theo category - 4xxError - LinhDN
    @Test
    public void getListFoodAndDrink_10(){
        ResponseEntity<Page<FoodAndDrink>> pageResponseEntity
                = this.foodAndDrinkController.viewAllFad(PageRequest.of(0, 2),"","", null,7);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());

    }


}

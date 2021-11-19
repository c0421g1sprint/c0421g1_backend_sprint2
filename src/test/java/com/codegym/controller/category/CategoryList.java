package com.codegym.controller.category;

import com.codegym.controllers.CategoryController;
import com.codegym.entity.food_and_drink.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryList {
    @Autowired
    private CategoryController categoryController;

 //test tra ve danh sach rong - 4xxError - LinhDN
    @Test
    public void getListCategory_1(){
        ResponseEntity<Page<Category>> pageResponseEntity
                = this.categoryController.viewAllCategory(PageRequest.of(0, 2),"","");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }
    //test tra ve danh sach day du khi chua tim kiem - 2xxOK - LinhDN
    @Test
    public void getListCategory_2(){
        ResponseEntity<Page<Category>> pageResponseEntity
                = this.categoryController.viewAllCategory(PageRequest.of(0, 2),"","");
        Page<Category> categories =pageResponseEntity.getBody();
        Assertions.assertEquals(4,categories.getTotalElements());
        Assertions.assertEquals(2,categories.getTotalPages());
        Assertions.assertEquals("Cà phê",categories.getContent().get(0).getCategoryName());
    }

    //test tra ve danh sach day du khi tim kiem code khong thanh cong - 4xxError - LinhDN
    @Test
    public void getListCategory_3(){
        ResponseEntity<Page<Category>> pageResponseEntity
                = this.categoryController.viewAllCategory(PageRequest.of(0, 2),"rgrg","");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    //test tra ve danh sach day du khi tim kiem = code thanh cong - 2xxOK - LinhDN
    @Test
    public void getListCategory_4(){
        ResponseEntity<Page<Category>> pageResponseEntity
                = this.categoryController.viewAllCategory(PageRequest.of(0, 2),"CAF","");

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<Category> categories =pageResponseEntity.getBody();
        Assertions.assertEquals(1,categories.getTotalElements());
        Assertions.assertEquals(1,categories.getTotalPages());
        Assertions.assertEquals("Cà phê",categories.getContent().get(0).getCategoryName());
    }

    //test tra ve danh sach day du khi tim kiem = name thanh cong - 2xxOK - LinhDN
    @Test
    public void getListCategory_5(){
        ResponseEntity<Page<Category>> pageResponseEntity
                = this.categoryController.viewAllCategory(PageRequest.of(0, 2),"","Cà");

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<Category> categories =pageResponseEntity.getBody();
        Assertions.assertEquals(1,categories.getTotalElements());
        Assertions.assertEquals(1,categories.getTotalPages());
        Assertions.assertEquals("Cà phê",categories.getContent().get(0).getCategoryName());
    }

    //test tra ve danh sach day du khi tim kiem = name & code thanh cong - 2xxOK - LinhDN
    @Test
    public void getListCategory_6(){
        ResponseEntity<Page<Category>> pageResponseEntity
                = this.categoryController.viewAllCategory(PageRequest.of(0, 2),"AF","Cà");

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<Category> categories =pageResponseEntity.getBody();
        Assertions.assertEquals(1,categories.getTotalElements());
        Assertions.assertEquals(1,categories.getTotalPages());
        Assertions.assertEquals("Cà phê",categories.getContent().get(0).getCategoryName());
    }

    //test tra ve danh sach day du khi tim kiem = code thanh cong & name khong thanh cong - 4xxError - LinhDN
    @Test
    public void getListCategory_7(){
        ResponseEntity<Page<Category>> pageResponseEntity
                = this.categoryController.viewAllCategory(PageRequest.of(0, 2),"AF","Ga");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    //test tra ve danh sach day du khi tim kiem = code khong thanh cong & name thanh cong - 4xxError - LinhDN
    @Test
    public void getListCategory_8(){
        ResponseEntity<Page<Category>> pageResponseEntity
                = this.categoryController.viewAllCategory(PageRequest.of(0, 2),"AsF","Cà");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }
}

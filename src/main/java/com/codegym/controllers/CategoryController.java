package com.codegym.controllers;

import com.codegym.dto.CategoryDto;
import com.codegym.entity.food_and_drink.Category;
import com.codegym.services.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    //LamNT create category
    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody @Validated CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.saveCategory(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    //LamNT update category
    @PatchMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody @Validated CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.updateCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}

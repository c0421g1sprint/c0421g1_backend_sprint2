package com.codegym.controllers;

import com.codegym.dto.CategoryDto;
import com.codegym.entity.food_and_drink.Category;
import com.codegym.services.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    //LinhDN view all category
    @RequestMapping("/list")
    public ResponseEntity<Page<Category>> viewAllCategory(@PageableDefault(value = 2,sort = "category_id",direction = Sort.Direction.ASC)
                                                          Pageable pageable,@RequestParam(name = "code",required = false) String code,@RequestParam(name="name", required = false) String name){
        Page<Category> categories = categoryService.viewAllCategory(pageable, code, name);
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    //LinhDN delete category
    @PatchMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") Integer id){
        Category category = categoryService.detailCategory(id);
        if (category!=null){
            categoryService.deleteCategory(id);
        }
    }

    //LinhDN xem 1 category
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public ResponseEntity<Category> detailCategory(@PathVariable("id") Integer id){
        Category category = categoryService.detailCategory(id);
        if (category!=null){
            return new ResponseEntity<>(category,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

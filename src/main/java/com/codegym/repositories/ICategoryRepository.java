package com.codegym.repositories;

import com.codegym.entity.food_and_drink.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select category_id, category_name , category_code,delete_flag\n" +
            "from category", nativeQuery = true)
    List<Category> listAllNameCategory();
}

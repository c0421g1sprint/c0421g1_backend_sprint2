package com.codegym.repositories;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface IFoodAndDrinkRepository extends JpaRepository<FoodAndDrink, Integer> {

    //LamNT Create Category
    @Modifying
    @Query(value = "insert into `category` (category_code, category_name) values (?1,?2)", nativeQuery = true)
    void saveCategory(String category_code, String category_name);

    //LamNT Update Category
    @Modifying
    @Query(value = "update `category` set category_code = ?1, category_name = ?2 where (category_id = ?3)", nativeQuery = true)
    void updateCategory(String category_code, String category_name, Integer category_id);
}

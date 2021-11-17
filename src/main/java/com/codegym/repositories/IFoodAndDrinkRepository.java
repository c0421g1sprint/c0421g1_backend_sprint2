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

    //LamNT Create FoodAndDrink
    @Modifying
    @Query(value = "insert into `food_and_drink` (delete_flag, fad_wait_time, fad_code, fad_image, fad_name, fad_price, category_id) " +
            "values (0,3,?1,?2,?3,?4,?5)",
            nativeQuery = true)
    void createFoodAndDrink(String fad_code, String fad_image, String fad_name, Double fad_price, Integer categoryId);

    //LamNT Update FoodAndDrink
    @Modifying
    @Query(value = "update `food_and_drink` set fad_code = ?1, fad_image = ?2," +
            "fad_name = ?3, fad_price = ?4, category_id = ?5 where fad_id = ?6", nativeQuery = true)
    void updateFoodAndDrink(String fad_code, String fad_image, String fad_name, Double fad_price, Integer category_id, Integer fad_id);
}

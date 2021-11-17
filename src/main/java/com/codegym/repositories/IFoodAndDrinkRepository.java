package com.codegym.repositories;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface IFoodAndDrinkRepository extends JpaRepository<FoodAndDrink,Integer> {

    @Query(value="select  * \n" +
            "from food_and_drink fad\n" +
            "inner join category ca on fad.category_id = ca.category_id\n" +
            "where fad.category_id = ?1",nativeQuery = true)
    List<FoodAndDrink> findFoodTheoCategoryById(int categoryId);

    @Query(value = "\n" +
            "select * \n" +
            "from food_and_drink\n" +
            "where fad_id = ?1",nativeQuery = true)
    Optional<FoodAndDrink> findFoodById(int foodId);

    @Query(value = "select * from food_and_drink",nativeQuery = true)
    List<FoodAndDrink>listAllFood();
}

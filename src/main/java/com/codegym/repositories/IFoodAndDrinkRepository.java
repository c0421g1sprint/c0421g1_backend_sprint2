package com.codegym.repositories;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IFoodAndDrinkRepository extends JpaRepository<FoodAndDrink, Integer> {

    //LamNT Create Category
    @Modifying
    @Query(value = "insert into `category` (category_name, category_code) values (?1,?2)", nativeQuery = true)
    void saveCategory(String category_name, String category_code);

    //LamNT Update Category
    @Modifying
    @Query(value = "update `category` set category_name = ?1, category_code = ?2 where (category_id = ?3)", nativeQuery = true)
    void updateCategory(String category_name, String category_code, Integer category_id);

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

    //HaNTT: get top 5 new food
    @Query(value = "SELECT fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id\n" +
            "FROM food_and_drink\n" +
            "WHERE delete_flag = 0\n" +
            "ORDER BY fad_id DESC\n" +
            "LIMIT 5;", nativeQuery = true)
    List<FoodAndDrink> topFiveNewProduct ();

    //HaNTT: get top 5 popular food
    @Query(value = "SELECT fad.fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id, sum(quantity) as poppularIndex\n" +
            "FROM food_and_drink fad\n" +
            "INNER JOIN order_detail od ON fad.fad_id = od.fad_id\n" +
            "WHERE fad.delete_flag = 0\n" +
            "GROUP BY od.fad_id\n" +
            "ORDER BY poppularIndex DESC\n" +
            "LIMIT 5;", nativeQuery = true)
    List<FoodAndDrink> topFivePopularProduct ();
}

package com.codegym.repositories;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    //LinhDN xem chi tiet 1 food
    @Query(value = "select fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id from food_and_drink where delete_Flag = false and fad_id = ?1",
            nativeQuery = true)
    FoodAndDrink viewDetailFad(@Param("id") Integer id);

    //LinhDN xoa 1 food
    @Modifying
    @Query(value = "update `food_and_drink` set delete_Flag = true where fad_id = ?1 ", nativeQuery = true)
    void deleteFad(@Param("id") Integer id);

    //LinhDN hien thi danh sach food
    @Query(value = "select fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id from food_and_drink where delete_Flag = false and (?1 is null or fad_code like %?1%) " +
            "and (?2 is null or fad_name like %?2%) and (?3 is null or fad_price = ?3) and (?4 is null or category_id = ?4)",
            countQuery = "select fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id from food_and_drink where delete_Flag = false and (?1 is null or fad_code like %?1%) " +
                    "and (?2 is null or fad_name like %?2%) and (?3 is null or fad_price = ?3) and (?4 is null or category_id = ?4)",
            nativeQuery = true)
    Page<FoodAndDrink> viewAllFoodAndDrink(Pageable pageable, @Param("code") String code, @Param("name") String name, @Param("price") Double price, @Param("id") Integer id);

    //LinhDN hien thi danh sach food (khong co id)
    @Query(value = "select fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id from food_and_drink where delete_Flag = false and (?1 is null or fad_code like %?1%) " +
            "and (?2 is null or fad_name like %?2%) and (?3 is null or fad_price = ?3) ",
            countQuery = "select fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id from food_and_drink where delete_Flag = false and (?1 is null or fad_code like %?1%) " +
                    "and (?2 is null or fad_name like %?2%) and (?3 is null or fad_price = ?3) ",
            nativeQuery = true)
    Page<FoodAndDrink> viewAllFoodAndDrinkNoId(Pageable pageable, @Param("code") String code, @Param("name") String name, @Param("price") Double price);

    //HaNTT: get top 5 new food
    @Query(value = "SELECT fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id\n" +
            "FROM food_and_drink\n" +
            "WHERE delete_flag = 0\n" +
            "ORDER BY fad_id DESC\n" +
            "LIMIT 5;", nativeQuery = true)
    List<FoodAndDrink> topFiveNewProduct();

    //HaNTT: get top 5 popular food
    @Query(value = "SELECT fad.fad_id, delete_flag, fad_code, fad_image, fad_name, fad_price, fad_wait_time, category_id, sum(quantity) as poppularIndex\n" +
            "FROM food_and_drink fad\n" +
            "INNER JOIN order_detail od ON fad.fad_id = od.fad_id\n" +
            "WHERE fad.delete_flag = 0\n" +
            "GROUP BY od.fad_id\n" +
            "ORDER BY poppularIndex DESC\n" +
            "LIMIT 5;", nativeQuery = true)
    List<FoodAndDrink> topFivePopularProduct();

    //BaoHG
    @Query(value = "select  * \n" +
            "from food_and_drink fad\n" +
            "inner join category ca on fad.category_id = ca.category_id\n" +
            "where fad.category_id = ?1", nativeQuery = true)
    List<FoodAndDrink> findFoodTheoCategoryById(int categoryId);

    //BaoHG
    @Query(value = "\n" +
            "select * \n" +
            "from food_and_drink\n" +
            "where fad_id = ?1", nativeQuery = true)
    Optional<FoodAndDrink> findFoodById(int foodId);

    //BaoHG
    @Query(value = "select * from food_and_drink", nativeQuery = true)
    List<FoodAndDrink> findAllFood();
}

package com.codegym.repositories;

import com.codegym.entity.food_and_drink.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    //LamNT Create Category
    @Modifying
    @Query(value = "insert into `category` (delete_flag, category_name, category_code) values (0,?1,?2)", nativeQuery = true)
    void saveCategory(String category_name, String category_code);

    //LamNT Update Category
    @Modifying
    @Query(value = "update `category` set category_name = ?1, category_code = ?2 where (category_id = ?3)", nativeQuery = true)
    void updateCategory(String category_name, String category_code, Integer category_id);

    //LinhDN showList category
    @Query(value = "select category_id, category_code, category_name, delete_flag from category " +
            "where delete_flag = false and ((?1 is null or category_code like %?1%) and (?2 is null or category_name like %?2%)) ",
            countQuery = "select category_id, category_code, category_name, delete_flag from category " +
                    "where delete_flag = false and ((?1 is null or category_code like %?1%) and (?2 is null or category_name like %?2%)) ",
            nativeQuery = true)
    Page<Category> viewAllCategoryByQuery(Pageable pageable, @RequestParam("code") String code, @RequestParam("name") String name);

    //LinhDN delete category
    @Modifying
    @Query(value = "update `category` set delete_flag = true where (category_id = ?1)", nativeQuery = true)
    void deleteCategory(@Param("id") Integer id);

    //LinhDN xem chi tiet category
    @Query(value = "select category_id, category_code, category_name, delete_flag from category where delete_flag = false and category_id =?1", nativeQuery = true)
    Category viewDetailCategory(@Param("id") Integer id);

    //BaoHG
    @Query(value = "select category_id, category_name , category_code,delete_flag\n" +
            "from category", nativeQuery = true)
    List<Category> listAllNameCategory();
}

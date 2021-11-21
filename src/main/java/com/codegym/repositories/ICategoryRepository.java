package com.codegym.repositories;

import com.codegym.entity.food_and_drink.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

    //LamNT Find All Category
    @Query(value = "select category_id, category_name, category_code, delete_flag from `category`", nativeQuery = true)
    List<Category> findAllCategory();

    //LamNT find By Id
    @Query(value = "select category_id, category_name, category_code, delete_flag " +
            "from `category` where category_id = :id", nativeQuery = true)
    Category findCategoryById(int id);
}

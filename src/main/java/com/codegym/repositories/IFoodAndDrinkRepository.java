package com.codegym.repositories;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IFoodAndDrinkRepository extends JpaRepository<FoodAndDrink,Integer> {
}

package com.codegym.repositories;

import com.codegym.entity.order.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IOrdersRepository extends JpaRepository<Orders,Integer> {
}

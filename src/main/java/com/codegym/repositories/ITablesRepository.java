package com.codegym.repositories;

import com.codegym.entity.table.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITablesRepository extends JpaRepository<Tables,Integer> {
}

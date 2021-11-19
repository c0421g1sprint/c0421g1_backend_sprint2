package com.codegym.repositories;

import com.codegym.entity.employee.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ILevel extends JpaRepository<Level,Integer> {
    @Query(value = "SELECT level_id, level_name FROM level",nativeQuery = true)
    List<Level> findAllLevelByQuery();
}

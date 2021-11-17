package com.codegym.repositories;

import com.codegym.entity.feedback.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IFeedBackRepository extends JpaRepository<FeedBack, Integer> {

    //QuanTA get danh sach feed back theo ngay 13/11/2021
    @Query(value = "select * from feed_back where (?1 is null or feedback_date = ?1)",
            countQuery = "select count(*) from feed_back where (?1 is null or feedback_date = ?1);",nativeQuery = true)
    Page<FeedBack> findAllFeedBackByDate(String feedBackDate, Pageable pageable);
}

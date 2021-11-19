package com.codegym.repositories;

import com.codegym.entity.feedback.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IFeedBackRepository extends JpaRepository<FeedBack, Integer> {
    //DiepLV do create feedback 12/11
    @Modifying
    @Query(value = "insert into feed_back (feedback_id, feedback_code,feedback_content, feedback_creator, feedback_date,feedback_email, " +
            " feedback_image) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void createFeedback(Integer feedback_id, String feedback_code, String feedback_content,
                        String feedback_creator, String feedback_date, String feedback_email, String feedback_image);

    //QuanTA get danh sach feed back theo ngay 13/11/2021
    @Query(value = "select * from feed_back where (?1 is null or feedback_date = ?1)",
            countQuery = "select count(*) from feed_back where (?1 is null or feedback_date = ?1);",nativeQuery = true)
    Page<FeedBack> findAllFeedBackByDate(String feedBackDate, Pageable pageable);

    //QuanTA query findById 1 doi tuong feedback 19/11/2021
    @Query(value= "select * from feed_back where feedback_id = ?;",nativeQuery=true)
    FeedBack findFeedbackById(Integer id);
}

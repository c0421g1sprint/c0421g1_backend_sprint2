package com.codegym.repositories;

import com.codegym.entity.feedback.FeedBack;
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






}

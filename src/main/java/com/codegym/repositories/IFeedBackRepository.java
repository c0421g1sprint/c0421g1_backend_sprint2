package com.codegym.repositories;

import com.codegym.entity.feedback.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IFeedBackRepository extends JpaRepository<FeedBack,Integer> {
}

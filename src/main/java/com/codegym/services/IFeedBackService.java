package com.codegym.services;
import com.codegym.entity.feedback.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IFeedBackService {
    Page<FeedBack> findAllFeedBackByDate(String feedBackDate,Pageable pageable);
    FeedBack findFeedBackById (Integer id);
}

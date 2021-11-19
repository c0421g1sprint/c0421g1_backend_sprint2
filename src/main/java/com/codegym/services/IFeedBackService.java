package com.codegym.services;
import com.codegym.entity.feedback.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IFeedBackService {

    // Diep tao feedback 12/11
    void save(FeedBack feedback);
    //QuanTa
    Page<FeedBack> findAllFeedBackByDate(String feedBackDate,Pageable pageable);
    //QuanTa
    FeedBack findFeedBackById (Integer id);
}

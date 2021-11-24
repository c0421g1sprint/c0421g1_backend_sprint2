package com.codegym.services;
import com.codegym.entity.feedback.FeedBack;


public interface IFeedBackService {

    // Diep tao feedback 12/11
    void save(FeedBack feedback);

    FeedBack findFeedbackByCode(String feedbackCode);


}

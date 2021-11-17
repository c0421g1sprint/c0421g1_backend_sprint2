package com.codegym.services;

import com.codegym.entity.feedback.FeedBack;

import java.util.List;

public interface IFeedBackService {
    // Diep tao feedback 12/11
    void save(FeedBack feedback);
    List<FeedBack> findAllFeedbackByQuery();

}

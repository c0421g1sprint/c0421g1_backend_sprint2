package com.codegym.services.impls;

import com.codegym.entity.feedback.FeedBack;
import com.codegym.repositories.IFeedBackRepository;
import com.codegym.services.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FeedBackServiceImpl implements IFeedBackService {
    @Autowired
    IFeedBackRepository feedBackRepository;


    // diep create feedback 12/11
    @Override
    public void save(FeedBack feedback) {
        this.feedBackRepository.createFeedback(feedback.getFeedbackId(), feedback.getFeedbackCode(),
                feedback.getFeedbackContent(), feedback.getFeedbackCreator(), feedback.getFeedbackDate(),
                feedback.getFeedbackEmail(), feedback.getFeedbackImage());
    }
}


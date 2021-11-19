package com.codegym.services.impls;

import com.codegym.entity.feedback.FeedBack;
import com.codegym.repositories.IFeedBackRepository;
import com.codegym.services.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class FeedBackServiceImpl implements IFeedBackService {
    @Autowired
    IFeedBackRepository feedBackRepository;



    @Override
    public Page<FeedBack> findAllFeedBackByDate(String feedBackDate, Pageable pageable) {
        return this.feedBackRepository.findAllFeedBackByDate(feedBackDate,pageable);
    }
}

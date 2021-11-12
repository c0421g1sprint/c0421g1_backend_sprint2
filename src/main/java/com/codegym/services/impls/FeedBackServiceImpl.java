package com.codegym.services.impls;

import com.codegym.repositories.IFeedBackRepository;
import com.codegym.services.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements IFeedBackService {
    @Autowired
    IFeedBackRepository feedBackRepository;
}

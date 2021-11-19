package com.codegym;

import com.codegym.controllers.FeedBackController;
import com.codegym.entity.feedback.FeedBack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class FeedBackRestController_getListFeedBack {
    @Autowired
    private FeedBackController feedBackController;

    @Test
    public void showListFeedBack_5() {
        ResponseEntity<Page<FeedBack>> pageResponseEntity
                = this.feedBackController.showListFeedBackByDate(PageRequest.of(0, 5),"");

        Assertions.assertEquals(HttpStatus.NOT_ACCEPTABLE, pageResponseEntity.getStatusCode());
    }


    @Test
    public void showListOrder_6() {
        ResponseEntity<Page<FeedBack>> pageResponseEntity
                = this.feedBackController.showListFeedBackByDate(PageRequest.of(0, 5),"null");

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<FeedBack> feedBackPage = pageResponseEntity.getBody();

        Assertions.assertEquals(15, feedBackPage.getTotalElements());
        Assertions.assertEquals(3, feedBackPage.getTotalPages());
        Assertions.assertEquals("20/11/2021", feedBackPage.getContent().get(0).getFeedbackDate());
    }
}

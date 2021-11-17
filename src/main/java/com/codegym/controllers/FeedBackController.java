package com.codegym.controllers;


import com.codegym.dto.FeedBackDto;
import com.codegym.entity.feedback.FeedBack;
import com.codegym.services.IFeedBackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/feed-back")
public class FeedBackController {
    @Autowired

    private IFeedBackService iFeedbackService;

//    @GetMapping("")
//    public ResponseEntity<List<FeedBack>> listFeedback() {
//        List<FeedBack> feedBacks = iFeedbackService.findAllFeedbackByQuery();
//        if (feedBacks.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
//
//    }

    // Diep tao feedback 12/11
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<FeedBack> saveFeedback(@RequestBody @Validated FeedBackDto feedBackDto, BindingResult
            bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            FeedBack feedback = new FeedBack();
            BeanUtils.copyProperties(feedBackDto, feedback);
            this.iFeedbackService.save(feedback);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    IFeedBackService feedBackService;
//    QuanTA codeing back-end search feed back by date 14/11/2021
    @GetMapping(value = "/list-by-date/{feedBackDate}")
    public ResponseEntity<Page<FeedBack>> showListFeedBackByDate(@PageableDefault(value = 5) Pageable pageable,
                                                                 @PathVariable(required = false) String feedBackDate) {
        if (feedBackDate.equals("null")){
            feedBackDate = null;
        }
        Page<FeedBack> feedBackPage = feedBackService.findAllFeedBackByDate(feedBackDate,pageable);
        if (feedBackPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(feedBackPage, HttpStatus.OK);
    }

}

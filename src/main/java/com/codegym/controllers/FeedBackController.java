package com.codegym.controllers;

import com.codegym.dto.FeedBackDto;
import com.codegym.entity.feedback.FeedBack;
import com.codegym.services.IFeedBackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/feed-back")
public class FeedBackController {
    @Autowired
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

    // QuanTA coding findby id feedback 19/11/2021
    @GetMapping(value = "/find-feed-back-by-id/{id}")
    public ResponseEntity<FeedBack> findFeedBackById (@PathVariable(required = false) Integer id){
        if (id == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FeedBack feedBack = this.feedBackService.findFeedBackById(id);
        if (feedBack == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(feedBack, HttpStatus.OK);
        }
    }

    // Diep tao feedback 12/11
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<FeedBack> saveFeedback(@RequestBody @Validated FeedBackDto feedBackDto, BindingResult
            bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            FeedBack feedback = new FeedBack();
            BeanUtils.copyProperties(feedBackDto, feedback);
            this.feedBackService.save(feedback);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}

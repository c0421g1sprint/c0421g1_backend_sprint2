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



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/feed-back")
public class FeedBackController {
    @Autowired

    private IFeedBackService iFeedbackService;


    // Diep tao feedback 12/11
    @PostMapping("/add")
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
    @GetMapping("/find-feedback-code")  //OK (check Feedback duplicate)
    public ResponseEntity<FeedBack> isFeedbackCodeDuplicated(@RequestParam(name = "feedbackCode", required = false) String feedbackCode) {
        FeedBack feedBack = this.iFeedbackService.findFeedbackByCode(feedbackCode);

        if (feedBack == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
    }
}

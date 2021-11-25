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
            String prefix = "FEB-";
            String postNumb = String.valueOf((int)(Math.random()*8900) + 1000);

            BeanUtils.copyProperties(feedBackDto, feedback);
            feedback.setFeedbackCode(prefix + postNumb);
            this.iFeedbackService.save(feedback);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}

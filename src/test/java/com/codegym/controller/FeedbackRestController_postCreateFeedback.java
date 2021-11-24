//package com.codegym.controller;
//
//import com.codegym.dto.FeedBackDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class FeedbackRestController_postCreateFeedback {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void createFeedback_feedbackCode_13() throws Exception {
//        FeedBackDto feedbackDto = new FeedBackDto();
//        feedbackDto.setFeedbackCode(null);
//        feedbackDto.setFeedbackCreator("Le Van Diep");
//        feedbackDto.setFeedbackDate("2021-11-11");
//        feedbackDto.setFeedbackContent("Noi dung ok");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/feed-back/add")
//                .content(this.objectMapper.writeValueAsString(feedbackDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_feedbackCreator_18() throws Exception {
//        FeedBackDto feedbackDto = new FeedBackDto();
//        feedbackDto.setFeedbackCreator("Le Van Diep");
//        feedbackDto.setFeedbackCode("FEB-9878");
//        feedbackDto.setFeedbackEmail("diep@gmail.com");
//        feedbackDto.setFeedbackImage("https://statics.vinpearl.com/quan-cafe-dep-o-sai-gon-anh-3_1633053940.jpg");
//        feedbackDto.setFeedbackDate("2021-11-11");
//        feedbackDto.setFeedbackContent("Noi dung ok");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/feed-back/add")
//                .content(this.objectMapper.writeValueAsString(feedbackDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    @Test
//    public void createFeedback_feedbackCode() throws Exception {
//        FeedBackDto feedbackDto = new FeedBackDto();
//        feedbackDto.setFeedbackContent("ok");
//        feedbackDto.setFeedbackCreator("Le Van Diep");
//        feedbackDto.setFeedbackDate("2021-11-11");
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/feed-back/add")
//                .content(this.objectMapper.writeValueAsString(feedbackDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//}

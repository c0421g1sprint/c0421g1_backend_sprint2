package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedBackDto {
    // Diep tạo dto

    private Integer feedbackId;

    private String feedbackCode;

    private String feedbackCreator;

    private String feedbackEmail;

    private String feedbackContent;

    private String feedbackDate;

    private String feedbackImage;
}

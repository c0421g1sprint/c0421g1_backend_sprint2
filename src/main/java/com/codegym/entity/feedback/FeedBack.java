package com.codegym.entity.feedback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="feed_back")

public class FeedBack {
    @Id
    @GenericGenerator(name = "sequence_feedback_id",parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "FEB-"),strategy = "com.codegym.entity.feedback.FeedBackIdGenerator")
    @GeneratedValue(generator = "sequence_feedback_id")
    @Column(name = "feedback_id",unique=true,nullable=false)
    private Integer feedbackId;

    private String feedbackCode;

    private String feedbackCreator;

    private String feedbackEmail;

    private String feedbackContent;

    private String feedbackDate;

    private String feedbackImage;


}

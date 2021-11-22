package com.codegym.email_java.email;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
public class EmailSenderImpl implements EmailSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSenderImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void send(String toEmail, String contentEmail) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            messageHelper.setText(contentEmail, true);
            messageHelper.setFrom("c0421g1@gmail.com");
            messageHelper.setSubject("Confirm email From C0421G1");
            messageHelper.setTo(toEmail);
            mailSender.send(mimeMessage);
        } catch (MessagingException exception) {
            LOGGER.error(exception.getMessage());
        }
    }

    @Override
    public String buildRegisterEmail(String link) {
        return "<h3 style=\"text-align: center\">XÁC NHẬN TÀI KHOẢN</h3>\n" +
                "<p>Chúc mừng bạn đã trở thành thành viên của quán cafe chúng tôi</p>\n" +
                "<p>Hãy click vào link " + link + "  để xác thực tài khoản của bạn</p>";
    }

    @Override
    public String buildForgetPassEmail(String randomPass) {
        return "<h3 style=\"text-align: center\">Hello</h3>\n" +
                "<p>Mật khẩu của bạn là:  " + randomPass + "  </p>";
    }

}
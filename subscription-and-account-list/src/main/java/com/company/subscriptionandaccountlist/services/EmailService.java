package com.company.subscriptionandaccountlist.services;

import com.company.subscriptionandaccountlist.repositories.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(String to, String text, String subject) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(text);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("noreply@gmail.com");

            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException e){
            throw new IllegalStateException("Failed to send email");
        }

    }

}
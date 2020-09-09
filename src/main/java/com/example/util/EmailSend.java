package com.example.util;

import com.example.SpringContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by pengsh on 09/08 11:30
 */
public class EmailSend {

    private static String[] to = new String[]{"709177344@qq.com", "401547843@qq.com"};

    public static void send(String title, String content) {
        JavaMailSender javaMailSender = SpringContextHolder.get(JavaMailSender.class);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
        try {
            messageHelper.setFrom("709177344@qq.com");
            messageHelper.setTo(to);
            messageHelper.setSubject(title);
            messageHelper.setText(content, true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(mimeMessage);
    }


}

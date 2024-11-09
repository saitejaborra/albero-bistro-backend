package com.albero.restro.service;

import com.albero.restro.model.Mailbody;
import com.albero.restro.repository.MailBodyRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    public JavaMailSender mailSender;
    public MimeMessage mimeMessage;

    @Autowired
    public MailBodyRepository mailBodyRepository;

    @Autowired
    public Environment env;

    public void SendEmail(Mailbody mailBody) throws MessagingException{

        mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setTo("tejapatel2709@gmail.com");
            helper.setSubject(mailBody.getSubject());
            helper.setText(mailBody.getMessage());
            mailBodyRepository.save(mailBody);
//            mailSender.send(mimeMessage);

    }
}

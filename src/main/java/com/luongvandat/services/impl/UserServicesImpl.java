package com.luongvandat.services.impl;

import com.luongvandat.entities.User_;
import com.luongvandat.repositories.UserRepository;
import com.luongvandat.services.UserServices;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class UserServicesImpl implements UserServices {
    private final UserRepository userRepository;

    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User_ findOneById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User_ add(User_ user_) {
        return userRepository.save(user_);
    }

    @Override
    public User_ deleteById(String id) {
        User_ user_ = findOneById(id);
        userRepository.deleteById(id);
        return user_;
    }

    @Override
    public User_ update(User_ user_) {
        return userRepository.save(user_);
    }

    @Override
    public User_ findUser_ByUserEmail(String email) {
        return userRepository.findUser_ByUserEmail(email);
    }

    @Override
    public void sendEmail(String email, String text) {
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "neesson620@gmail.com";
        String password = "fqcoxhtsxnrvuxsu";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(text);
            message.setText("[LEAF BOOK] Thank you for believing in us! We will try our best to serve you!");
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User_> find10Users(int offset) {
        return userRepository.find10Users(offset);
    }

    @Override
    public List<User_> search10UserByPhone(String phoneNumber, int offset) {
        return userRepository.search10UserByPhone(phoneNumber,offset);
    }

    @Override
    public int countUser_sBy() {
        return userRepository.countUser_sBy();
    }

    @Override
    public User_ findUser_ByUserPhoneNumber(String phoneNumber) {
        return userRepository.findUser_ByUserPhoneNumber(phoneNumber);
    }
    @Override
    public User_ findUser_ByUserId(String userId){
        return userRepository.findUser_ByUserId(userId);
    }
}
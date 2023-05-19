package com.edu.iuh.services;

import com.edu.iuh.entities.User_;

import java.util.List;

public interface UserServices {
    User_ findOneById(String id);

    User_ add(User_ user_);

    User_ deleteById(String id);

    User_ update(User_ user_);

    User_ findUser_ByUserEmail(String email);

    void sendEmail(String email, String text);

    List<User_> find10Users(int offset);
    List<User_> search10UserByPhone(String phoneNumber, int offset);

    int countUser_sBy();
    User_ findUser_ByUserPhoneNumber(String phoneNumber);
    User_ findUser_ByUserId(String userId);
}
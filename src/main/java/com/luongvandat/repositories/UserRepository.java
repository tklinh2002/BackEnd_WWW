package com.luongvandat.repositories;

import com.luongvandat.entities.User_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
//@CrossOrigin(origins = "http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")

public interface UserRepository extends JpaRepository<User_, String> {
    User_ findUser_ByUserEmail(String email);

    @Query(value = "SELECT * FROM user_ ORDER BY role_role_id ASC OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
    List<User_> find10Users(int offset);
    @Query(value = "SELECT * FROM user_ where user_phone_number like '%'+?1+'%' ORDER BY role_role_id ASC OFFSET ?2 ROWS FETCH NEXT 10 ROWS ONLY",nativeQuery = true)
    List<User_> search10UserByPhone(String phoneNumbers,int offset);

    int countUser_sBy();
    User_ findUser_ByUserPhoneNumber(String phoneNumber);
    User_ findUser_ByUserId(String userId);
}
package com.edu.iuh.controllers;

import com.edu.iuh.entities.Role;
import com.edu.iuh.entities.User_;
import com.edu.iuh.services.RoleServices;
import com.edu.iuh.services.UserServices;
import com.edu.iuh.utils.PasswordBasedEncryption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/user_s")
public class UserController {
    private final UserServices userServices;
    private final RoleServices roleServices;

    public UserController(UserServices userServices, RoleServices roleServices) {
        this.userServices = userServices;
        this.roleServices = roleServices;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User_ userDto) {
        if (userServices.findUser_ByUserEmail(userDto.getUserEmail()) != null) {
            return ResponseEntity.ok("ERROR: User with email " + userDto.getUserEmail() + " already exists.");
        }

        User_ user = new User_();
        user.setUserName(userDto.getUserName());

        String salt = PasswordBasedEncryption.getSaltValue(10);
        String hashPwd = PasswordBasedEncryption.generateSecurePassword(userDto.getUserPassword(), salt);
        user.setUserPassword(hashPwd + salt);
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserLastName(userDto.getUserLastName());
        user.setUserPhoneNumber(userDto.getUserPhoneNumber());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserCreatedDate(new Date());
        user.setUserUpdatedDate(new Date());

        Role role = roleServices.findOneById(userDto.getRole().getRoleId());
        user.setRole(role);

        User_ savedUser = userServices.add(user);
        return ResponseEntity.ok("SUCCESS: User with email " + savedUser.getUserEmail() + " has been successfully registered !");
    }

    @GetMapping(value = "/mail")
    public ResponseEntity<String> sendEmail(@RequestParam("email") String email, @RequestParam("text") String text) {
        userServices.sendEmail(email, text);
        return ResponseEntity.ok("SUCCESS: Email has been sent to " + email + " !");
    }

    @PutMapping("/updateUser")
    ResponseEntity<String> updateUser(@RequestBody User_ userDto){
//        System.out.println(userDto.getUserPhoneNumber());
//        if(userServices.findUser_ByUserPhoneNumber(userDto.getUserPhoneNumber())!=null){
//            System.out.println("lan2");
//            return ResponseEntity.ok("ERROR: Phone number already exists.");
//        }
        User_ user = userServices.findUser_ByUserEmail(userDto.getUserEmail());

        user.setUserName(userDto.getUserName());
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserLastName(userDto.getUserLastName());
        user.setUserPhoneNumber(userDto.getUserPhoneNumber());
        Role role = roleServices.findOneById(userDto.getRole().getRoleId());
        user.setRole(role);

        userServices.update(user);
        return ResponseEntity.ok("SUCCESS: User with email has been successfully update !");
    }

    @DeleteMapping("/deleteUser")
    ResponseEntity<String> deleteUser(@RequestParam String email){
        System.out.println(email);
        User_ user = userServices.findUser_ByUserEmail(email);
        System.out.println("user");
        userServices.deleteById(user.getUserId());
        return ResponseEntity.ok("delete user successful");
    }

    @GetMapping("/verifyPassword")
    ResponseEntity<Boolean> hashPassword(String password, String hash, String salt){
        // in method get '+' to ' '
        hash = hash.replace(" ", "+");
        boolean result = PasswordBasedEncryption.verifyUserPassword(password, hash, salt);
        return ResponseEntity.ok(result);
    }

}
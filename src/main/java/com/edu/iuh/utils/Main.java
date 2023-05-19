package com.edu.iuh.utils;

public class Main {
    public static void main(String[] args) {
        String salt = PasswordBasedEncryption.getSaltValue(10);
        System.out.println(salt);
        String str =PasswordBasedEncryption.generateSecurePassword("pass123456", salt);
        System.out.println(str);
//        UEaXuYJvSdCZdO+i6s6NUFCdK4irYHFuTuz14CfSYKQ=
//        dhln9

//        boolean b = PasswordBasedEncryption.verifyUserPassword("12345678", "UEaXuYJvSdCZdO+i6s6NUFCdK4irYHFuTuz14CfSYKQ=","dhln9");
//        System.out.println(b);
    }
}

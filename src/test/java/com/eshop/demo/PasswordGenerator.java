package com.eshop.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Ani Poghosyan on 14/02/2022
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "codejava";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}

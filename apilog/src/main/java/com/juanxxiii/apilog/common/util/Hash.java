package com.juanxxiii.apilog.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hash {
    public String codificar(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA3-256");

            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();

            password= Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }
}

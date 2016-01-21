package com.doomphantoom.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Trung on 12/21/2015.
 */
public class DoomPasswordEncoder implements PasswordEncoder {
    public String encode(CharSequence charSequence) {
        try {
            return encodeByMd5(charSequence.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean matches(CharSequence charSequence, String s) {
        try {
            String passwordEncoded= encodeByMd5(charSequence.toString());
            return passwordEncoded.equals(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String encodeByMd5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}

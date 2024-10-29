package com.example.compsciwork;
import java.util.regex.Pattern;

public class InfoValidator {

    public InfoValidator(){}

    public Boolean CheckUsername(String username){
        return username != null && username.trim().length() >= 5;
    }

    public Boolean CheckEmail(String email){
        return email != null && Pattern.matches("^.{3,}@.+[.].*$",email);
    }

    public Boolean CheckPassword(String password){
        return password != null && password.trim().length() >= 8;
    }
}
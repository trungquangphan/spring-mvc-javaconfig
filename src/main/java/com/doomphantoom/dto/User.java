package com.doomphantoom.dto;

import com.doomphantoom.validation.constraint.ValidState;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertTrue;

/**
 * Created by doomphantom on 23/10/2015.
 * I use 3 ways to validate 'state' and 'country' value which is the typical example of cross field validation.
 * + Use isValid() that annotated by constraints annotation, ex: @AssertTrue;
 * + Define annotation at class level (@Target=ElementType.TYPE) and only validate User as a acceptable type.
 * + Define annotation at class level (@Target=ElementType.TYPE) and specify the fieldnames that its value need to be validated.
 */
//@ValidState
@ValidState(country = "country", state = "state")
public class User {
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String state;
    private String country;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    @AssertTrue(message = "US country need to have state")
//    private boolean isValid() {
//        if (country.equals("US")) {
//            return !state.equals("");
//        } else {
//            return true;
//        }
//    }
}

package com.doomphantoom.service;

import com.doomphantoom.dto.UserAuthentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Trung on 12/21/2015.
 */
public class UserService implements UserDetailsService {
    private static Map<String,UserAuthentication> userDetailList= new Hashtable<>();
    static {
        User trung=new User("trung","c2d8730c4cdd662573b0214a0183bf98",getAuthrotiy());
        User quang=new User("quang","2b10351253eed030812674e8aa18a5ab",getAuthrotiy());
        User phan=new User("phan","abba8340466a1b7ddc56c287821923af",getAuthrotiy());
        UserAuthentication trungAuthentication =new UserAuthentication(trung);
        UserAuthentication quangAuthentication =new UserAuthentication(quang);
        UserAuthentication phanAuthentication =new UserAuthentication(phan);
        userDetailList.put("trung",trungAuthentication);
        userDetailList.put("quang", quangAuthentication);
        userDetailList.put("phan", phanAuthentication);
    }

    private static Collection<? extends GrantedAuthority> getAuthrotiy() {
        Collection collection=new ArrayList();
        collection.add(new SimpleGrantedAuthority("ROLE_USER"));
        return collection;
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(userDetailList.containsKey(userName)){
            UserAuthentication userDetails = userDetailList.get(userName);
            return (User)userDetails.getDetails();
        }else{
            throw new UsernameNotFoundException("Invalid credential");
        }
    }
}

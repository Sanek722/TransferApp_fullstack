package com.example.Security_Servis.Service;

import com.example.Security_Servis.Model.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserdataService implements UserDetailsService {

    private  static final String key = "user";
    @Autowired
    private RedisTemplate<String, Userdata> redisTemplate;
    GeneratedId generatedId = new GeneratedId();

    public void saveUser(Userdata user) {
        String temp = generatedId.getValue();
        user.setId(temp);
        redisTemplate.opsForHash().put(key, user.getUsername(), user);
    }

    public Userdata getUser(String username) {
        return (Userdata) redisTemplate.opsForHash().get(key, username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userdata userdata = getUser(username);

        if (userdata == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Возвращаем объект UserDetails, используя информацию о пользователе из redis
        return org.springframework.security.core.userdetails.User
                .withUsername(userdata.getUsername())
                .password(userdata.getPassword())
                .roles(userdata.getRole())
                .build();
    }
}

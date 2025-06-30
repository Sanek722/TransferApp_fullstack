package com.example.Security_Servis.Model;

import com.example.Security_Servis.Service.CustomAuthorityDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("Userdata")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Userdata implements UserDetails
{
    private String id;
    private String username;
    private String password;
    private String role;

    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role));
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
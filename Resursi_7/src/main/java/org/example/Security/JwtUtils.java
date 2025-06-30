package org.example.Security;

import io.jsonwebtoken.Claims;
import org.example.models.Userdata;

public class JwtUtils {

    public static Userdata generate(Claims claims) {
        final Userdata jwtInfoToken = new Userdata();
        jwtInfoToken.setRole(getRole(claims));
        jwtInfoToken.setUsername(claims.getSubject());
        jwtInfoToken.setId(getid(claims));
        return jwtInfoToken;
    }

    private static String getRole(Claims claims) {
        final String role = claims.get("role", String.class);
        return role;
    }
    private static Integer getid(Claims claims) {
        final String id = claims.get("id", String.class);
        return Integer.parseInt(id);
    }

}

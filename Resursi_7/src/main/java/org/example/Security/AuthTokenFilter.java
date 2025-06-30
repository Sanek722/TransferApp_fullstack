package org.example.Security;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.example.models.Userdata;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;
    AuthTokenFilter(JwtTokenProvider jwtTokenProvider)
    {
        this.jwtTokenProvider=jwtTokenProvider;
    }

    private String extractAuthToken(HttpServletRequest request) {
        // Извлечение токена из параметра запроса
        String token = request.getHeader("token");
        return token;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            String authToken = extractAuthToken((HttpServletRequest) request);

            if (authToken != null && jwtTokenProvider.validateToken(authToken)) {
                Claims claims = jwtTokenProvider.getClaims(authToken);
                Userdata userdata = JwtUtils.generate(claims);

                userdata.setAuthenticated(true);
                SecurityContextHolder.getContext().setAuthentication(userdata);
            }
        } catch (Exception e) {
            logger.error("Ошибка при обработке токена аутентификации", e);
        }

        chain.doFilter(request, response);

    }
}


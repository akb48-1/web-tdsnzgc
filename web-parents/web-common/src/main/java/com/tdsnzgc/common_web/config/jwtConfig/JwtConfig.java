package com.tdsnzgc.common_web.config.jwtConfig;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

@Configuration
public class JwtConfig {

    @Value("tokenKey")
    public String tokenKey;

    @Bean
    public Algorithm getAlgorithm() throws UnsupportedEncodingException {

        return Algorithm.HMAC256(tokenKey);
    }
}

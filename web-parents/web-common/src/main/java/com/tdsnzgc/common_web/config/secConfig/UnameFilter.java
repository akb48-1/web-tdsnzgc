package com.tdsnzgc.common_web.config.secConfig;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tdsnzgc.common_web.config.jwtConfig.JwtConfig;
import com.tdsnzgc.common_web.config.responseUtil.ResponseUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class UnameFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hres = (HttpServletResponse) res;
        try {
            Object token = hreq.getHeader("token");

            if(token == null) {
                chain.doFilter(req, res);
                return;
            }
            AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JwtConfig.class);

            Algorithm algorithm = annotationConfigApplicationContext.getBean("getAlgorithm", Algorithm.class);

            Map<String, Claim> result = verify(algorithm, token.toString());


            UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(result.get("username").asString(),"", AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            SecurityContextHolder.getContext().setAuthentication(upat);
            chain.doFilter(req, res);
        } catch (TokenExpiredException e) {
            ResponseUtil.write(hres, 500, false, "tonken已失效, 请重新登录", "");
            e.printStackTrace();
        } catch (SignatureVerificationException e) {
            ResponseUtil.write(hres, 500, false, "tonken验证失败, 请重新登录", "Signature");
            e.printStackTrace();
        }  catch (JWTDecodeException e) {
            ResponseUtil.write(hres, 500, false, "tonken验证失败, 请重新登录", "JWID");
            e.printStackTrace();
        } catch (Exception e) {
            chain.doFilter(req, res);
            e.printStackTrace();
        }
    }

    private Map<String, Claim> verify(Algorithm algorithm, String token) {
        DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
        return decodedJWT.getClaims();
    }
}

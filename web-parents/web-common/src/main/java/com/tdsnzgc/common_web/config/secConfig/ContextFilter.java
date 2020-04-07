package com.tdsnzgc.common_web.config.secConfig;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ContextFilter extends SecurityContextPersistenceFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
        chain.doFilter(req, res);
    }
}

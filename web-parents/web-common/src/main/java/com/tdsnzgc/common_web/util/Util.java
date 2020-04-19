package com.tdsnzgc.common_web.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class Util {
    public static String getUserName() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

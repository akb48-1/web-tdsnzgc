package com.tdsnzgc.common_web.config.responseUtil;


import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static void write(HttpServletResponse response, int code, Boolean success, String message, Object data) {

        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");

            writer = response.getWriter();

            Map<String, Object> result = new HashMap<>();
            result.put("code", code);
            result.put("success", success);
            result.put("message", message);
            result.put("data", data);

            writer.write(new Gson().toJson(result));
        } catch (IOException e) {
            writer.write(new Gson().toJson("JSON解析错误"));
            e.printStackTrace();
        }
    }


}

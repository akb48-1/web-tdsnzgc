package com.tdsnzgc.common_web.config.resultUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String message;
    private Integer code;
    private Boolean success;
    private T data;
}

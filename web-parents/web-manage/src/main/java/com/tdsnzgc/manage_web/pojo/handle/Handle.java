package com.tdsnzgc.manage_web.pojo.handle;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Handle extends BaseEntity {
    BigInteger id;
    String name;
    String value;
    Integer index;
    Integer type;
    BigInteger parent_id;
}

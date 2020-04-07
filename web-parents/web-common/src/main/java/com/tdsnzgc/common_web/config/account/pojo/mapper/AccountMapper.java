package com.tdsnzgc.common_web.config.account.pojo.mapper;

import com.tdsnzgc.common_web.config.account.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {

    @Select("select * from t_users where username = #{username}")
    Account selectAccount(@Param("username") String username);
}

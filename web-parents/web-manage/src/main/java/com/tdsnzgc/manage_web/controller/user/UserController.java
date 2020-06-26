package com.tdsnzgc.manage_web.controller.user;

import com.tdsnzgc.common_web.config.account.pojo.Account;
import com.tdsnzgc.common_web.config.account.service.AccountService;
import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.manage_web.pojo.organ.Organ;
import com.tdsnzgc.manage_web.service.organ.OrganService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户Controller")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    AccountService accountService;

    @Autowired
    OrganService organService;

    @ApiOperation("查询用户信息")
    @PostMapping("/queryUserInfoByToken")
    public Result queryUserInfoByToken(@RequestHeader(name ="token") String token) {

        Account userInfo = accountService.getUserInfo(token);


        if(userInfo != null) {
            Organ organ = organService.queryById(new BigInteger(userInfo.getOrgan_ids()));

            Map userMap = new HashMap();
            userMap.put("user_id", userInfo.getUser_id());
            userMap.put("username", userInfo.getUsername());
            userMap.put("organ_ids", userInfo.getOrgan_ids());
            userMap.put("organ_name", organ.getOrgan_name());
            return new ResultUtil().setData(userMap);
        }
        return new ResultUtil().setErrorMsg("获取用户信息失败");
    }

}

package com.tdsnzgc.manage_web.controller;

import com.tdsnzgc.common_web.config.account.pojo.Account;
import com.tdsnzgc.common_web.config.account.service.AccountService;
import com.tdsnzgc.common_web.config.redisConfig.RedisUtil;
import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.controller.CommonController;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@Api(tags = "欢迎")
public class Hello {

    @Autowired
    CommonController commonController;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    AccountService accountService;

    @ApiOperation(value="发出笑声", notes="根据url的id来发出笑声")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "uid",value = "用户id", paramType = "path"),
        @ApiImplicitParam(name = "username", value = "用户名",paramType = "query", defaultValue = "参数的默认值")
    })
    @RequestMapping(value = "/haha/{uid}", method = RequestMethod.POST)
    public Map index(
            @PathVariable(name = "uid") String id,
            @RequestParam(name = "username") String username) {

        Logger logger = Logger.getLogger(Hello.class);

        logger.info("打印日志");
        Map map = new HashMap<String, String>();
        map.put("a", "he");
        map.put("id", id);
        map.put("username", username);
        return map;
    }

    @ApiOperation("调用兄弟模块方法")
    @RequestMapping(value = "/readCommon", method = RequestMethod.GET)
    public String readCommon() {
        return commonController.index();
    }

    @ApiOperation("通过token得到用户信息")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Result checkRedis(@RequestHeader(name = "token") String token) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.getUserInfo(token);
        return new ResultUtil().setData(account);
    }



}

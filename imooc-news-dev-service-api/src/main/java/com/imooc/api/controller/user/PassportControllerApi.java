package com.imooc.api.controller.user;

import com.imooc.grace.result.GraceJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

@Api(value = "用于用户注册登录" , tags = "登录功能的Controller")
public interface PassportControllerApi {
    @ApiOperation(value = "短信验证码", notes = "短信验证码", httpMethod = "GET")
    @GetMapping("/getSMSCode")
    public GraceJSONResult getResult();
}

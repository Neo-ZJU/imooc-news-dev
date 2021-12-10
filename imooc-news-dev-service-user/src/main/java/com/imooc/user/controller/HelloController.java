package com.imooc.user.controller;

import com.imooc.api.controller.user.HelloControllerApi;
import com.imooc.grace.result.IMOOCJSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloControllerApi {


    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    public Object hello(){
        //System.out.println("test");
        logger.info("debug hello");
        logger.error("testError");
        logger.warn("testWarn");
        return IMOOCJSONResult.errorMsg("未知错误");
    }

}

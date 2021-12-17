package com.imooc.user.controller;

import com.imooc.api.controller.user.PassportControllerApi;
import com.imooc.grace.result.GraceJSONResult;
import com.imooc.utils.SMSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassportController implements PassportControllerApi {
    private Logger logger = LoggerFactory.getLogger(PassportController.class);
    @Autowired
    private SMSUtils smsUtils;

    @Override
    public GraceJSONResult getResult() {
        String randomCode;
        String mobile;
        smsUtils.sendSMS("123456", " ");
        return GraceJSONResult.ok();
    }
}

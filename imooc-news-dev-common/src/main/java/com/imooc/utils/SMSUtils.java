package com.imooc.utils;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.imooc.utils.extend.AliyunResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSUtils {
    @Autowired
    private AliyunResource aliyunResource;

    public void sendSMS(String mobile, String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliyunResource.getAccessKeyID(),
                aliyunResource.getAccessKeySecret());//自己账号的AccessKey信息
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();

        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");//短信服务的服务接入地址
        request.setSysVersion("2017-05-25");//API的版本号
        request.setSysAction("SendSms");//API的名称
        request.putQueryParameter("PhoneNumbers", mobile);//接收短信的手机号码
        request.putQueryParameter("SignName", "阿里大于测试专用");//短信签名名称
        request.putQueryParameter("TemplateCode", "SMS_209335004");//短信模板ID
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code  + "\"}");//短信模板变量对应的实际值
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}

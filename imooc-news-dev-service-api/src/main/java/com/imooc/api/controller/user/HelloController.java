package com.imooc.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public interface HelloController {
    @GetMapping("/hello")
    public Object hello();
}

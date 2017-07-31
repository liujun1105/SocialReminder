package com.cgnuo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SRDebugService {

    private Logger logger = LoggerFactory.getLogger(SRDebugService.class);

    @RequestMapping("/status")
    public String status() {
        return "success";
    }
}

package com.study.demo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.demo.service.inter.DubboService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService implements DubboService {

    @Reference(interfaceClass = DubboService.class, version = "1.0.0", check=false)
    private DubboService dubboService;

    @Override
    public String addOneData(String str) {
        return dubboService.addOneData("小舒");
    }
}

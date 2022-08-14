package com.study.demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.demo.service.inter.DubboService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = DubboService.class, version = "1.0.0", timeout = 15000)
//dubbo:servie interface="" version="" ref="" timeout=""
public class DubboServiceImpl implements DubboService {

    @Override
    public String addOneData(String name) {
        return "插入" + name + "成功";
    }
}
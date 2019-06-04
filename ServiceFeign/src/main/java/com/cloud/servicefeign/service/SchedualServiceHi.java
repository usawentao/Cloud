package com.cloud.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 添加feign接口，该功能为调用其他模块的借口（可抽象化为后端模块之间的调用）
 */
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {
    @GetMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}

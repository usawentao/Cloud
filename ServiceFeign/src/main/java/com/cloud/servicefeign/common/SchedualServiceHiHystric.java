package com.cloud.servicefeign.common;

import com.cloud.servicefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * 因为涉及模块之间的通信，所以在不同模块之间通讯不通，则需要在自身作出回调响应，因此该类就得implement接口类了，并且作出响应。
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name){
        return "sorry "+name;
    }
}

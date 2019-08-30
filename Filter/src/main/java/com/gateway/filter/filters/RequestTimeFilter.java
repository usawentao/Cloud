package com.gateway.filter.filters;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


//自定义过滤器
public class RequestTimeFilter implements GatewayFilter, Ordered {
    private static final Log log = LogFactory.getLog(GatewayFilter.class);
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
        exchange.getAttributes().put(REQUEST_TIME_BEGIN,System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(()->{
                    //记录请求的开始时间，并保存在ServerWebExchange中
                    Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                    if(startTime != null){
                        //在控制台打印访问时间
                        log.info(exchange.getRequest().getURI().getRawPath() + ":" +(System.currentTimeMillis() - startTime)+ "ms");
                    }
                })
        );
    }

    //给过滤器设定优先级别，值越大则优先级越低
    @Override
    public int getOrder(){
        return 0;
    }
}

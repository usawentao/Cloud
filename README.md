# Cloud
微服务
简介：微服务初步搭建以及简单的示例<br>
1、父级模块:chapter1<br>
2、服务注册中心:eurekaserver<br>
3、服务:client<br>
4、初步负载均衡：ribbon<br>
5、因为feign默认集成了ribbon并且支持可插拔以及自带<font color=red>断路由</font>的属性，因此在今后的使用中将直接使用feign。并且使用feign可以直接通过接口指定路由来进行后端各个<font color=red>模块之间的调用</font>。

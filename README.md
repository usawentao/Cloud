# Cloud
##微服务
###简介：微服务初步搭建以及简单的示例<br>
1、**【parent功能模块：】**该模块就是一个普通的maven模块，主要是管理每个模块的parent标签来继承管理公用的依赖。父级模块:chapter1<br>
2、**【服务注册中心：】**服务的注册与发现。服务注册中心:eurekaserver<br>
3、**【服务提供者：】**进行服务的提供。服务:client<br>
4、**【ribbon功能模块：】**在微服务中，因为业务每个功能被独立成一个服务，服务与服务之间的通信是基于http restful的。Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。此处的功能模块使用ribbon实现初步负载均衡：ribbon<br>
5、**【feign功能模块：】**主要应用于负载均衡。因为feign默认集成了ribbon并且支持可插拔以及自带<font color=red>**断路由**</font>的属性，因此在今后的使用中将直接使用feign。并且使用feign可以直接通过接口指定路由来进行后端各个<font color=red>**模块之间的调用**</font>。<br>
6、**【Hystrix功能模块：】**为了避免线程阻塞带来的服务器“雪崩”现象。springcloud引用Hystrix组件来进行断路由，以此模式模型来进行避免线程阻塞所带来的致命的问题。

# Cloud
## 微服务<br>
### 简介：微服务初步搭建以及简单的示例<br>
1、【parent功能模块】该模块就是一个普通的maven模块，主要是管理每个模块的parent标签来继承管理公用的依赖。父级模块:chapter1<br>
2、【服务注册中心】服务的注册与发现。服务注册中心:eurekaserver<br>
3、【服务提供者】进行服务的提供,并向中心进行注册。服务:client<br>
4、【ribbon功能模块】在微服务中，因为业务每个功能被独立成一个服务，服务与服务之间的通信是基于http restful的。Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。此处的功能模块使用ribbon实现初步负载均衡：ribbon<br>
5、【feign功能模块】主要应用于负载均衡。因为feign默认集成了ribbon并且支持可插拔以及自带<font color=red>**断路由**</font>的属性，因此在今后的使用中将直接使用feign。并且使用feign可以直接通过接口指定路由来进行后端各个<font color=red>**模块之间的调用**</font>。<br>
6、【Hystrix功能模块】为了避免线程阻塞带来的服务器“雪崩”现象。springcloud引用Hystrix组件来进行断路由，以此模式模型来进行避免线程阻塞所带来的致命的问题。<br>
7、【Zuul功能模块】Zuul的主要功能是路由转发和过滤器。zuul本身已经集成了hystrix和ribbon，所以zuul天生自带**线程隔离**和**断路由**的功能。<br>
8、【config配置中心】微服务一般是集群式的服务集群，因此考虑到服务的数量繁多，为了方便管理统一配置，我们便需要一个分布式配置中心组件Spring Cloud Config来进行配置管理。组件的组成：config server和config client。<br>
9、【Spring Cloud Bus微服务通讯】顾名思义即可清楚该组件应用于微服务之间的相互作用，可用于微服务之间的：通讯、监控。<br>


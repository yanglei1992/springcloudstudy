
eureka.client.register-with-eureka ：表示是否将自己注册到Eureka Server，默认为true。
eureka.client.fetch-registry ：表示是否从Eureka Server获取注册信息，默认为true。
eureka.client.serviceUrl.defaultZone ：设置与Eureka Server交互的地址，查询服务和注册服务都需要依赖这个地址。默认是http://localhost:8761/eureka ；多个地址可使用 , 分隔
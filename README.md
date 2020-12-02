# dubbo-nacos-shop 里边有一些参考的案例
- shop-api-api: 服务对外暴露的API，可能会包含一些通用的Model类
- shop-api-common: 一些通用的业务逻辑，抽取到该模块
- shop-api-service: 服务接口的实现类，同时对外暴露dubbo接口
- shop-api-webapp: 管理后台相关，包含对应的controller，前端代码等

#maven依赖关系
- shop-api-service: 依赖shop-api-api、shop-api-common
- shop-api-webapp：依赖shop-api-api、shop-api-common

> shop-api-webapp千万不能依赖hop-api-service 因为 shop-api-webapp 没有db连接

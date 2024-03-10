package com.atguigu.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *   1、如何使用nacos配置中心统一管理配置
 *
 *   1）、引入依赖
 *         <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *         </dependency>
 *       注意：spring boot2.4.x以上的还需要引用
 *         <dependency>
 *             <groupId>org.springframework.cloud</groupId>
 *             <artifactId>spring-cloud-starter-bootstrap</artifactId>
 *             <version>3.1.0</version>
 *         </dependency>
 *   2）、创建一个boorstrap.properties
 *      spring.application.name=gulimall-coupon
 *      spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 *   3)、需要给配置中心默认添加一个数据集 （data id）gulimall-coupon.properties。默认规则：应用名.properties
 *   4)、给 应用名.properties 添加任何配置
 *   5）、动态获取配置
 *        @RefreshScope： 动态获取并刷新配置
 *        @Value("${配置项的名}")： 获取到配置
 *        如果配置中心和当前应用的配置文件都配置了相同的项，优先使用配置中心的配置
 *
 *  2、细节
 *    1）、命名空间：配置隔离：
 *    默认：public(保留空间)：默认新增的所有配置都在public空间
 *    1、开发、测试、生产，利用命名空间来做环境隔离
 *    注意：在bootstrap.properties配置上需要使用哪个命名空间下的配置
 *    spring.cloud.nacos.config.namespace=7ba2be8d-5de1-46b8-998c-639b155cfd66
 *    2、每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有位置
 *
 *  3、同时加载多个配置集
 *    1）、微服务任何配置信息，任何配置文件都可以放在配置中心里
 *    2）、只需在bootstrap.properties说明加载配置中心的那些配置文件即可
 *    3）、@Value，@ConfigurationProperties...
 *    以前springboot任何方法从配置文件中获取值，都能使用
 *    配置中心有的优先使用配置中心的
 */

@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}

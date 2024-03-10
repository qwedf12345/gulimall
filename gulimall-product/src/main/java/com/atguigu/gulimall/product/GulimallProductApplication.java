package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 *   1、整合mybatis-plus
 *   1)、导入依赖
 *   2）、配置
 *         1、配置数据源：
 *            1）、导入数据库驱动
 *            2）、在application.yml配置数据源相关信息
 *         2、配置mybatisplus
 *            1)、使用@mapperscan
 *            2)、告诉mybatisplus，sql映射文件的位置
 *
 *
 * 2、mybatisplus逻辑删除可以去看官方文档很详细
 *   1）、配置全局的逻辑删除规则（省略）
 *   2）、配置逻辑删除的组件bean（省略）
 *   3）、给bean加上逻辑删除注解@TableLogic
 *
 * 3、JSR303
 *    注意：高版本的要引入依赖
 *   1)、给bean添加校验注解：javax.validation.constraints,并定义自己的message提示
 *   2）、开启校验功能@Valid
 *      效果：校验错误以后会有默认的响应
 *   3）、给校验的bean后紧跟一个bindingResult，就可以获取到校验的结果
 *   4）、分组校验(多场景复杂校验）
 *        1）、@NotBlank(message = "品牌名必须提交",groups = {UpdateGroup.class,AddGroup.class})
 *        给校验注解标注什么情况需要校验
 *        2)、@Validated({AddGroup.class})
 *   5）、自定义校验
 *        1）、编写一个自定义的校验注解
 *        2）、编写一个自定义的校验器ConstraintValidator
 *        3）、关联自定义的校验器和自定义的校验注解
 *        @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
 *        @Retention(RetentionPolicy.RUNTIME)
 *        @Documented
 *        @Constraint(
 *         validatedBy = {ListValueConstraintValidator.class}
 *         [可以使用不同的校验器校验]
 * )
 *
 *   4、统一的异常处理
 * @ControllerAdvice
 * 1）、编写异常处理类，使用@ControllerAdvice
 * 2）、使用@ExceptionHandler标注方法可以处理的异常
 */

@EnableFeignClients(basePackages = "com.atguigu.gulimall.product.feign")
@EnableDiscoveryClient
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}

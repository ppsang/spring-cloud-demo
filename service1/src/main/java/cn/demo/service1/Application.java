package cn.demo.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: Leo
 * @Blog: http://blog.csdn.net/lc0817
 * @CreateTime: 2016/11/21 23:01
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "cn.demo.service1")
@EnableFeignClients // rpc 调用
@EnableWebMvc
@EnableEurekaClient // 开启服务注册与发现
@EnableCircuitBreaker // 断路器
@EnableHystrixDashboard // 服务降级 服务熔断 线程隔离 请求缓存 请求合并 服务监控
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

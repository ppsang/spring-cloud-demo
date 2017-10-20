package cn.demo.service1.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.demo.service1.client.fallback.factory.Service2FallbackFactory;

@FeignClient(name = "service2", fallbackFactory = Service2FallbackFactory.class)
public interface Service2Client {

	@RequestMapping("/test2")
	String getResult();
}

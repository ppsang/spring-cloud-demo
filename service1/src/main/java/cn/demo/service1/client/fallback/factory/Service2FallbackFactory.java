package cn.demo.service1.client.fallback.factory;

import java.util.Date;

import org.springframework.stereotype.Component;

import cn.demo.service1.client.Service2Client;
import feign.hystrix.FallbackFactory;

@Component
public class Service2FallbackFactory implements FallbackFactory<Service2Client>{

	@Override
	public Service2Client create(Throwable throwable) {

		return new Service2Client() {
			
			@Override
			public String getResult() {
				return String.format("create fallbackFactory, %s", new Date());
			}
		};
	}

}

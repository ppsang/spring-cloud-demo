package cn.demo.reverseProxy.filter;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyPreFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyPreFilter.class);
	
	private static final int ERROR_CODE = 401; 
	@Override
	public Object run() {
		// 设置过滤器的实现规则
		/**
		 * 处理拦截的请求
		 */
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		// 记录请求的方法和路径
		LOGGER.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
		String token = request.getParameter("token");
		if (token != null) {
			LOGGER.warn("token is empty!");
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(ERROR_CODE);
			Writer writer = null;
			try {
				writer = requestContext.getResponse().getWriter();
				writer.write("the token is empty!");
				writer.flush();
			} catch (IOException e) {
				LOGGER.error("requestContext write error, errorMsg:{}", e);
			} finally {
//				try {
//					writer.close();
//				} catch (IOException e) {
//					LOGGER.error("write.close() has error, the errorMsg:{}", ExceptionUtils.getStackTrace(e)); 
//				}
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						LOGGER.error("write.close() has error, the errorMsg:{}", e);
					}
				}
			}
			return null;
		}
		LOGGER.info("the token is not null, token is:{}", token);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 设置该请求是否需要进行过滤
		return true;
	}

	@Override
	public int filterOrder() {
		// 设置过滤的顺序
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		/**
		 * 定义了四种不同的生命周期的过滤器类型
		 * pre - 路由之前
		 * routing - 路由之时
		 * post 路由之后
		 * error 发送错误调用
		 */
		return "pre";
	}

}

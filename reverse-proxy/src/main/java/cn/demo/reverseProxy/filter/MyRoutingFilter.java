package cn.demo.reverseProxy.filter;

import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.lang3.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class MyRoutingFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String token = request.getParameter("token");
		if (token != null) {
			requestContext.setSendZuulResponse(false);
			// 
			requestContext.setResponseStatusCode(500);
		}
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "routing";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}

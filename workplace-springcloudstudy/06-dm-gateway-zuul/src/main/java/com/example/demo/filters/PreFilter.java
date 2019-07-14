package com.example.demo.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter{

	@Override
	public String filterType() {
		// 过滤器类型
		// pre  route  post  error
//		return FilterConstants.PRE_TYPE;
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// 同类型过滤器之间：数越小，优先级越高
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		// 过滤器是否发挥作用
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String key = request.getParameter("key");
		System.out.println(key + " access filter 1");
		if ("1".equals(key)) {
			ctx.setSendZuulResponse(false);
		} else {
			ctx.set("thirdFilter", false);
		}
		return null;
		/*
		 * String token = request.getHeader("token");
		 * if (token == null || "".equals(token)) { ctx.setSendZuulResponse(false);
		 * ctx.setResponseStatusCode(401); ctx.
		 * setResponseBody("{\"msg\":\"401,access without permission,please login first.\"}"
		 * ); return "access denied"; } return "pass";
		 */
	}
}

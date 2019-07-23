package com.example.demo.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ThirdFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		System.out.println(ctx.get("thirdFilter"));
		return ctx.sendZuulResponse() && (Boolean) ctx.get("thirdFilter");
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String key = request.getParameter("key");
		System.out.println(key + " access filter 3");
		if ("3".equals(key)) {
			ctx.setSendZuulResponse(false);
		}
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 3;
	}

}

package com.nt.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulRoutFilter extends ZuulFilter {

	private Logger logger=LoggerFactory.getLogger(ZuulRoutFilter.class);
	
	public ZuulRoutFilter() {
		System.out.println("===================================");
		System.out.println("ZuulRoutFilter.ZuulRoutFilter()");
		System.out.println("===================================");
	}
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		logger.info("-- Routing filter is executing --");
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest req=context.getRequest();
//		logger.info("current Raouting host :: "+context.getRouteHost());
		logger.info("current request uri :: "+req.getRequestURI());
		logger.info("request path :: "+req.getServletPath());
		logger.info("request method :: "+req.getMethod());
		logger.info("request data containt ::"+req.getContentType());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}

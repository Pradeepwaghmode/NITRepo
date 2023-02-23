package com.nt.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulErrorFilter extends ZuulFilter {

	private Logger logger=LoggerFactory.getLogger(ZuulErrorFilter.class);
	
	public ZuulErrorFilter() {
		System.out.println("===================================");
		System.out.println("ZuulErrorFilter.ZuulErrorFilter()");
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
		logger.info("-- Error filter is executing --");
		RequestContext context=RequestContext.getCurrentContext();
		Throwable thr=context.getThrowable();
		logger.error("current Raouting host :: "+context.getRouteHost().toString());
		logger.error("Exception meassage ::"+thr.getMessage());
		logger.error("Exception type :: "+thr);
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 3;
	}

}

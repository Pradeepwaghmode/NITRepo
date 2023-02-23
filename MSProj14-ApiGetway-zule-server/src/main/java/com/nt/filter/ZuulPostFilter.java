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
public class ZuulPostFilter extends ZuulFilter {

	private Logger logger=LoggerFactory.getLogger(ZuulPostFilter.class);
	
	public ZuulPostFilter() {
		System.out.println("===================================");
		System.out.println("ZuulPostFilter.ZuulPostFilter()");
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
		logger.info("-- Post filter is executing --");
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletResponse res=context.getResponse();
//		logger.info("current Raouting host :: "+context.getRouteHost().toString());
		logger.info("response status code ::"+res.getStatus());
		logger.info("containt type :: :: "+res.getContentType());
		logger.info("response header :: "+res.getHeader("host"));
		logger.info("response server name :: "+res.getHeader("server"));
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
		return 2;
	}

}

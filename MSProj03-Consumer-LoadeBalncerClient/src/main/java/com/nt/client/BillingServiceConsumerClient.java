package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceConsumerClient {

	@Autowired
	private LoadBalancerClient client;

	public String getBillingInfo() {

		ServiceInstance intance = client.choose("BILLING_INFO");

		URI uri = intance.getUri();

		String url = uri.toString() + "/billing/api/info";

		RestTemplate template = new RestTemplate();

		ResponseEntity<String> res = template.exchange(url, HttpMethod.GET, null, String.class);

		return res.getBody();
	}
}

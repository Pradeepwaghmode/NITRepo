package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class SamplerConfiguration {

	@Bean(name="restTemplate")
	public RestTemplate createTemplate() {
		return new RestTemplate();
	}
	
	@Bean(name="samplar")
	public Sampler createSampler() {
		return  Sampler.ALWAYS_SAMPLE;
	}
}

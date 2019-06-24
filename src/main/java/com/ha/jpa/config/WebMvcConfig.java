package com.ha.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.ha.jpa.sys.ApiVersionRequestMappingHandlerMapping;

@Configuration
public class WebMvcConfig extends DelegatingWebMvcConfiguration {

	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new ApiVersionRequestMappingHandlerMapping("v");
	}
}

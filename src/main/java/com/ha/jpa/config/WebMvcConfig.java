package com.ha.jpa.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.ha.jpa.sys.ApiVersionRequestMappingHandlerMapping;

public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new ApiVersionRequestMappingHandlerMapping("v");
	}
}

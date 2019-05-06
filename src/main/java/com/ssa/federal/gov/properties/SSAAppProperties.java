package com.ssa.federal.gov.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ssa")
@Data
public class SSAAppProperties {
           public SSAAppProperties() {
        	   System.out.println("SSAAppProperties.SSAAppProperties()");
           }
	private Map<String, String> properties = new HashMap<String, String>();

	public Map<String, String> getSssProps() {
		return properties;
	}

	public void setSssProps(Map<String, String> sssProps) {
		this.properties = sssProps;
	}

	@Override
	public String toString() {
		return "SSAAppProperties [properties=" + properties + "]";
	}
	
}

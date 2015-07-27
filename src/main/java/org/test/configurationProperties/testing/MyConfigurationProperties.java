package org.test.configurationProperties.testing;

import java.util.ArrayList;
import java.util.List;

import org.notmy.library.CustomType;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("org.test")
public class MyConfigurationProperties {

	private final List<String> easy = new ArrayList<>();
	private final List<CustomType> customTypes = new ArrayList<>();

	public List<String> getEasy() {
		return easy;
	}

	public List<CustomType> getCustomTypes() {
		return customTypes;
	}
}

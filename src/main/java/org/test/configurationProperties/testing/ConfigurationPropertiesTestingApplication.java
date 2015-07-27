package org.test.configurationProperties.testing;

import java.beans.PropertyEditorSupport;

import org.notmy.library.CustomType;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

@SpringBootApplication
@EnableConfigurationProperties
public class ConfigurationPropertiesTestingApplication {
	public static class CustomTypePropertyEditor extends PropertyEditorSupport {
		@Override
		public String getAsText() {
			final CustomType value = (CustomType) getValue();
			return value == null ? "" : value.getValue();
		}

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(CustomType.builder().withValue(text).build());
		}
	}

	@Bean
	@ConditionalOnProperty("org.test.customConverter")
	public DefaultConversionService conversionService() {
		final DefaultConversionService result = new DefaultConversionService();

		result.addConverter(new Converter<String, CustomType>() {

			@Override
			public CustomType convert(String source) {
				return CustomType.builder().withValue(source).build();
			}
		});
		return result;
	}

	@Bean
	@ConditionalOnProperty("org.test.propertyEditor")
	public CustomTypePropertyEditor customTypePropertyEditor() {
		return new CustomTypePropertyEditor();
	}

	@Bean
	@ConditionalOnProperty("org.test.customEditorConfigurer")
	public CustomEditorConfigurer customEditorConfigurer() {
		final CustomEditorConfigurer result = new CustomEditorConfigurer();
		result.setPropertyEditorRegistrars(new PropertyEditorRegistrar[] { new PropertyEditorRegistrar() {

			@Override
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(CustomType.class,
						new CustomTypePropertyEditor());
			}
		} });
		return result;
	}

	@Bean
	public MyConfigurationProperties myConfigurationProperties() {
		return new MyConfigurationProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationPropertiesTestingApplication.class, args);
	}
}

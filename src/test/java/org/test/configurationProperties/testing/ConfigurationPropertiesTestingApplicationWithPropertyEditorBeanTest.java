package org.test.configurationProperties.testing;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring Boot section 24.7.2 "Relaxed binding" says:
 *
 * <pre>
 * If you need custom type conversion you can provide a ConversionService bean (with bean id conversionService) or custom property editors (via a CustomEditorConfigurer bean).
 * </pre>
 *
 * For good measure, we test a lone PropertyEditor bean, though I am unclear how it could ever be associated with the proper type.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConfigurationPropertiesTestingApplication.class)
@IntegrationTest({ "org.test.easy[0]=foo", "org.test.easy[1]=bar",
		"org.test.easy[2]=baz", "org.test.customTypes[0]=foo",
		"org.test.customTypes[1]=bar", "org.test.customTypes[2]=baz",
		"org.test.propertyEditor=true" })
public class ConfigurationPropertiesTestingApplicationWithPropertyEditorBeanTest extends
		AbstractConfigurationPropertiesTestingApplicationTest {
}

package org.test.configurationProperties.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractConfigurationPropertiesTestingApplicationTest {
	private @Autowired MyConfigurationProperties myConfigurationProperties;

	@Test
	public void testHaveProperties() {
		assertNotNull(myConfigurationProperties);
	}

	@Test
	public void testEasy() {
		assertEquals(3, myConfigurationProperties.getEasy().size());
		assertEquals("foo", myConfigurationProperties.getEasy().get(0));
		assertEquals("bar", myConfigurationProperties.getEasy().get(1));
		assertEquals("baz", myConfigurationProperties.getEasy().get(2));
	}

	@Test
	public void testCustomTypes() {
		assertEquals(3, myConfigurationProperties.getCustomTypes().size());
		assertEquals("foo", myConfigurationProperties.getCustomTypes().get(0).getValue());
		assertEquals("bar", myConfigurationProperties.getCustomTypes().get(1).getValue());
		assertEquals("baz", myConfigurationProperties.getCustomTypes().get(2).getValue());
	}
}

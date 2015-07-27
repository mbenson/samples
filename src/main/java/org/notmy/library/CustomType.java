package org.notmy.library;

import org.springframework.util.Assert;

/**
 * Deliberately convoluted type representing complex third-party code.
 */
public class CustomType {
	public static class Builder {
		private String value;

		private Builder() {
		}

		public Builder withValue(String value) {
			this.value = value;
			return this;
		}

		public CustomType build() {
			Assert.notNull(value);
			final CustomType result = new CustomType();
			result.value = value;
			return result;
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	private String value;

	private CustomType() {
	}

	public String getValue() {
		return value;
	}

}

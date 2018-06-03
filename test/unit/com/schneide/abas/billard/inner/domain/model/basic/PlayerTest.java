package com.schneide.abas.billard.inner.domain.model.basic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Second tests
 */
public class PlayerTest {

	@Test
	public void remembersName() {
		final String expectedName = "remembered name";
		final Player target = new Player(
				expectedName,
				irrelevant());
		assertThat(target.name()).isEqualTo(expectedName);
	}

	private static <T> T irrelevant() {
		return null;
	}
}

package com.schneide.abas.billard.inner.domain.model.basic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SuitTest {

	@Test
	public void hasFourSuits() {
		assertThat(Suit.values()).hasSize(4);
	}
}

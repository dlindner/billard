package com.schneide.abas.billard.inner.domain.model.composite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Fourth tests
 */
public class TableTest {

	@Test
	public void beginsEmpty() {
		final Table target = new Table();
		assertThat(target.ballCount()).isZero();
	}

	@Test
	public void placesAllBalls() {
		final Table target = new Table();
		target.place(BallSet.create());
		assertThat(target.ballCount()).isEqualTo(16);
	}

	@Test
	public void canBeCleared() {
		final Table target = new Table();
		target.place(BallSet.create());
		target.clear();
		assertThat(target.ballCount()).isZero();
	}
}

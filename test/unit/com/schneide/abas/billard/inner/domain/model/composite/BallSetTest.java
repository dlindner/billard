package com.schneide.abas.billard.inner.domain.model.composite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.schneide.abas.billard.inner.domain.model.basic.Ball;

/**
 * Third tests
 */
public class BallSetTest {

	@Test
	public void containsSixteenBalls() {
		final BallSet target = BallSet.create();
		assertThat(target).hasSize(16);
	}

	@Test
	public void containsFullSet() {
		final BallSet target = BallSet.create();
		assertThat(target).containsExactly(
				Ball.createFor(0),
				Ball.createFor(1),
				Ball.createFor(2),
				Ball.createFor(3),
				Ball.createFor(4),
				Ball.createFor(5),
				Ball.createFor(6),
				Ball.createFor(7),
				Ball.createFor(8),
				Ball.createFor(9),
				Ball.createFor(10),
				Ball.createFor(11),
				Ball.createFor(12),
				Ball.createFor(13),
				Ball.createFor(14),
				Ball.createFor(15));
	}
}

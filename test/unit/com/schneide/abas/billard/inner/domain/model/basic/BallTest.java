package com.schneide.abas.billard.inner.domain.model.basic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BallTest {

	@Test
	public void specificiesWhiteBall() {
		assertThat(
				Ball.white.hasSuit(Suit.white))
				.isTrue();
		assertThat(
				Ball.createFor(0).hasSuit(Suit.white))
				.isTrue();
	}

	@Test
	public void specifiesBlackBall() {
		assertThat(
				Ball.createFor(8).hasSuit(Suit.black))
				.isTrue();
	}

	@Test
	public void specifiesFullSuits() {
		assertThat(
				Ball.createFor(5).hasSuit(Suit.full))
				.isTrue();
	}

	@Test
	public void specifiesHalfSuits() {
		assertSuitFor(Ball.createFor(9), Suit.half);
		assertSuitFor(Ball.createFor(10), Suit.half);
		assertSuitFor(Ball.createFor(15), Suit.half);
	}

	private void assertSuitFor(Ball ball, Suit expected) {
		assertThat(
				ball.hasSuit(expected))
				.isTrue();
	}
}

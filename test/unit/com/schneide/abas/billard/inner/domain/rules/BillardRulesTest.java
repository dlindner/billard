package com.schneide.abas.billard.inner.domain.rules;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import com.schneide.abas.billard.inner.domain.model.basic.Ball;
import com.schneide.abas.billard.inner.domain.model.basic.Suit;
import com.schneide.abas.billard.inner.domain.model.composite.BallSet;

/**
 * Seventh tests - With bugfixes!
 */
public class BillardRulesTest {

	@Test
	public void noBallGotPocketed() {
		final BillardRules target = new BillardRules();
		final StrikeResult result = target.evaluateStrike(
				irrelevant(),
				Collections.emptyList(),
				BallSet.size);
		assertThat(result.state()).isEqualTo(GameState.ongoing);
		assertThat(result.successor()).isEqualTo(NextPlayer.change);
	}

	@Test
	public void whiteBallGotPocketed() {
		final BillardRules target = new BillardRules();
		final StrikeResult result = target.evaluateStrike(
				irrelevant(),
				Arrays.asList(Ball.white),
				BallSet.size);
		assertThat(result.state()).isEqualTo(GameState.ongoing);
		assertThat(result.successor()).isEqualTo(NextPlayer.change);
	}

	@Test
	public void blackBallGotPocketedNotAsLastBall() {
		final BillardRules target = new BillardRules();
		final StrikeResult result = target.evaluateStrike(
				irrelevant(),
				Arrays.asList(Ball.createFor(8)),
				BallSet.size);
		assertThat(result.state()).isEqualTo(GameState.lost);
	}

	@Test
	public void wrongSuitGotPocketed() {
		final BillardRules target = new BillardRules();
		final StrikeResult result = target.evaluateStrike(
				Suit.half,
				Arrays.asList(Ball.createFor(6)),
				BallSet.size);
		assertThat(result.state()).isEqualTo(GameState.ongoing);
		assertThat(result.successor()).isEqualTo(NextPlayer.change);
	}

	@Test
	public void correctSuitGotPocketed() {
		final BillardRules target = new BillardRules();
		final StrikeResult result = target.evaluateStrike(
				Suit.half,
				Arrays.asList(Ball.createFor(10)),
				BallSet.size);
		assertThat(result.state()).isEqualTo(GameState.ongoing);
		assertThat(result.successor()).isEqualTo(NextPlayer.stay);
	}

	@Test
	public void correctSuitAndWhiteGotPocketed() {
		final StrikeResult result = strikeFor(
				Suit.half,
				Ball.createFor(10),
				Ball.white);
		assertThat(result.state()).isEqualTo(GameState.ongoing);
		assertThat(result.successor()).isEqualTo(NextPlayer.change);
	}

	@Test
	public void correctAndWrongSuitGotPocketed() {
		final StrikeResult result = strikeFor(
				Suit.half,
				Ball.createFor(10),
				Ball.createFor(6));
		assertThat(result.state()).isEqualTo(GameState.ongoing);
		assertThat(result.successor()).isEqualTo(NextPlayer.change);
	}

	@Test
	public void blackGotPocketedAsLastBallAlongWithWhite() {
		final StrikeResult result = strikeFor(
				irrelevant(),
				0,
				Ball.createFor(8),
				Ball.white);
		assertThat(result.state()).isEqualTo(GameState.won);
	}

	@Test
	public void blackGotPocketedAsLastBall() {
		final StrikeResult result = strikeFor(
				irrelevant(),
				1,
				Ball.createFor(8));
		assertThat(result.state()).isEqualTo(GameState.won);
	}

	@Test
	public void blackGotPocketedWithOtherBalls() {
		final StrikeResult result = strikeFor(
				irrelevant(),
				12,
				Ball.createFor(12),
				Ball.createFor(8));
		assertThat(result.state()).isEqualTo(GameState.lost);
	}

	private StrikeResult strikeFor(
			Suit requiredSuit,
			Ball... pocketedBalls) {
		return strikeFor(
				requiredSuit,
				BallSet.size,
				pocketedBalls);
	}

	private StrikeResult strikeFor(
			Suit requiredSuit,
			int remainingBalls,
			Ball... pocketedBalls) {
		final BillardRules target = new BillardRules();
		return target.evaluateStrike(
				requiredSuit,
				Arrays.asList(pocketedBalls),
				remainingBalls);
	}

	private static <T> T irrelevant() {
		return null;
	}
}

package com.schneide.abas.billard.inner.domain.rules;

import com.schneide.abas.billard.inner.domain.model.basic.Ball;
import com.schneide.abas.billard.inner.domain.model.basic.Suit;

public class BillardRules {

	public BillardRules() {
		super();
	}

	public ShotResult evaluateStrike(
			Suit playerSuit,
			Iterable<Ball> pocketedBalls,
			int remainingBalls) {
		if (!pocketedBalls.iterator().hasNext()) {
			return resultFor(GameState.ongoing, NextPlayer.change);
		}
		if (0 == remainingBalls) {
			return resultFor(GameState.won, NextPlayer.change);
		}
		for (Ball each : pocketedBalls) {
			if (each.hasSuit(Suit.black)) {
				return resultFor(GameState.lost, NextPlayer.change);
			}
			if (each.hasSuit(Suit.white)
					|| !each.hasSuit(playerSuit)) {
				return resultFor(GameState.ongoing, NextPlayer.change);
			}
		}
		return resultFor(GameState.ongoing, NextPlayer.stay);
	}

	private ShotResult resultFor(
			final GameState state,
			final NextPlayer next) {
		return new ShotResult() {
			@Override
			public NextPlayer successor() {
				return next;
			}
			@Override
			public GameState state() {
				return state;
			}
		};
	}
}

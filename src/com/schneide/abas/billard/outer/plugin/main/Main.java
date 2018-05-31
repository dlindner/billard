package com.schneide.abas.billard.outer.plugin.main;

import java.util.Random;

import com.schneide.abas.billard.inner.domain.model.basic.Player;
import com.schneide.abas.billard.inner.domain.model.composite.BallSet;
import com.schneide.abas.billard.inner.domain.model.composite.Game;
import com.schneide.abas.billard.inner.domain.model.composite.Players;
import com.schneide.abas.billard.inner.domain.model.composite.Table;

public final class Main {

	private Main() {
		super();
	}

	public static void main(String[] arguments) throws InterruptedException {
		final Random randomness = new Random(132L);

		final Players players = new Players(
				Player.randomBy(randomness),
				Player.randomBy(randomness));
		final Table playfield = new Table();

		final Game game = new Game(players, playfield);

		final BallSet balls = BallSet.create();
		game.startWith(balls);

		while (true) {
			game.turn();
			Thread.sleep(100L);
		}

	}
}

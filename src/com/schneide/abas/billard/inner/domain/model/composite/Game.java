package com.schneide.abas.billard.inner.domain.model.composite;

import java.util.HashMap;
import java.util.Map;

import com.schneide.abas.billard.inner.domain.model.basic.Ball;
import com.schneide.abas.billard.inner.domain.model.basic.Player;
import com.schneide.abas.billard.inner.domain.model.basic.Suit;

public class Game {

	private final Players players;
	private final Table table;
	private final Map<Suit, Player> suitAssociation;

	public Game(
			Players players,
			Table table) {
		super();
		this.players = players;
		this.table = table;
		this.suitAssociation = associateSuitsTo(players);
	}

	private Map<Suit, Player> associateSuitsTo(Players currentPlayers) {
		final Map<Suit, Player> result = new HashMap<>();
		result.put(Suit.full, currentPlayers.first());
		result.put(Suit.half, currentPlayers.second());
		return result;
	}

	public Game startWith(BallSet balls) {
		this.table.clear();
		this.table.place(balls);
		return this;
	}

	public void turn() {
		final Player activePlayer = this.players.current();
		final Iterable<Ball> pocketed = this.table.strikeBy(activePlayer);
		final int remainingBalls = this.table.ballCount();
		System.out.println(activePlayer + ": " + pocketed + " >> remaining: " + remainingBalls);
	}
}

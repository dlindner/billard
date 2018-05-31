package com.schneide.abas.billard.inner.domain.model.composite;

import java.util.HashMap;
import java.util.Map;

import com.schneide.abas.billard.inner.domain.model.basic.Ball;
import com.schneide.abas.billard.inner.domain.model.basic.Player;
import com.schneide.abas.billard.inner.domain.model.basic.Suit;
import com.schneide.abas.billard.inner.domain.rules.BillardRules;
import com.schneide.abas.billard.inner.domain.rules.GameState;
import com.schneide.abas.billard.inner.domain.rules.ShotResult;

public class Game {

	private final Players players;
	private final Table table;
	private final Map<Player, Suit> suitAssociation;
	private final BillardRules rules;

	public Game(
			Players players,
			Table table,
			BillardRules rules) {
		super();
		this.players = players;
		this.table = table;
		this.rules = rules;
		this.suitAssociation = associateSuitsTo(players);
	}

	private Map<Player, Suit> associateSuitsTo(Players currentPlayers) {
		final Map<Player, Suit> result = new HashMap<>();
		result.put(currentPlayers.first(), Suit.full);
		result.put(currentPlayers.second(), Suit.half);
		return result;
	}

	public Game startWith(BallSet balls) {
		this.table.clear();
		this.table.place(balls);
		return this;
	}

	public boolean turn() {
		final Player activePlayer = this.players.current();
		final Iterable<Ball> pocketed = this.table.strikeBy(activePlayer);
		System.out.println(activePlayer + " pockets " + pocketed);
		final int remainingBalls = this.table.ballCount();
		final ShotResult turnResult = this.rules.evaluateStrike(
				this.suitAssociation.get(activePlayer),
				pocketed,
				remainingBalls);
		String additionalInfo = "";
		if (GameState.ongoing != turnResult.state()) {
			additionalInfo = " for " + activePlayer;
		}
		System.out.println("The game is " + turnResult.state() + additionalInfo);
		turnResult.successor().applyTo(this.players);
		return (GameState.ongoing == turnResult.state());
	}
}

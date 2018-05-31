package com.schneide.abas.billard.inner.domain.model.composite;

public class Game {

	private final Players players;
	private final Table table;

	public Game(
			Players players,
			Table table) {
		super();
		this.players = players;
		this.table = table;
	}

	public Game startWith(BallSet balls) {
		this.table.clear();
		this.table.place(balls);
		return this;
	}
}

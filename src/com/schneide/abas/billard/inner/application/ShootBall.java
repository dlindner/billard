package com.schneide.abas.billard.inner.application;

import com.schneide.abas.billard.inner.domain.model.composite.Game;

public class ShootBall {

	public ShootBall() {
		super();
	}

	public void in(Game game) {
		game.turn();


	}

}

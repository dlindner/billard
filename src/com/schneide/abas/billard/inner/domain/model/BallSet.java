package com.schneide.abas.billard.inner.domain.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BallSet implements Iterable<Ball> {

	private final List<Ball> balls;

	private BallSet() {
		super();
		this.balls = new ArrayList<>();
	}

	private void add(Ball ball) {
		this.balls.add(ball);
	}

	public static BallSet create() {
		final BallSet result = new BallSet();
		for (int i = 0; i < 16; i++) {
			result.add(Ball.createFor(i));
		}
		return result;
	}

	@Override
	public Iterator<Ball> iterator() {
		return this.balls.iterator();
	}
}

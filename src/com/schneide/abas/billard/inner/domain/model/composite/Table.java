package com.schneide.abas.billard.inner.domain.model.composite;

import java.util.HashSet;
import java.util.Set;

import com.schneide.abas.billard.inner.domain.model.basic.Ball;

public class Table {

	private final Set<Ball> placed;

	public Table() {
		super();
		this.placed = new HashSet<>();
	}

	public void clear() {
		this.placed.clear();
	}

	public void place(BallSet balls) {
		balls.forEach(this.placed::add);
	}

	@Override
	public String toString() {
		return "Table with " + this.placed.size() + " balls";
	}
}

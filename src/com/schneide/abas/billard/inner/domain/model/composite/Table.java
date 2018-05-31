package com.schneide.abas.billard.inner.domain.model.composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.schneide.abas.billard.inner.domain.model.basic.Ball;
import com.schneide.abas.billard.inner.domain.model.basic.Player;

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

	public Iterable<Ball> strikeBy(Player activePlayer) {
		final List<Ball> result = new ArrayList<>();
		for (Ball each : this.placed) {
			//System.out.println("Calculating for " + each);
			if (activePlayer.ability().isPocketed(each)) {
				result.add(each);
			}
		}
		this.placed.removeAll(result);
		return result;
	}

	public int ballCount() {
		return this.placed.size();
	}

	@Override
	public String toString() {
		return "Table with " + this.placed.size() + " balls";
	}
}

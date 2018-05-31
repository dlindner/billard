package com.schneide.abas.billard.inner.domain.model.composite;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.schneide.abas.billard.inner.domain.model.basic.Player;

public class Players implements Iterator<Player> {

	private final List<Player> asList;
	private volatile int currentIndex;

	public Players(Player one, Player two) {
		super();
		this.asList = Arrays.asList(one, two);
		this.currentIndex = 0;
	}

	public Player current() {
		return this.asList.get(currentIndex % 2);
	}

	public Player next() {
		this.currentIndex++;
		return current();
	}

	@Override
	public boolean hasNext() {
		return true;
	}
}

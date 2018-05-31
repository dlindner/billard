package com.schneide.abas.billard.inner.domain.model.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player {

	private String name;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String name() {
		return name;
	}

	@Override
	public String toString() {
		return "player " + name();
	}

	public static Player randomBy(Random randomness) {
		Collections.shuffle(remainingNames, randomness);
		final String currentName = remainingNames.remove(0);
		return new Player(currentName);
	}

	private static final List<String> remainingNames = new ArrayList<>(
			Arrays.asList(
				"Anne",
				"Bert",
				"Christine",
				"Dave",
				"Emil",
				"Franziska",
				"Gustav",
				"Hanna",
				"Ingo",
				"Konstanze",
				"Ludwig",
				"Marie",
				"Norbert",
				"Olga",
				"Patrick",
				"Roswita",
				"Steffen",
				"Tanja",
				"Ullrich",
				"Veronica"
			));
}

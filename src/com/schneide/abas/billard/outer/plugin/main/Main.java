package com.schneide.abas.billard.outer.plugin.main;

import com.schneide.abas.billard.inner.domain.model.Ball;
import com.schneide.abas.billard.inner.domain.model.BallSet;

public final class Main {

	private Main() {
		super();
	}

	public static void main(String[] arguments) {
		final BallSet balls = BallSet.create();
		for (Ball each : balls) {
			System.out.println(each);
		}
	}
}

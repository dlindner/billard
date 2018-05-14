package com.schneide.abas.billard.inner.domain.model;

public class Ball {

	private int number;
	private Suit suit;

	public Ball(int number, Suit suit) {
		super();
		this.number = number;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return "Ball " + this.number + " (" + this.suit + ")";
	}

	public static Ball createFor(int number) {
		if ((number < 0) || (number > 15)) {
			throw new IllegalArgumentException("Balls need to have a number between 0 and 15, not " + number);
		}
		if (0 == number) {
			return new Ball(0, Suit.white);
		}
		if (8 == number) {
			return new Ball(8, Suit.black);
		}
		if (number < 8) {
			return new Ball(number, Suit.full);
		}
		return new Ball(number, Suit.half);
	}
}

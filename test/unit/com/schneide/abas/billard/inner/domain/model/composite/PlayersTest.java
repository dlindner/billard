package com.schneide.abas.billard.inner.domain.model.composite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.schneide.abas.billard.inner.domain.model.basic.Player;

/**
 * Fifth tests
 */
public class PlayersTest {

	@Test
	public void areOrdered() {
		final Player first = player("one");
		final Player second = player("two");
		final Players target = new Players(
					first,
					second);
		assertThat(target.first()).isEqualTo(first);
		assertThat(target.second()).isEqualTo(second);
	}

	@Test
	public void areAlternating() {
		final Player first = player("one");
		final Player second = player("two");
		final Players target = new Players(
					first,
					second);
		assertThat(target.current()).isEqualTo(first);
		target.next();
		assertThat(target.current()).isEqualTo(second);
		target.next();
		assertThat(target.current()).isEqualTo(first);
	}

	private Player player(String name) {
		return new Player(
				name,
				irrelevant());
	}

	private static <T> T irrelevant() {
		return null;
	}
}

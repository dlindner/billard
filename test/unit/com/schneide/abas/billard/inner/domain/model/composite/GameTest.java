package com.schneide.abas.billard.inner.domain.model.composite;

import static org.mockito.Mockito.mock;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import com.schneide.abas.billard.inner.domain.model.basic.Player;

/**
 * Sixth tests
 */
public class GameTest {

	@Test
	public void startsWithFullTable() {
		final Table table = new Table();
		final Game target = new Game(
				players(),
				table,
				null);
		Assertions.assertThat(table.ballCount()).isZero();
		target.startWith(BallSet.create());
		Assertions.assertThat(table.ballCount()).isEqualTo(BallSet.size);
	}

	@Test
	public void startsWithFullTableMockVersion() {
		final Table table = Mockito.mock(Table.class);
		final Game target = new Game(
				players(),
				table,
				null);
		final BallSet balls = BallSet.create();
		target.startWith(balls);

		InOrder clearFirstPlaceLater = Mockito.inOrder(table);
		clearFirstPlaceLater.verify(table).clear();
		clearFirstPlaceLater.verify(table).place(balls);
	}

	private Players players() {
		return new Players(
				mock(Player.class),
				mock(Player.class));
	}
}

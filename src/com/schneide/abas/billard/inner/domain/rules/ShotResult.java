package com.schneide.abas.billard.inner.domain.rules;

public interface ShotResult {

	public GameState state();

	public NextPlayer successor();
}

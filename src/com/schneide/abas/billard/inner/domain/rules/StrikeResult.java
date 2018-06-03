package com.schneide.abas.billard.inner.domain.rules;

public interface StrikeResult {

	public GameState state();

	public NextPlayer successor();
}

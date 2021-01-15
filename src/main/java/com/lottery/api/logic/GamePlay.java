package com.lottery.api.logic;


import org.springframework.stereotype.Component;

@Component
public class GamePlay extends GameLogic {
	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 60;
	private static final int TOTAL_NUMBERS = 6;

	public GamePlay() {
	}

	public int[] sortSequence() {
		return super.sortSequence(MAX_VALUE, MIN_VALUE, TOTAL_NUMBERS);
	}
}
package com.lottery.api.logic;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

abstract class GameLogic {

	private Random generator;

	abstract int[] sortSequence();

	private void startGenerator() {
		this.generator = new Random( System.currentTimeMillis() );
	}

	private int sortNumber(int maxNumber, int minNumber ) {
		int number = 0;

		do {
			number = Math.abs( ( this.generator.nextInt() % maxNumber ) + 1 );
		} while ( number < minNumber );

		return number;
	}

	public final int[] sortSequence(int maxNumber, int minNumber, int quantity ) {
		Set<Integer> sequence = new TreeSet<Integer>();
		int[] result = new int[quantity];

		do {
			sequence.add( this.sortNumber( maxNumber, minNumber ) );
		} while ( sequence.size() < quantity );

		for ( int i = 0; i < quantity; i++ ) {
			result[i] = ( ( Integer ) sequence.toArray()[i] ).intValue();
		}
		
		return result;
	}

	public GameLogic() {
		this.startGenerator();
	}
}
package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	double amountOfTimetoFly(double speed, int range) {
		return 0;
	}

	@Override
	public void fight() {
		
	}

}

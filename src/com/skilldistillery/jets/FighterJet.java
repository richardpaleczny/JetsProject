package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	double amountOfTimetoFly(double speed, int range) {
		double timeRemaining = (range / speed) * 100;
		return timeRemaining;
	}

	@Override
	public void fight() {
		System.out.println(this.getModel() + ": Is pursuing nearby enemy planes. *pewpewpew*");
	}

}

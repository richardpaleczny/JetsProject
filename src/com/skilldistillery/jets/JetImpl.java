package com.skilldistillery.jets;

public class JetImpl extends Jet {

	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	double amountOfTimetoFly(double speed, int range) {
		double timeRemaining = (range / speed) * 50;
		return timeRemaining;
	}

}

package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	double amountOfTimetoFly(double speed, int range) {
		double timeRemaining = (range / speed) * 60;
		return timeRemaining;
	}
	
	@Override
	public void loadCargo() {
		System.out.println(this.getModel() + ": Is loading cargo dictated by manifest.");
	}
	
}

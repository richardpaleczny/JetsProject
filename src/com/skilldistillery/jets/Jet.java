package com.skilldistillery.jets;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;

	// Constructors
	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// Getters & Setters
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	// Other methods
	public void fly() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nModel: ").append(model)
		.append("\nSpeed: ").append(speed)
		.append("\nRange: ").append(range)
		.append("\nPrice: ").append(price)
		.append("\nAmount of time jet can remain flying (minutes, based on fuel): " + amountOfTimetoFly(speed, range));
		
		System.out.println(sb.toString());
	}
	
	public void ListFleet() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nModel: ").append(model)
		.append("\nSpeed: ").append(speed)
		.append("\nRange: ").append(range)
		.append("\nPrice: ").append(price);
		
		System.out.println(sb.toString());
	}
	
	public static double getSpeedInMach(double speed) {
		final double machConversionFactor = 0.00130332;
		double speedInMach = machConversionFactor * speed;
		
		return speedInMach;
	}
	
	// Abstract methods
	abstract double amountOfTimetoFly(double speed, int range);
}

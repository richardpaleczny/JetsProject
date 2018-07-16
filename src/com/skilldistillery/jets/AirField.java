package com.skilldistillery.jets;

public class AirField {

	private Jet[] jets;
	private final static int MAX_JETS;

	static {
		MAX_JETS = 100;
	}

	{
		jets = new Jet[MAX_JETS];
	}

	public AirField() {

	}

	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}

}

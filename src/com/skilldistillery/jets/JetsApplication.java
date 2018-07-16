package com.skilldistillery.jets;

public class JetsApplication {
	private static int counter = 0;
	
	public static void main(String[] args) {
		launch();
	}
	
	private static void launch() {
		// test menu
		displayUserMenu();
		
		// Add jets here, with an array which has extra null spaces
		AirField airfield = new AirField();
		Jet[] jetArray = airfield.getJets();
		addJet(jetArray, new FighterJet("test", 200, 200, 200_000));
		addJet(jetArray, new FighterJet("test", 201, 200, 200_000));
		addJet(jetArray, new FighterJet("test", 202, 200, 200_000));
		addJet(jetArray, new CargoPlane("test", 203, 200, 200_000));
		addJet(jetArray, new CargoPlane("test", 204, 200, 200_000));
		
		// Trim null spaces from original array, return non-null array with jets
		Jet[] nnJetArray = getNonNullJetArray(jetArray);
		for (int i = 0; i < nnJetArray.length; i++) {
			nnJetArray[i].fly();
		}

	}
	
	private static void displayUserMenu() {
		System.out.println("1. List Fleet" 
	+ "\n2. Fly all jets" 
	+ "\n3. View fastest jet" 
	+ "\n4. View jet with longest range" 
	+ "\n5. Load all Cargo Jets"
	+ "\n6. Dogfight!"
	+ "\n7. Add a jet to Fleet"
	+ "\n8. Quit");
	}
	
	public static Jet[] addJet(Jet[] jetArray, Jet jet) {
		
		// For every null spot in jetArray, assign the current passed jet
		for (counter = 0; counter < jetArray.length; counter++) {
			if (jetArray[counter] == null) {
				jetArray[counter] = jet;
				break;
			}
		}
		
		return jetArray;
	}
	
	public static Jet[] getNonNullJetArray(Jet[] jetArray) {
		// Create j to keep track of how many non-null spots in passed jetArray
		int j = 0;
		
		// Check how many non-null spots
		for (int i = 0; i < jetArray.length; i++) {
			if (jetArray[i] != null) {
				j++;
			}
		}
		// Assign a new Jet[] array to be the size of the non-null elements 
		// of the original passed jetArray
		Jet[] nnJetArray = new Jet[j];
		
		// For every non-null spot in jetArray, assign that element to the correctly sized
		// nnJetArray
		for (int i = 0; i < nnJetArray.length; i++) {
			nnJetArray[i] = jetArray[i];
		}
		
		// Return the non-null array of jets
		return nnJetArray;
	}
}



















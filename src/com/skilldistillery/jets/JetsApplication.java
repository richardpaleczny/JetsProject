package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private static int counter = 0;

	public static void main(String[] args) {
		launch();
	}

	private static void launch() {
		Scanner scanner = new Scanner(System.in);
		// Add jets here, with an array which has extra null spaces
		AirField airfield = new AirField();
		Jet[] jetArray = airfield.getJets();
		addJet(jetArray, new FighterJet("Zippy", 2_000, 10_000, 2_000_000));
		addJet(jetArray, new FighterJet("SuperSpeedy", 10_000, 50_000, 2_000_000_000));
		addJet(jetArray, new FighterJet("Gary", 5_000, 80_000, 200_000));
		addJet(jetArray, new CargoPlane("PickEmUp", 800, 10_000, 500_000));
		addJet(jetArray, new CargoPlane("SuperPickEmUp", 1600, 20_000, 10_000_000));

		// Trim null spaces from original array, return non-null array with jets
		Jet[] nnJetArray = getNonNullJetArray(jetArray);

		// test menu
		handleUser(jetArray, nnJetArray, scanner);

	}

	private static void handleUser(Jet[] jetArray, Jet[] nnJetArray, Scanner scanner) {
		boolean condition = true;
		while (condition) {
			System.out.println();
			displayUserMenu();
			String input = scanner.next();

			switch (input) {
			case "1":
				System.out.println("\n1 --> List Fleet: LISTING FLEET DETAILS...");
				for (int i = 0; i < nnJetArray.length; i++) {
					nnJetArray[i].ListFleet();
				}
				break;
			case "2":
				System.out.println("\n2 --> Fly all jets: PREPARING FLEET TO LAUNCH...");
				for (int i = 0; i < nnJetArray.length; i++) {
					System.out.println("\n-----------------------------------------\n" + "      " + "Plane " + i + ": "
							+ nnJetArray[i].getModel() + "       " + "\n-----------------------------------------");
					nnJetArray[i].fly();
				}
				break;
			case "3":
				System.out.println("\nFINDING FASTEST JET...");
				Jet fastest = nnJetArray[0];
				for (int i = 0; i < nnJetArray.length; i++) {
					if (fastest.getSpeed() < nnJetArray[i].getSpeed()) {
						fastest = nnJetArray[i];
					}
				}
				fastest.fly();
				break;
			case "4":
				System.out.println("\nFINDING JET WITH LONGEST RANGE...");
				Jet longestRange = nnJetArray[0];
				for (int i = 0; i < nnJetArray.length; i++) {
					if (longestRange.getRange() < nnJetArray[i].getRange()) {
						longestRange = nnJetArray[i];
					}
				}
				longestRange.fly();
				break;
			case "5":
				System.out.println("\nLOADING ALL CARGO JETS...");
				for (int i = 0; i < nnJetArray.length; i++) {
					if (nnJetArray[i] instanceof CargoPlane) {
						((CargoPlane) nnJetArray[i]).loadCargo();
					}
				}
				break;
			case "6":
				System.out.println("\nDOGFIGHT ENSUING!");
				for (int i = 0; i < nnJetArray.length; i++) {
					if (nnJetArray[i] instanceof FighterJet) {
						((FighterJet) nnJetArray[i]).fight();
					}
				}
				break;
			case "7":
				System.out.println("\nACCESS CODE ACCEPTED. ENTER FIELDS TO ADD JET TO DATABASE...");
				System.out.println("<<<<<<<<<<<<<>>>>>>>>>>>>>");
				System.out.print("Enter model: ");
				String model = scanner.next();
				System.out.print("Enter speed (in mph): ");
				Double speed = scanner.nextDouble();
				System.out.print("Enter range: ");
				Integer range = scanner.nextInt();
				System.out.print("Enter price: ");
				Long price = scanner.nextLong();

				addJet(jetArray, new JetImpl(model, speed, range, price));
				nnJetArray = getNonNullJetArray(jetArray);
				System.out.println("\nJET ADDED. QUERYING DATABASE FOR NEW JET...");
				nnJetArray[nnJetArray.length - 1].fly();
				break;
			case "8":
				System.out.println("\nEXITING PROGRAM...");
				System.exit(0);
			}
		}
	}

	private static void displayUserMenu() {
		System.out.println("||||||||\n| MENU |\n||||||||\n" + "\n1. List Fleet" + "\n2. Fly all jets"
				+ "\n3. View fastest jet" + "\n4. View jet with longest range" + "\n5. Load all Cargo Jets"
				+ "\n6. Dogfight!" + "\n7. Add a jet to Fleet" + "\n8. Quit");

		System.out.print("\n\nSelect Option: ");
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

		// For every non-null spot in jetArray, assign that element to the correctly
		// sized
		// nnJetArray
		for (int i = 0; i < nnJetArray.length; i++) {
			nnJetArray[i] = jetArray[i];
		}

		// Return the non-null array of jets
		return nnJetArray;
	}
}

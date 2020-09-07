package fantasy_rollenspiel;

import java.util.Random;

// Wuerfel

public class Wuerfel {

	static int anzahlSeiten;

	public Wuerfel(int pAnzahlSeiten) { anzahlSeiten = pAnzahlSeiten; }

	public static int wuerfeln() {

		Random bWuerfel = new Random();

		int augenZahl = 0;

		for (int a = 0; a < 1; a++) {

			augenZahl = 1 + bWuerfel.nextInt(anzahlSeiten);

		}

		return augenZahl;

	}

}

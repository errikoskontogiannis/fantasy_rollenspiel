package fantasy_rollenspiel;

import java.util.Scanner;

public class Spiel {

	private Held held;
	private Zauberer zauberer;
	private Krieger krieger;

	private Monster monster = new Monster(550, 5);
	private Kampfregel kampfregel = new Kampfregel();

	private Wuerfel pW6 = new Wuerfel(6);
	private Wuerfel pW10 = new Wuerfel(10);

	private int wuerfelJa;
	private int wuerfelNein;

	Scanner in = new Scanner(System.in);

	public Spiel(String pHeldenTyp) {

		wuerfelJa = this.pW6.wuerfeln() + this.pW10.wuerfeln();
		wuerfelNein = this.pW6.wuerfeln() + this.pW10.wuerfeln();

		if (pHeldenTyp.equals("Held") || pHeldenTyp.equals("Zauberer") || pHeldenTyp.equals("Krieger")) {

			System.out.println("Sie haben den Spielcharakter " + pHeldenTyp + " gewaehlt.");

			if (pHeldenTyp.equals("Held")) {

				System.out.println("Bitte geben Sie Ihrem Helden einen Namen.");

				String heldenName = in.nextLine();

				System.out.println("Waffenmoeglichkeitswuerfel lädt...");

				if (wuerfelJa > wuerfelNein) {

					System.out.println("Sie haben Glueck! Sie koennen jetzt eine Waffe für " + heldenName + " auswaehlen.");

					System.out.println("Bitte waehlen Sie das Material der Waffe Ihres Helden.");

					String heldenWaffeMaterial = in.nextLine();

					if (heldenWaffeMaterial.equals("Holz") || heldenWaffeMaterial.equals("Stein") || heldenWaffeMaterial.equals("Eisen") || heldenWaffeMaterial.equals("Gold") || heldenWaffeMaterial.equals("Diamant")) {

						held = new Held(heldenName, 550, 0, 5);

						held.setWaffe(heldenWaffeMaterial);

						held.angriffswertBerechnen();

						held.angreifen(monster, kampfregel);

					} else {

						throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

					}

				} else if (wuerfelJa < wuerfelNein) {

					System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + heldenName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

					held = new Held(heldenName, 550, 0, 5);

					held.angriffswertBerechnen();

					held.angreifen(monster, kampfregel);

				} else if (wuerfelJa == wuerfelNein) {

					System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

				}

			} else if (pHeldenTyp.equals("Zauberer")) {

				System.out.println("Bitte geben Sie Ihrem Zauberer einen Namen.");

				String zaubererName = in.nextLine();

				System.out.println("Waffenmoeglichkeitswuerfel lädt...");

				if (wuerfelJa > wuerfelNein) {

					System.out.println("Sie haben Glueck! Sie koennen jetzt eine Waffe für " + zaubererName + " auswaehlen.");

					System.out.println("Bitte waehlen Sie das Material der Waffe Ihres Zauberers.");

					String zaubererWaffeMaterial = in.nextLine();

					if (zaubererWaffeMaterial.equals("Holz") || zaubererWaffeMaterial.equals("Stein") || zaubererWaffeMaterial.equals("Eisen") || zaubererWaffeMaterial.equals("Gold") || zaubererWaffeMaterial.equals("Diamant")) {

						zauberer = new Zauberer(zaubererName, 550, 0, 5, 550);

						zauberer.setWaffe(zaubererWaffeMaterial);

						zauberer.angriffswertBerechnen();

						zauberer.angreifen(monster, kampfregel);

					} else {

						throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

					}

				} else if (wuerfelJa < wuerfelNein) {

					System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + zaubererName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

					zauberer = new Zauberer(zaubererName, 550, 0, 5, 550);

					zauberer.angriffswertBerechnen();

					zauberer.angreifen(monster, kampfregel);

				} else if (wuerfelJa == wuerfelNein) {

					System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

				}

			} else if (pHeldenTyp.equals("Krieger")) {

				System.out.println("Bitte geben Sie Ihrem Krieger einen Namen.");

				String kriegerName = in.nextLine();

				System.out.println("Waffenmoeglichkeitswuerfel lädt...");

				if (wuerfelJa > wuerfelNein) {

					System.out.println("Sie haben Glueck! Sie koennen jetzt eine Waffe für " + kriegerName + " auswaehlen.");

					System.out.println("Bitte waehlen Sie das Material der Waffe Ihres Kriegers.");

					String kriegerWaffeMaterial = in.nextLine();

					if (kriegerWaffeMaterial.equals("Holz") || kriegerWaffeMaterial.equals("Stein") || kriegerWaffeMaterial.equals("Eisen") || kriegerWaffeMaterial.equals("Gold") || kriegerWaffeMaterial.equals("Diamant")) {

						krieger = new Krieger(kriegerName, 550, 0, 5, 5);

						krieger.setWaffe(kriegerWaffeMaterial);

						krieger.angriffswertBerechnen();

						krieger.angreifen(monster, kampfregel);

					} else {

						throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

					}

				} else if (wuerfelJa < wuerfelNein) {

					System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + kriegerName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

					krieger = new Krieger(kriegerName, 550, 0, 5, 5);

					krieger.angriffswertBerechnen();

					krieger.angreifen(monster, kampfregel);

				} else if (wuerfelJa == wuerfelNein) {

					System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

				}

			} else {

				throw new IllegalArgumentException("Bitte geben Sie einen der verfuegbaren Heldentypen ein! (Verfuegbare Heldentypen: Held, Zauberer und Krieger)");

			}

		}

	}

}
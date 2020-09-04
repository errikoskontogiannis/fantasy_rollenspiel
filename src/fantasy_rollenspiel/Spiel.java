package fantasy_rollenspiel;

import java.util.Scanner;

// Spiel

public class Spiel {

    private Held held;
    private Zauberer zauberer;
    private Krieger krieger;

    private String aktuellerHeldenTyp;

    private Monster monster = new Monster(550, 5);
    private Kampfregel kampfregel = new Kampfregel();

    private Wuerfel pW6 = new Wuerfel(6);
    private Wuerfel pW10 = new Wuerfel(10);

    private int wuerfelJa;
    private int wuerfelNein;

    private String heldenName;
    private String zaubererName;
    private String kriegerName;

    private boolean schonGespielt;

    Scanner in = new Scanner(System.in);

    public Spiel(String pHeldenTyp) {

        aktuellerHeldenTyp = pHeldenTyp;

        if (aktuellerHeldenTyp.equals("Held") || aktuellerHeldenTyp.equals("Zauberer") || aktuellerHeldenTyp.equals("Krieger")) {

            System.out.println("Sie haben den Spielcharakter " + pHeldenTyp + " gewaehlt.");

            spielen();

        } else {

            throw new IllegalArgumentException("Bitte geben Sie einen der verfuegbaren Heldentypen ein! (Verfuegbare Heldentypen: Held, Zauberer und Krieger)");

        }

    }

    public void spielen() {

        wuerfelJa = this.pW6.wuerfeln() + this.pW10.wuerfeln();
        wuerfelNein = this.pW6.wuerfeln() + this.pW10.wuerfeln();

        if (aktuellerHeldenTyp.equals("Held")) {

            System.out.println("");

            if (schonGespielt == false) {

                System.out.println("Bitte geben Sie Ihrem Helden einen Namen.");

                heldenName = in.nextLine();

            }

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

                    erneutSpielen();

                } else {

                    throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

                }

            } else if (wuerfelJa < wuerfelNein) {

                System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + heldenName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

                held = new Held(heldenName, 550, 0, 5);

                held.angriffswertBerechnen();

                held.angreifen(monster, kampfregel);

                erneutSpielen();

            } else if (wuerfelJa == wuerfelNein) {

                System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

            }

        } else if (aktuellerHeldenTyp.equals("Zauberer")) {

            System.out.println("");

            if (schonGespielt == false) {

                System.out.println("Bitte geben Sie Ihrem Zauberer einen Namen.");

                zaubererName = in.nextLine();

            }

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

                    erneutSpielen();

                } else {

                    throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

                }

            } else if (wuerfelJa < wuerfelNein) {

                System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + zaubererName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

                zauberer = new Zauberer(zaubererName, 550, 0, 5, 550);

                zauberer.angriffswertBerechnen();

                zauberer.angreifen(monster, kampfregel);

                erneutSpielen();

            } else if (wuerfelJa == wuerfelNein) {

                System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

            }

        } else if (aktuellerHeldenTyp.equals("Krieger")) {

            System.out.println("");

            if (schonGespielt == false) {

                System.out.println("Bitte geben Sie Ihrem Krieger einen Namen.");

                kriegerName = in.nextLine();

            }

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

                    erneutSpielen();

                } else {

                    throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

                }

            } else if (wuerfelJa < wuerfelNein) {

                System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + kriegerName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

                krieger = new Krieger(kriegerName, 550, 0, 5, 5);

                krieger.angriffswertBerechnen();

                krieger.angreifen(monster, kampfregel);

                erneutSpielen();

            } else if (wuerfelJa == wuerfelNein) {

                System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

            }

        }

    }

    public void erneutSpielen() {

        System.out.println("");
        System.out.println("Moechten Sie noch eine Runde spielen?");

        String antwortSpielen = in.nextLine();

        if (antwortSpielen.equals("Ja") || antwortSpielen.equals("ja")) {

            schonGespielt = true;

            spielen();

        } else if (antwortSpielen.equals("Nein") || antwortSpielen.equals("nein")) {

            System.out.println("");
            System.out.println("Vielen Dank fürs Spielen!");
            System.exit(0);

        } else {

            throw new IllegalArgumentException("Bitte waehlen Sie eine der verfuegbaren Optionen! (Verfuegbare Optionen: Ja oder Nein)");

        }

    }

}

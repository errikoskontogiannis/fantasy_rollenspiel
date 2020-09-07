package fantasy_rollenspiel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Spiel

public class Spiel {

    private Held held;
    private Zauberer zauberer;
    private Krieger krieger;

    private List<Spielcharakter> gespeicherteSpielcharaktere = new ArrayList<Spielcharakter>();

    private String aktuellerSpielCharakter;

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
    private boolean derselbeCharakter;

    private int x = 0;

    Scanner in = new Scanner(System.in);

    public Spiel() {

        charakterWaehlen();
        spielen();

    }

    public void charakterWaehlen() {

        System.out.println("");
        System.out.println("Bitte waehlen Sie Ihren Spielcharakter");

        Scanner in = new Scanner(System.in);

        aktuellerSpielCharakter = in.nextLine();

        if (aktuellerSpielCharakter.equals("Held") || aktuellerSpielCharakter.equals("Zauberer") || aktuellerSpielCharakter.equals("Krieger")) {

            System.out.println("");
            System.out.println("Sie haben den Spielcharakter " + aktuellerSpielCharakter + " gewaehlt.");

        } else {

            throw new IllegalArgumentException("Bitte geben Sie einen der verfuegbaren Heldentypen ein! (Verfuegbare Heldentypen: Held, Zauberer und Krieger)");

        }

    }

    public void spielen() {

        wuerfelJa = this.pW6.wuerfeln() + this.pW10.wuerfeln();
        wuerfelNein = this.pW6.wuerfeln() + this.pW10.wuerfeln();

        // Held

        if (aktuellerSpielCharakter.equals("Held")) {

            System.out.println("");

            if (schonGespielt == false) {

                System.out.println("Bitte geben Sie Ihrem Helden einen Namen.");

                heldenName = in.nextLine();

            } else if (schonGespielt == true && derselbeCharakter == false) {

                System.out.println("Bitte geben Sie Ihrem Helden einen Namen.");

                heldenName = in.nextLine();

            }

            System.out.println("");
            System.out.println("Waffenmoeglichkeitswuerfel lädt...");

            if (wuerfelJa > wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben Glueck! Sie koennen jetzt eine Waffe für " + heldenName + " auswaehlen.");

                System.out.println("");
                System.out.println("Bitte waehlen Sie das Material der Waffe Ihres Helden.");

                String heldenWaffeMaterial = in.nextLine();

                if (heldenWaffeMaterial.equals("Holz") || heldenWaffeMaterial.equals("Stein") || heldenWaffeMaterial.equals("Eisen") || heldenWaffeMaterial.equals("Gold") || heldenWaffeMaterial.equals("Diamant")) {

                    held = new Held(heldenName, 550, 0, 5);

                    held.setWaffe(heldenWaffeMaterial);

                    held.angriffswertBerechnen();

                    held.angreifen(monster, kampfregel);

                    held.setTyp("Held");

                    charakterSpeichern(held);

                    erneutSpielen();

                } else {

                    throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

                }

            } else if (wuerfelJa < wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + heldenName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

                held = new Held(heldenName, 550, 0, 5);

                held.angriffswertBerechnen();

                held.angreifen(monster, kampfregel);

                held.setTyp("Held");

                charakterSpeichern(held);

                erneutSpielen();

            } else if (wuerfelJa == wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

                held.setTyp("Held");

                charakterSpeichern(held);

                erneutSpielen();

            }

            // Zauberer

        } else if (aktuellerSpielCharakter.equals("Zauberer")) {

            System.out.println("");

            if (schonGespielt == false) {

                System.out.println("Bitte geben Sie Ihrem Zauberer einen Namen.");

                zaubererName = in.nextLine();

            } else if (schonGespielt == true && derselbeCharakter == false) {

                System.out.println("Bitte geben Sie Ihrem Zauberer einen Namen.");

                zaubererName = in.nextLine();

            }

            System.out.println("");
            System.out.println("Waffenmoeglichkeitswuerfel lädt...");

            if (wuerfelJa > wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben Glueck! Sie koennen jetzt eine Waffe für " + zaubererName + " auswaehlen.");

                System.out.println("");
                System.out.println("Bitte waehlen Sie das Material der Waffe Ihres Zauberers.");

                String zaubererWaffeMaterial = in.nextLine();

                if (zaubererWaffeMaterial.equals("Holz") || zaubererWaffeMaterial.equals("Stein") || zaubererWaffeMaterial.equals("Eisen") || zaubererWaffeMaterial.equals("Gold") || zaubererWaffeMaterial.equals("Diamant")) {

                    zauberer = new Zauberer(zaubererName, 550, 0, 5, 550);

                    zauberer.setWaffe(zaubererWaffeMaterial);

                    zauberer.angriffswertBerechnen();

                    zauberer.angreifen(monster, kampfregel);

                    zauberer.setTyp("Zauberer");

                    charakterSpeichern(zauberer);

                    erneutSpielen();

                } else {

                    throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

                }

            } else if (wuerfelJa < wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + zaubererName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

                zauberer = new Zauberer(zaubererName, 550, 0, 5, 550);

                zauberer.angriffswertBerechnen();

                zauberer.angreifen(monster, kampfregel);

                zauberer.setTyp("Zauberer");

                charakterSpeichern(zauberer);

                erneutSpielen();

            } else if (wuerfelJa == wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

                zauberer.setTyp("Zauberer");

                charakterSpeichern(zauberer);

                erneutSpielen();

            }

            // Krieger

        } else if (aktuellerSpielCharakter.equals("Krieger")) {

            System.out.println("");

            if (schonGespielt == false) {

                System.out.println("Bitte geben Sie Ihrem Krieger einen Namen.");

                kriegerName = in.nextLine();

            } else if (schonGespielt == true && derselbeCharakter == false) {

                System.out.println("Bitte geben Sie Ihrem Krieger einen Namen.");

                kriegerName = in.nextLine();

            }

            System.out.println("");
            System.out.println("Waffenmoeglichkeitswuerfel lädt...");

            if (wuerfelJa > wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben Glueck! Sie koennen jetzt eine Waffe für " + kriegerName + " auswaehlen.");

                System.out.println("");
                System.out.println("Bitte waehlen Sie das Material der Waffe Ihres Kriegers.");

                String kriegerWaffeMaterial = in.nextLine();

                if (kriegerWaffeMaterial.equals("Holz") || kriegerWaffeMaterial.equals("Stein") || kriegerWaffeMaterial.equals("Eisen") || kriegerWaffeMaterial.equals("Gold") || kriegerWaffeMaterial.equals("Diamant")) {

                    krieger = new Krieger(kriegerName, 550, 0, 5, 5);

                    krieger.setWaffe(kriegerWaffeMaterial);

                    krieger.angriffswertBerechnen();

                    krieger.angreifen(monster, kampfregel);

                    krieger.setTyp("Krieger");

                    charakterSpeichern(krieger);

                    erneutSpielen();

                } else {

                    throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");

                }

            } else if (wuerfelJa < wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben kein Glück! Sie koennen keine Waffe für " + kriegerName + " auswaehlen." + " Sie können nur mit Ihrer Staerke kaempfen.");

                krieger = new Krieger(kriegerName, 550, 0, 5, 5);

                krieger.angriffswertBerechnen();

                krieger.angreifen(monster, kampfregel);

                krieger.setTyp("Krieger");

                charakterSpeichern(krieger);

                erneutSpielen();

            } else if (wuerfelJa == wuerfelNein) {

                System.out.println("");
                System.out.println("Sie haben sehr viel Glueck! Sie haben die Superwaffe bekommen und den Kampf gewonnen.");

                krieger.setTyp("Krieger");

                charakterSpeichern(krieger);

                erneutSpielen();

            }

        }

    }

    public void erneutSpielen() {

        System.out.println("");
        System.out.println("Moechten Sie noch eine Runde spielen?");

        String antwortSpielen = in.nextLine();

        if (antwortSpielen.equals("Ja") || antwortSpielen.equals("ja")) {

            schonGespielt = true;

            System.out.println("");
            System.out.println("Mit dem selben Spielcharakter?");

            String antwortSpielcharakter = in.nextLine();

            if (antwortSpielcharakter.equals("Ja") || antwortSpielcharakter.equals("ja")) {

                derselbeCharakter = true;

                System.out.println("");
                System.out.println("Ok!");

                spielen();

            } else if (antwortSpielcharakter.equals("Nein") || antwortSpielcharakter.equals("nein")) {

                derselbeCharakter = false;

                System.out.println("");
                System.out.println("Ok!");

                charakterWaehlen();
                spielen();

            } else {

                throw new IllegalArgumentException("Bitte waehlen Sie eine der verfuegbaren Optionen! (Verfuegbare Optionen: Ja oder Nein)");

            }

        } else if (antwortSpielen.equals("Nein") || antwortSpielen.equals("nein")) {

            ranglisteAnzeigen();

            System.out.println("");
            System.out.println("Vielen Dank fürs Spielen!");
            System.exit(0);

        } else {

            throw new IllegalArgumentException("Bitte waehlen Sie eine der verfuegbaren Optionen! (Verfuegbare Optionen: Ja oder Nein)");

        }

    }

    public void charakterSpeichern(Spielcharakter pSpielcharakter) {

        if (derselbeCharakter) {

            gespeicherteSpielcharaktere.set(x, pSpielcharakter);

        } else {

            gespeicherteSpielcharaktere.add(pSpielcharakter);

        }

    }

    public void ranglisteAnzeigen() {

        gespeicherteSpielcharaktere = Rangliste.SortByHealth(gespeicherteSpielcharaktere);

        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Aktuelle Rangliste von Spielern");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Rang        Name        Spielcharakter        Lebenspunkte");
        System.out.println("----------------------------------------------------------------------");
        for(int i=0; i<gespeicherteSpielcharaktere.size(); i++) { System.out.println((i+1) + "        " + gespeicherteSpielcharaktere.get(i).getName() + "              " + gespeicherteSpielcharaktere.get(i).getTyp()  + "              " + gespeicherteSpielcharaktere.get(i).getLebenspunkte()); }
        System.out.println("----------------------------------------------------------------------");

    }

}

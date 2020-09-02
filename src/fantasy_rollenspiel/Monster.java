package fantasy_rollenspiel;

// Monster

public class Monster extends Spielcharakter {

	private int angriffswert;
	private double lebenspunkte;

	public Monster(int pAngriffswert, double pLebenspunkte) {

		angriffswert = pAngriffswert;
		lebenspunkte = pLebenspunkte;

	}

	public void setAngriffswert(int pAngriffswert) {

		angriffswert = pAngriffswert;

	}

	public int getAngriffswert() {

		return angriffswert;

	}

	public void setLebenspunkte(double pLebenspunkte) {

		lebenspunkte = pLebenspunkte;

	}

	public double getLebenspunkte() {

		return lebenspunkte;

	}

	public void statusAusgeben() {

		System.out.println("");
		System.out.println("-------------------------------");
		System.out.println("Status des Monsters:");
		System.out.println("-------------------------------");
		System.out.println("Angriffswert: " + this.getAngriffswert());
		System.out.println("Lebenspunkte: " + this.getLebenspunkte());
		System.out.println("-------------------------------");

	}

}

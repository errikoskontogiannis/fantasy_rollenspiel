package fantasy_rollenspiel;

// Monster

public class Monster extends Spielcharakter {

	public Monster(int pAngriffswert, int pLebenspunkte) {

		angriffswert = pAngriffswert;
		lebenspunkte = pLebenspunkte;

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

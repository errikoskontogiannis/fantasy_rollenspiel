package fantasy_rollenspiel;

public class Monster {
	
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
	
}

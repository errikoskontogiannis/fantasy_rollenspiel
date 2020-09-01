package fantasy_rollenspiel;

// Krieger

public class Krieger extends Held {

	private int ausdauer;

	public Krieger(String pName, int pStaerke, int pAngriffswert, int pLebenspunkte, int pAusdauer) {

		super(pName, pStaerke, pAngriffswert, pLebenspunkte);

		this.ausdauer = pAusdauer;

	}

	public void angriffswertBerechnen() {

		super.angriffswertBerechnen();
		this.setAngriffswert(angriffswert*ausdauer);

	}

	public void setAusdauer(int pAusdauer) {

		ausdauer = pAusdauer;

	}

	public int getAusdauer() {

		return ausdauer;

	}

	public void statusAusgeben() {

		System.out.println("Status von dem Krieger " + this.getName() + ": ");
		System.out.println("Angriffswert: " + this.getAngriffswert());
		System.out.println("Lebenspunkte: " + this.getLebenspunkte());
		System.out.println("Waffe: " + this.getWaffe());
		System.out.println("Staerke: " + this.getStaerke());
		System.out.println("Ausdauer: " + this.getAusdauer());

	}

}

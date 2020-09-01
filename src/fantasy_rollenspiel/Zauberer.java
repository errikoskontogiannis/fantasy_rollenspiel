package fantasy_rollenspiel;

// Zauberer

public class Zauberer extends Held {

	private int zauberKraft;

	public Zauberer(String pName, int pStaerke, int pAngriffswert, int pLebenspunkte, int pZauberkraft) {

		super(pName, pStaerke, pAngriffswert, pLebenspunkte);

		this.zauberKraft = pZauberkraft;

	}

	public void heilen() {

		lebenspunkte = lebenspunkte + 0.5;

	}

	public void setZauberKraft(int pZauberKraft) {

		zauberKraft = pZauberKraft;

	}

	public int getZauberKraft() {

		return zauberKraft;

	}

	public void statusAusgeben() {

		System.out.println("Status von dem Zauberer " + this.getName() + ": ");
		System.out.println("Angriffswert: " + this.getAngriffswert());
		System.out.println("Lebenspunkte: " + this.getLebenspunkte());
		System.out.println("Waffe: " + this.getWaffe());
		System.out.println("Staerke: " + this.getStaerke());
		System.out.println("Zauberkraft: " + this.getZauberKraft());

	}

}

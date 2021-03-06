package fantasy_rollenspiel;

// Zauberer

public class Zauberer extends Held {

	protected int zauberKraft;

	public Zauberer(String pName, int pStaerke, int pAngriffswert, int pLebenspunkte, int pZauberkraft) {

		super(pName, pStaerke, pAngriffswert, pLebenspunkte);

		this.zauberKraft = pZauberkraft;

	}

	public void heilen() { lebenspunkte = lebenspunkte + 1; }

	public void setZauberKraft(int pZauberKraft) { zauberKraft = pZauberKraft; }

	public int getZauberKraft() { return zauberKraft; }

	public void statusAusgeben() {

		System.out.println("");
		System.out.println("-------------------------------");
		System.out.println("Status des Zauberers " + this.getName() + ": ");
		System.out.println("-------------------------------");
		System.out.println("Angriffswert: " + this.getAngriffswert());
		System.out.println("Lebenspunkte: " + this.getLebenspunkte());
		System.out.println("Waffe: " + this.getWaffe());
		System.out.println("Staerke: " + this.getStaerke());
		System.out.println("Zauberkraft: " + this.getZauberKraft());
		System.out.println("-------------------------------");

	}

}

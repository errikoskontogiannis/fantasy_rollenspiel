package fantasy_rollenspiel;

// Held

public class Held extends Spielcharakter {

	protected int staerke;

	protected Waffe meineWaffe = null;

	public Held(String pName, int pStaerke, int pAngriffswert, int pLebenspunkte) {

		name = pName;
		staerke = pStaerke;
		angriffswert = pAngriffswert;
		lebenspunkte = pLebenspunkte;

	}

	public void setStaerke(int pStaerke) { staerke = pStaerke; }

	public int getStaerke() { return staerke; }

	public void setWaffe(String pMaterial) {

		meineWaffe = new Waffe(pMaterial, 0, 550);
		meineWaffe.bonusBerechnen();

	}

	public Waffe getWaffe() { return meineWaffe; }

	public void angreifen(Monster pMonster, Kampfregel pKampfregel) { pKampfregel.kampf(this, pMonster); }

	public void angriffswertBerechnen() {

		if (meineWaffe != null) {

			angriffswert = staerke + meineWaffe.getBonus();

		} else {

			angriffswert = staerke;

		}

	}

	public void statusAusgeben() {

		System.out.println("");
		System.out.println("-------------------------------");
		System.out.println("Status des Helden " + this.getName() + ":");
		System.out.println("-------------------------------");
		System.out.println("Angriffswert: " + this.getAngriffswert());
		System.out.println("Lebenspunkte: " + this.getLebenspunkte());
		System.out.println("Waffe: " + this.getWaffe());
		System.out.println("Staerke: " + this.getStaerke());
		System.out.println("-------------------------------");

	}

}
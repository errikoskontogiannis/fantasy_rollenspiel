package fantasy_rollenspiel;

public class Held {

	protected String name;
	protected int staerke;
	protected int angriffswert;
	protected double lebenspunkte;

	protected Waffe meineWaffe = null;

	public Held(String pName, int pStaerke, int pAngriffswert, int pLebenspunkte) {

		name = pName;
		staerke = pStaerke;
		angriffswert = pAngriffswert;
		lebenspunkte = pLebenspunkte;

	}

	public String getName() {

		return name;

	}

	public void setStaerke(int pStaerke) {

		staerke = pStaerke;

	}

	public int getStaerke() {

		return staerke;

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

	public void setWaffe(String pMaterial) {

		meineWaffe = new Waffe(pMaterial, 0, 550);
		meineWaffe.bonusBerechnen();

	}

	public Waffe getWaffe() {

		return meineWaffe;

	}

	public void angreifen(Monster pMonster, Kampfregel pKampfregel) {

		pKampfregel.kampf(this, pMonster);

	}

	public void angriffswertBerechnen() {

		if (meineWaffe != null) {

			angriffswert = staerke + meineWaffe.getBonus();

		} else {

			angriffswert = staerke;

		}

	}

}
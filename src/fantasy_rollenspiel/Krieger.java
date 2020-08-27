package fantasy_rollenspiel;

public class Krieger extends Held {

	private int ausdauer;

	public Krieger(String pName, int pStaerke, int pAngriffswert, int pLebenspunkte, int pAusdauer) {

		super(pName, pStaerke, pAngriffswert, pLebenspunkte);

		this.ausdauer = pAusdauer;

	}

	public void angriffswertBerechnen() {

		if (meineWaffe != null) {

			angriffswert = (staerke + meineWaffe.getBonus() * ausdauer) ;

		} else {

			angriffswert = (staerke * ausdauer) ;

		}

	}

}

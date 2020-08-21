package fantasy_rollenspiel;

public class Kampfregel {
	
	private Wuerfel pW6 = new Wuerfel(6);
	private Wuerfel pW10 = new Wuerfel(10);
	
	private int wuerfelHeld;
	private int wuerfelMonster;
	private int angriffsBonus;
	
	private Held cHeld;
	private Monster cMonster;
	
	public void kampf(Held k1, Monster k2) {
		
		cHeld = k1;
		cMonster = k2;
		
		wuerfelHeld = this.pW6.wuerfeln() + this.pW10.wuerfeln();
		wuerfelMonster = this.pW6.wuerfeln() + this.pW10.wuerfeln();
		
		angriffsBonus = this.pW6.wuerfeln() * this.pW10.wuerfeln() * 10;
		
		if (wuerfelHeld > wuerfelMonster) {
			
			k1.setAngriffswert(k1.getAngriffswert() + angriffsBonus);
			
		} else if (wuerfelHeld < wuerfelMonster) {
			
			k2.setAngriffswert(k2.getAngriffswert() + angriffsBonus);
			
		} else if (wuerfelHeld == wuerfelMonster) {
			
			k1.setAngriffswert(k1.getAngriffswert() + angriffsBonus);
			k2.setAngriffswert(k2.getAngriffswert() + angriffsBonus);
			
		}
		
		if (k1.getAngriffswert() > k2.getAngriffswert()) {
			
			anzeigen();
			
			k2.setLebenspunkte(k2.getLebenspunkte() - 1.0);
			System.out.println(k1.getName() + " hat den Kampf gewonnen!");
			
		} else if (k1.getAngriffswert() < k2.getAngriffswert()) {
			
			anzeigen();
			
			k1.setLebenspunkte(k1.getLebenspunkte() - 1.0);
			System.out.println("Das Monster hat den Kampf gewonnen!");
			
		} else {
			
			anzeigen();
			
			System.out.println(k1.getName() + " und das Monster haben den Kampf beendet.");
			
		}
	
	}
	
	private void anzeigen() {
		
		System.out.println("Angriffswert vom Held: " + cHeld.getAngriffswert());
		System.out.println("Angriffswert vom Monster: " + cMonster.getAngriffswert());
		
	}

	private int String(int angriffswert) {
		return 0;
	}
		
}

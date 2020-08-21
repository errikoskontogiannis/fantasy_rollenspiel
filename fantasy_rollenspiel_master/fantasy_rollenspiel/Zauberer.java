package fantasy_rollenspiel;

public class Zauberer extends Held {
	
	private int zauberKraft;
	
	public Zauberer(String pName, int pStaerke, int pAngriffswert, int pLebenspunkte, int pZauberkraft) {
		
		super(pName, pStaerke, pAngriffswert, pLebenspunkte);
		
		this.zauberKraft = pZauberkraft;
		
	}
	
	public void heilen() {
		
		lebenspunkte = lebenspunkte + 0.5;
		
	} 
	
}

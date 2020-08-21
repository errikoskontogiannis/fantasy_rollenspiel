package fantasy_rollenspiel;

import java.util.Random;

public class Waffe {
	
	private String material;
	private int materialWert;
	private int bonus;
	private int magie;
	
	public Waffe(String pMaterial, int pBonus, int pMagie) {
		
		if (pMaterial.equals("Holz") || pMaterial.equals("Stein") || pMaterial.equals("Eisen") || pMaterial.equals("Gold") || pMaterial.equals("Diamant")) {
			
			material = pMaterial;
			bonus = pBonus;
			magie = pMagie;
			
		} else {
			
			throw new IllegalArgumentException("Bitte geben Sie ein von den verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");
			
		}
		
	}
	
	public void setBonus(int pBonus) {
		
		bonus = pBonus;
		
	}

	public int getBonus() {
		
		return bonus;
		
	}
	
	public void setMagie(int pMagie) {
		
		magie = pMagie;
		
	}
	
	public int getMagie() {
		
		return magie;
		
	}
	
	public void setMaterial(String pMaterial) {
		
		if (pMaterial.equals("Holz") || pMaterial.equals("Stein") || pMaterial.equals("Eisen") || pMaterial.equals("Gold") || pMaterial.equals("Diamant")) {
			
			material = pMaterial;
			
		} else {
			
			throw new IllegalArgumentException("Bitte geben Sie ein von den verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");
			
		}
		
	}
	
	public String getMaterial() {
		
		return material;
		
	}
	
	public int bonusBerechnen() {
		
		if (material == "Holz") {
			
			materialWert = 100;
			
		} else if (material == "Stein") {
			
			materialWert = 250;
			
		} else if (material == "Eisen") {
			
			materialWert = 550;
			
		} else if (material == "Gold") {
			
			materialWert = 800;
			
		} else if (material == "Diamant") {
			
			materialWert = 1100;
			
		}
		
		bonus = materialWert + magie;
		
		return bonus;
		
	}
	
}

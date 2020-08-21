package fantasy_rollenspiel;

import java.util.Scanner; 

@SuppressWarnings("ALL")
public class Spiel {
	
	private Held held;
	private Zauberer zauberer;
	private Krieger krieger;
	
	private Monster monster = new Monster(550, 5);
	private Kampfregel kampfregel = new Kampfregel();
	
	Scanner in = new Scanner(System.in); 
	
	public Spiel(String pHeldenTyp) {
		
		if (pHeldenTyp.equals("Held") || pHeldenTyp.equals("Zauberer") || pHeldenTyp.equals("Krieger")) {
	        
			System.out.println("Sie haben den Heldentyp " + pHeldenTyp + " gewaehlt.");
			
			if (pHeldenTyp.equals("Held")) {
				
				System.out.println("Bitte geben Sie Ihrem Helden einen Namen.");
		        
		        String heldenName = in.nextLine();
		        System.out.println("Bitte w�hlen Sie das Material der Waffe Ihres Helden.");
		        
		        String heldenWaffeMaterial = in.nextLine();
		        
		        if (heldenWaffeMaterial.equals("Holz") || heldenWaffeMaterial.equals("Stein") || heldenWaffeMaterial.equals("Eisen") || heldenWaffeMaterial.equals("Gold") || heldenWaffeMaterial.equals("Diamant")) {
					
		        	held = new Held(heldenName, 550, 0, 5);
		        	
		        	held.meineWaffe = new Waffe(heldenWaffeMaterial, 0, 550);
					
		        	held.meineWaffe.setBonus(held.meineWaffe.bonusBerechnen());
		        	
		        	held.angriffswertBerechnen();
		        	
					held.meinHeld = held;
					
					held.angreifen(monster, kampfregel);
					
				} else {
					
					throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");
					
				}
				
			} else if (pHeldenTyp.equals("Zauberer")) {
				
				System.out.println("Bitte geben Sie Ihrem Zauberer einen Namen.");
		        
		        String zaubererName = in.nextLine();
		        System.out.println("Bitte w�hlen Sie das Material der Waffe Ihres Zauberers.");
		        
		        String zaubererWaffeMaterial = in.nextLine();
		        
		        if (zaubererWaffeMaterial.equals("Holz") || zaubererWaffeMaterial.equals("Stein") || zaubererWaffeMaterial.equals("Eisen") || zaubererWaffeMaterial.equals("Gold") || zaubererWaffeMaterial.equals("Diamant")) {
					
		        	zauberer = new Zauberer(zaubererName, 550, 0, 5, 550);
		        	
		        	zauberer.meineWaffe = new Waffe(zaubererWaffeMaterial, 0, 550);
					
		        	zauberer.meineWaffe.setBonus(zauberer.meineWaffe.bonusBerechnen());
					
		        	zauberer.angriffswertBerechnen();
		        	
					zauberer.meinHeld = zauberer;
					
					zauberer.angreifen(monster, kampfregel);
					
				} else {
					
					throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");
					
				}
				
			} else {
				
				System.out.println("Bitte geben Sie Ihrem Krieger einen Namen.");
		        
		        String kriegerName = in.nextLine();
		        System.out.println("Bitte w�hlen Sie das Material der Waffe Ihres Kriegers.");
		        
		        String kriegerWaffeMaterial = in.nextLine();
		        
		        if (kriegerWaffeMaterial.equals("Holz") || kriegerWaffeMaterial.equals("Stein") || kriegerWaffeMaterial.equals("Eisen") || kriegerWaffeMaterial.equals("Gold") || kriegerWaffeMaterial.equals("Diamant")) {
					
		        	krieger = new Krieger(kriegerName, 550, 0, 5, 5);
		        	
		        	krieger.meineWaffe = new Waffe(kriegerWaffeMaterial, 0, 550);
					
		        	krieger.meineWaffe.setBonus(krieger.meineWaffe.bonusBerechnen());
		        	
		        	krieger.angriffswertBerechnen();
		        	
			        krieger.meinHeld = krieger;
					
			        krieger.angreifen(monster, kampfregel);
					
				} else {
					
					throw new IllegalArgumentException("Bitte geben Sie eines der verfuegbaren Materialien ein! (Verfuegbare Materialien: Holz, Stein, Eisen, Gold und Diamant)");
					
				}
				
			}
			
		} else {
			
			throw new IllegalArgumentException("Bitte geben Sie einen der verfuegbaren Heldentypen ein! (Verfuegbare Heldentypen: Held, Zauberer und Krieger)");
			
		}
		
	}
	
}
package fantasy_rollenspiel;

// Spielcharakter

public abstract class Spielcharakter {

    protected String name;
    protected int angriffswert;
    protected double lebenspunkte;

    abstract void setAngriffswert(int pAngriffswert);

    abstract int getAngriffswert();

    abstract void setLebenspunkte(double pLebenspunkte);

    abstract double getLebenspunkte();

    abstract void statusAusgeben();

}

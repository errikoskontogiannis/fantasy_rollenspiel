package fantasy_rollenspiel;

// Spielcharakter

public abstract class Spielcharakter {

    protected String name;
    protected String typ;
    protected int angriffswert;
    protected int lebenspunkte;

    public void setName(String pName) { name = pName; }

    public String getName() { return name; }

    public void setTyp(String pTyp) { typ = pTyp; }

    public String getTyp() { return typ; }

    public void setAngriffswert(int pAngriffswert) { angriffswert = pAngriffswert; }

    public int getAngriffswert() { return angriffswert; }

    public void setLebenspunkte(int pLebenspunkte) { lebenspunkte = pLebenspunkte; }

    public int getLebenspunkte() { return lebenspunkte; }

    abstract void statusAusgeben();

}

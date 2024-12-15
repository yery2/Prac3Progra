package classes;

public class Alumnes extends Membres{
    private String ensenyament;
    private int anys;

    public String getEnsenyament() {
    return ensenyament;
    }
    
    public int getAnys() {
    return anys;
    }
    
    public void setEnsenyament(String ensenyament) {
    this.ensenyament = ensenyament;
    }
    
    public void setAnys(int anys) {
    this.anys = anys;
    }
    
    public String toString() {
        return "Alumnes [ensenyament=" + ensenyament + ", anys=" + anys + "]";
    }
}

package classes;
/**
 * @author Yerai Zarza
 */

public class Professors extends Membres {
    private int despatx;
    private String departament;

    public int getDespatx() {
    return despatx;
    }

    public String getDepartament() {
    return departament;
    } 
    
    public void setDespatx(int despatx) {
    this.despatx = despatx;
    }

    public void setDepartament(String departament) {
    this.departament = departament;
    }

    public String toString() {
        return ("Professors [despatx=" + despatx + ", departament=" + departament + "]");
    }
   
}

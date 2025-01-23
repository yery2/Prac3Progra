package Classes;

/**
 * @author Marc Badia, Pol Caballé
 */

public abstract class Accio {

    protected String codi = "";  // S'ha de fer mètode que a partir de nom assoc. generi codi
    protected String titol;
    protected String responsable;
    protected String[] nomAssociacions;  // Lista de nombres de asociaciones

    public Accio(String t, String r, String[] nomAssociacions) {
        this.codi = generarCodi(nomAssociacions);  // Genera el código usando el nombre de la primera asociación
        this.titol = t; 
        this.responsable = r; 
        this.nomAssociacions = nomAssociacions;
    }

    public String getCodi() {
        return codi;
    }

    public String getTitol() {
        return titol;
    }

    public String getResponsable() {
        return responsable;
    }

    public String[] getNomAssociacions() {
        return nomAssociacions;
    }

    /**
     * Genera el codi de la acció basat en el nom de la primera associació.
     * Es fa amb la primer 3 lletres del nom de l'associació i després el nombre d'accions incrementat.
     */
    public String generarCodi(String[] nomAssociacions) {
        String digits = "";
        if (nomAssociacions != null && nomAssociacions.length > 0) {
            // Obtenim els primers tres caràcters del primer nom d'associació
            String nomAssoc = nomAssociacions[0];
            for (int i = 0; i < nomAssoc.length() && i < 3; i++) {
                digits += nomAssoc.charAt(i);
            }

            // Aquí puedes agregar la lógica de incrementar el número de acciones si es necesario
            // En este caso solo usamos el valor fijo 99 como ejemplo
            digits += "99";  // Esto puede cambiar dependiendo de cómo manejas las acciones
        }
        return digits;
    }

    @Override
    public String toString() {
        return "Accio{" +
                "codi='" + codi + '\'' +
                ", titol='" + titol + '\'' +
                ", responsable='" + responsable + '\'' +
                ", nAssoc organitzadors=" + (nomAssociacions != null ? nomAssociacions.length : 0) +
                '}';
    }

    public String toStringCSV() {
        return codi + ";" + titol + ";" + responsable + ";" + String.join(",", nomAssociacions);
    }
}

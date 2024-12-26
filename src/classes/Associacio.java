package classes;

/**
 * @author Núria Yepes Castro
 */

public class Associacio {
    private String nomAssociacio;
    private String emailContacte;
    private String[] titulacions;
    private String[] membres;
    private String presidentAssociacio;
    private String secretariAssociacio;
    private String tresorerAssociacio;
    private int nombreMemebres;
    private int nombreAccions;
    private static final int MAX_MEMBRES = 200;

    /**
     * Constructor per defecte de la classe Associacio

     */
    public Associacio(String nomAssociacio, String emailContacte, String[] titulacions, String[] membres, 
                        String presidentAssociacio, String secretariAssociacio, String tresorerAssociacio, 
                        int nombreMemebres, int nombreAccions){
        this.nombreAccions = nombreAccions; //Es el nombre de accions que ha dut ha terme una associacio,
        //es necesari per generar el codi referent a cada una de les accions
        this.nomAssociacio = nomAssociacio;
        this.emailContacte = emailContacte;
        this.titulacions = new String[]{"GEB", "GEI", "GESST", "BioGEI", "DG GEB-GESST", "extern-ETSE"};
        this.membres = new String[MAX_MEMBRES];
        this.nombreMemebres = 0;
        this.presidentAssociacio = null;
        this.secretariAssociacio = null;
        this.tresorerAssociacio = null;
    }

    /**
     * getter nom 
     * @return el nom de l'associacio
     */
    public String getNomAssociacio(){
        return nomAssociacio;
    }

    /**
     * setter nom
     * @param nomAssociacio indica el nom de l'associacio
     */
    public void setNomAssociacio(String nomAssociacio){
        this.nomAssociacio = nomAssociacio;
    }

    public void incrementarNombreAccions(){
        this.nombreAccions++;
    }

    public int getNombreAccions(){
        return nombreAccions;
    }

    /**
     * getter email contacte
     * @return el email de contacte de la associacio
     */
    public String getEmailContacte(){
        return emailContacte;
    }

    /**
     * setter email contacte
     * @param emailContacte indica el email de l'associacio
     */
    public void setEmailContacte(String emailContacte){
        this.emailContacte = emailContacte;
    }

    /**
     * getter president de l'associacio
     */
    public String getPresident(){
        return presidentAssociacio;
    }

    /**
     * getter secretari de l'associacio
     */
    public String getSecretari(){
        return secretariAssociacio;
    }

    /**
     * getter tresorer de l'associacio
     */
    public String getTresorer(){
        return tresorerAssociacio;
    }

    /**
     * Mètode per obtenir les titulacions
     * @return titulació del membre
     */
    public String[] obtenirTitulacions(){
        return titulacions;
    }

    /**
     * Mètode per afegir un nou membre a la associacio
     * @param membre persona interessada que es vol afegir 
     */
    public void afegirMembres(String membre){
        if(nombreMemebres < MAX_MEMBRES){
            membres[nombreMemebres] = membre;
            nombreMemebres++;  
        }else{
            System.out.println("Ho sentim. No es poden afegir mes membres, no hi ha places disponibles\n");
        }
    }

    /**
     * Mètode per eliminar un membre de la associació
     * @param membre persona que es vol eliminar
     */
    public void eliminarMembres(String membre){
        for(int i=0; i<nombreMemebres; i++){
            if (membres[i].equals(membre)) {
                membres[i] = membres[nombreMemebres-1];     //Movem l'ultim membre de la posició eliminada per no tenir espais lliures
                membres[nombreMemebres-1] = null;
                nombreMemebres--;
                if (membre.equals(presidentAssociacio)) {
                    presidentAssociacio = null;
                }
                if (membre.equals(secretariAssociacio)) {
                    secretariAssociacio = null;
                }
                if (membre.equals(tresorerAssociacio)) {
                    tresorerAssociacio = null;
                }
                break;
            }
        }
    }

    /**
     * Mètode per obtenir els membres de l'associacio
     * @return membres actuals de l'associacio
     */
    public String[] obtenirMembres(){
        String[] membresActuals = new String[nombreMemebres];
        System.arraycopy(membres, MAX_MEMBRES, membresActuals, 0, nombreMemebres);
        return membresActuals;
    }

    /**
     * Mètode per crear una copia de la classe Associacio
     * @return copia de l'associacio
     */
    public Associacio copia(){
        Associacio copiaAssociacio = new Associacio(
            this.nomAssociacio, this.emailContacte, this.titulacions, this.membres, 
            this.presidentAssociacio, this.secretariAssociacio, this.tresorerAssociacio, 
            this.nombreMemebres, this.nombreAccions);
        return copiaAssociacio;
    }

    /**
     * toString que @return en un string els atributs de la classe
     * es necesari per guardar les dades en un fitxer
     * en la classe LlistaAssociacionsSerial.java
     * format: "nomAssociacio;emailContacte;titulacions;membres;presidentAssociacio;secretariAssociacio;tresorerAssociacio;nombreMemebres;nombreAccions"
     * on membres/titulacions format: "membre1,membre2,membre3,..."
     * @author Marc Badia
     */
    public String toStringSerial(){
        String membresString = "";
        String titulacionsString = "";
        for (int i = 0; i < nombreMemebres; i++) {
            membresString += membres[i] + ",";
        }
        for (int i = 0; i < titulacions.length; i++) {
            titulacionsString += titulacions[i] + ",";
        }
        return nomAssociacio + ";" + emailContacte + ";" + titulacionsString + ";" + membresString + ";" + presidentAssociacio + ";" + secretariAssociacio + ";" + tresorerAssociacio + ";" + nombreMemebres + ";" + nombreAccions;
    }   //no sembla que les titulacions funcionin correctament, 
        //els membres tampoc semblen funcionar de la manera esperada,
        //el president, secretari i tresorer conten com a nMembres?
        //te sentit inicialitzar nMembres com a parametre del constructor?

}


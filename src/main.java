import java.util.Scanner;

public class main {
    ///
    static Scanner teclat = new Scanner(System.in);

    private static void mostrarMenu(){
        int opcio;
        do{
            System.out.println("\nEscull una opcio del menu:\n");
            System.out.println("\nMenu d'opcions:");
            System.out.println("\n1. Mostrar les dades de la llista d'associacions:");
            System.out.println("\n2. Mostrar les dades de la llista de membres que formen part d’una associació (afegint filtre per a professors, alumnes o ambdós):");
            System.out.println("\n3. Mostrar les dades de la llista de membres actius, que formen part de qualsevol associació (afegint filtre per a professors, alumnes o ambdós):");
            System.out.println("\n4. Mostrar les dades de la llista d’accions (afegint filtre o no per tipus d’acció):");
            System.out.println("\n5. Obtenir i mostrar la llista d’accions que ofereix una associació concreta:");
            System.out.println("\n6. Obtenir i mostrar la llista de les xerrades que es duen a terme en una franja de dates indicada per teclat:");
            System.out.println("\n7. Afegir una nova associació:");
            System.out.println("\n8. Alta d’un membre a una associació:");
            System.out.println("\n9. Afegir una nova xerrada:");
            System.out.println("\n10. Afegir una nova demostració:");
            System.out.println("\n11. Consultar i mostrar les dades de les demostracions que es consideren no actives:");
            System.out.println("\n12. Calcular la persona més activa (la que participa en més associacions):");
            System.out.println("\n13. Consultar i mostrar les dades de les xerrades que ha tingut més d’un cert nombre indicat d’assistents:");
            System.out.println("\n14. Valorar una xerrada per part d’un assistent:");
            System.out.println("\n15. Consultar i mostrar la xerrada que està millor valorada:");
            System.out.println("\n16. Mostrar les dades de les xerrades que farà una persona concreta:");
            System.out.println("\n17. Donar de baixa les demostracions que no estiguin actives i que es van dissenyar abans d’una certa data:");
            System.out.println("\n18. Sortir de l'aplicacio:");
    
            opcio = Integer.parseInt(teclat.nextLine());
    
            switch (opcio) {
                case 1:
                    System.out.println("\nHeu escollit:");
                    System.out.println("1.Mostrar les dades de la llista d'associacions):\n\n");
                    //
                    break;
                case 2:
                    System.out.println("\nHeu escollit:");
                    System.out.println("2. Mostrar les dades de la llista de membres que formen part d’una associació (afegint filtre per a professors, alumnes o ambdós):\n");
                    //
                    break;
                case 3:
                    System.out.println("\nHeu escollit:");
                    System.out.println("3. Mostrar les dades de la llista de membres actius, que formen part de qualsevol associació (afegint filtre per a professors, alumnes o ambdós):\n");
                    //
                    break;
                case 4:
                    System.out.println("\nHeu escollit:");
                    System.out.println("4. Mostrar les dades de la llista d’accions (afegint filtre o no per tipus d’acció):\n\n");
                    //
                    break;
                case 5:
                    System.out.println("\nHeu escollit:");
                    System.out.println("5. Obtenir i mostrar la llista d’accions que ofereix una associació concreta:\n");
                    //
                    break;
                case 6:
                    System.out.println("\nHeu escollit:");
                    System.out.println("6. Obtenir i mostrar la llista de les xerrades que es duen a terme en una franja de dates indicada per teclat:\n\n");
                    //
                    break;
                case 7:
                    System.out.println("\nHeu escollit:");
                    System.out.println("7. Afegir una nova associació:\n\n");
                    //
                    break;
                case 8:
                    System.out.println("\nHeu escollit:");
                    System.out.println("8. Alta d’un membre a una associació:\n\n");
                    /*Es pot donar el cas que el membre sigui nou, i s’haurà d’introduir tota la informació del membre, o que el membre ja participi 
                    en una altra associació i en aquest cas serà afegir la relació corresponent */
                    //
                    break;
                case 9:
                    System.out.println("\nHeu escollit:");
                    System.out.println("9. Afegir una nova xerrada:\n\n");
                    //
                    break;
                case 10:
                    System.out.println("\nHeu escollit:");
                    System.out.println("10. Afegir una nova demostració:\n");
                    //
                    break;
                case 11:
                    System.out.println("\nHeu escollit:");
                    System.out.println("11. Consultar i mostrar les dades de les demostracions que es consideren no actives:\n");
                    /*Calcular el cost econòmic total que va suposar preparar totes aquestes demostracions */
                    //
                    break;
                case 12:
                    System.out.println("\nHeu escollit:");
                    System.out.println("12. Calcular la persona més activa (la que participa en més associacions):\n");
                    /*En cas d’empat es considera la que té més antiguitat (en qualsevol associació). Si encara hi ha empat, s’escull qualsevol de les persones que compleixen els requisits */
                    //
                    break;
                case 13:
                    System.out.println("\nHeu escollit:");
                    System.out.println("13. Consultar i mostrar les dades de les xerrades que ha tingut més d’un cert nombre indicat d’assistents:\n");
                    //
                    break;
                case 14:
                    System.out.println("\nHeu escollit:");
                    System.out.println("14. Valorar una xerrada per part d’un assistent:\n");
                    //
                    break;
                case 15:
                    System.out.println("\nHeu escollit:");
                    System.out.println("15. Consultar i mostrar la xerrada que està millor valorada:\n");
                    /*que serà la que té la mitjana de valoracions més alta), en cas d’empat en la nota, considerar la que ha tingut més valoracions i
                    en cas d’empat agafar qualsevol */
                    //
                    break;
                case 16:
                    System.out.println("\nHeu escollit:");
                    System.out.println("16. Mostrar les dades de les xerrades que farà una persona concreta:\n");
                    //
                    break;
                case 17:
                    System.out.println("\nHeu escollit:");
                    System.out.println("17. Donar de baixa les demostracions que no estiguin actives i que es van dissenyar abans d’una certa data:\n");
                    //
                    break;
                case 18:
                    System.out.println("\nHeu escollit:");
                    System.out.println("18. Sortir de l'aplicacio. Fins la propera!");
                    break;
                default:
                    System.out.println("\nOpcio no valida. Intenta de nou\n");
                    break;
            }
        } while (opcio != 18);
    
    }
}





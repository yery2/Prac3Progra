package AplicacioIG;

import java.time.LocalDate;
import Clases.*;
import Graficos.*;
import ListaClases.LlistaActivitats;
import ListaClases.LlistaEntitats;

public class AppIG {
    
    public static void main(String[] args){
            //Llista entitats
            LlistaEntitats ent = new LlistaEntitats(10);
            ent.afegir(new Entitats("Generalitat", 496784334, "gen@generalitat.com"));
            ent.afegir(new Entitats("Generalitat", 123456789, "gen@generalitat.com"));
            ent.afegir(new Entitats("Perritos Guapos", 364735435, "adoptaunperrito@gmail.dog"));
            ent.afegir(new Entitats("Hospital Sant Pau", 932123456, "info@hsantpau.cat"));
            ent.afegir(new Entitats("Biblioteca Central", 933987654, "info@bibliotecacentral.org"));
            ent.afegir(new Entitats("Teatre Lliure", 934111222, "info@teatrelliure.es"));
            
            //Tallers: Rang [0,9]
            LlistaActivitats a = new LlistaActivitats(30);
            LocalDate date = LocalDate.of(2023,10,10);
            LocalDate date2 = LocalDate.of(2023,10,19);
            LocalDate date3 = LocalDate.of(2023,10,11);
            a.afegir(new Tallers("Moda", "BCN", 27, date, ent.getLlistaEntitats()[1], 11, 2, 10));
            a.afegir(new Tallers("Nata Montada", "BCN", 21, date2, ent.getLlistaEntitats()[2], 17, 3, 0));
            a.afegir(new Tallers("Arte Abstracto", "Valencia", 18, date2, ent.getLlistaEntitats()[3], 8, 2, 12));
            a.afegir(new Tallers("Jardinería Urbana", "Sevilla", 22, date, ent.getLlistaEntitats()[4], 10, 3, 15));
            a.afegir(new Tallers("Cine Independiente", "Barcelona", 30, date, ent.getLlistaEntitats()[0], 12, 4, 20));
            a.afegir(new Tallers("Programación para Principiantes", "Madrid", 25, date, ent.getLlistaEntitats()[1], 15, 5, 25));
            a.afegir(new Tallers("Danza Contemporánea", "Zaragoza", 20, date, ent.getLlistaEntitats()[2], 18, 6, 0));
            a.afegir(new Tallers("Escultura en Papel", "Granada", 16, date, ent.getLlistaEntitats()[3], 14, 4, 22));
            //Moda es repetida y no se añade
            a.afegir(new Tallers("Moda", "Valencia", 28, date, ent.getLlistaEntitats()[5], 20, 8, 35));
            a.afegir(new Tallers("Pintura al Aire Libre", "Barcelona", 24, date3, ent.getLlistaEntitats()[0], 16, 7, 28));

            //Visites: Rang [10, 19]
            a.afegir(new Visites("Medi Ambient", "VLC", 24,  date, ent.getLlistaEntitats()[1], true, false));
            a.afegir(new Visites("Exploración Natural", "Granada", 18, date, ent.getLlistaEntitats()[2], false, false));
            a.afegir(new Visites("Ruta del Vino", "La Rioja", 15, date, ent.getLlistaEntitats()[3], true, false));
            a.afegir(new Visites("Exploración Arqueológica", "Cádiz", 20, date, ent.getLlistaEntitats()[4], false, true));
            a.afegir(new Visites("Turismo Rural", "Salamanca", 18, date, ent.getLlistaEntitats()[0], true, true));
            a.afegir(new Visites("Descubre la Naturaleza", "Alicante", 25, date3, ent.getLlistaEntitats()[0], false, false));
            a.afegir(new Visites("Visita a Museo de Ciencias", "Barcelona", 30, date, ent.getLlistaEntitats()[1], true, true));
            a.afegir(new Visites("Recorrido Gastronómico", "Valencia", 22, date, ent.getLlistaEntitats()[2], true, false));
            a.afegir(new Visites("Tour Histórico", "Sevilla", 28, date, ent.getLlistaEntitats()[3], false, true));
            a.afegir(new Visites("Aventura en Montaña", "Granada", 24, date, ent.getLlistaEntitats()[4], true, false));

            //Xerrades: Rang [20, 29]      
            a.afegir(new Xerrades("Como cuidar a tu perro", "TGN", 31, date, ent.getLlistaEntitats()[0], "Mireya"));
            a.afegir(new Xerrades("El Futuro de la Tecnología", "Madrid", 60, date, ent.getLlistaEntitats()[1], "Ing. García"));
            a.afegir(new Xerrades("Impacto de la Inteligencia Artificial", "Madrid", 45, date, ent.getLlistaEntitats()[1], "Dr. Martínez"));
            a.afegir(new Xerrades("Viaje por la Literatura Clásica", "Barcelona", 50, date3, ent.getLlistaEntitats()[2], "Prof. Sánchez"));
            a.afegir(new Xerrades("Tendencias en Moda", "Valencia", 40, date, ent.getLlistaEntitats()[3], "Dra. García"));
            a.afegir(new Xerrades("Mitos y Leyendas Urbanas", "Sevilla", 35, date, ent.getLlistaEntitats()[4], "Lic. Rodríguez"));
            a.afegir(new Xerrades("Evolución de la Fotografía", "Zaragoza", 60, date, ent.getLlistaEntitats()[0], "Dr. Fernández"));
            a.afegir(new Xerrades("Música en el Siglo XXI", "Granada", 55, date, ent.getLlistaEntitats()[1], "Prof. López"));
            a.afegir(new Xerrades("Innovación en Tecnología", "Alicante", 48, date, ent.getLlistaEntitats()[2], "Ing. Pérez"));
            a.afegir(new Xerrades("Historia del Arte Moderno", "Barcelona", 65, date, ent.getLlistaEntitats()[3], "Dra. Ruiz")); 
            
        Finestra1 finestra = new Finestra1("Setmana de la ciència a la URV");        
        finestra.iniContingutFinestra1(a);
    }
    
}

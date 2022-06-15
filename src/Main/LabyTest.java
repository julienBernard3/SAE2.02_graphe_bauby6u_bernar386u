package Main;

import Algo.*;
import laby.Labyrinthe;

import javax.print.DocPrintJob;
import java.io.IOException;
import java.util.List;

public class LabyTest {
    public static void main(String[] args) throws IOException {
        //generation du labyrinthe
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        //Generation du graphe correspondant au labyrinthe
        GrapheListe g = laby.genererGraphe();
        BellmanFord bf = new BellmanFord();
        Dijkstra dJ = new Dijkstra();

        //test point fixe sur le labyrinthe avec l algorithme de BellmanFord
        Valeur v = dJ.resoudre(g, "\"1,1\"");
        //Calcule du chemin minimal de 1,1 à 5,5
        List<String> cheminMin = v.calculerChemin("\"5,5\"");
//        System.out.println(g.toGraphviz());
        System.out.println(g.toString());

        //Test deuxieme methode : avec la classe GrapheLabyrinthe
        Labyrinthe laby2 = new Labyrinthe("labySimple/laby1.txt");
        GrapheLabyrinthe gL = new GrapheLabyrinthe(laby2);
        //Test avec l'algorithme
        v = dJ.resoudre(gL, "\"1,1\"");
        //Calcule du chemin minimal de 1,1 a 8,1
        System.out.println(gL.cheminCourt("\"1,1\"", "\"8,1\""));

    }
}

package Main;

import Algo.GrapheListe;

public class MainGrapheListe {
    public static void main(String[] args) {
        //Creation d'un graphe à
        GrapheListe gL = new GrapheListe();

        //Ajout des arcs du graphe GrapheBoucle.txt
        gL.ajouterArc("A", "B", 20);
        gL.ajouterArc("A", "D", 3);
        gL.ajouterArc("D", "C", 4);
        gL.ajouterArc("C", "B", 2);
        gL.ajouterArc("B", "G", 10);
        gL.ajouterArc("G", "F", 5);
        gL.ajouterArc("F", "E", 3);


        System.out.println(gL.toGraphviz());

        GrapheListe gL2 = new GrapheListe("GrapheExemple/GrapheBoucle.txt");
        System.out.println(gL2.toGraphviz());
    }
}

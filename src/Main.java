import javax.print.DocPrintJob;

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
        GrapheListe gL = new GrapheListe("graphe/GrapheEx1.txt");
//        gL.ajouterArc("D", "C", 10);
//        gL.ajouterArc("A", "B", 12);
//        gL.ajouterArc("D", "B", 23);
//        gL.ajouterArc("A", "D", 87);
//        gL.ajouterArc("E", "D", 43);
//        gL.ajouterArc("B", "E", 11);
//        gL.ajouterArc("C", "A", 19);

//        gL.ajouterArc("A", "D", 87);
//        gL.ajouterArc("B", "E", 11);
//        gL.ajouterArc("C", "A", 19);
//        gL.ajouterArc("D", "B", 23);
//        gL.ajouterArc("D", "C", 10);
//        gL.ajouterArc("E", "D", 43);
//        gL.ajouterArc("A", "B", 12);
//

//
//        System.out.println(gL.toString());
//        System.out.println(gL.toGraphviz());

        BellmanFord bf = new BellmanFord();
        System.out.println("2");
        Valeur v = bf.resoudre(gL, "A");
        System.out.println("3");
//        System.out.println(gL.toGraphviz());
//        System.out.println("Oue");
        System.out.println(v);


        System.out.println( v.calculerChemin("C"));

        Dijkstra dJ = new Dijkstra();
        Valeur v2 = dJ.resoudre(gL, "A");
        System.out.println(v2);

    }
}

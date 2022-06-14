public class MainDijkstra {

    public static void main(String[] args) {
        GrapheListe gL = new GrapheListe("graphe/GrapheEx1.txt");
        Dijkstra dJ = new Dijkstra();
        Valeur v2 = dJ.resoudre(gL, "A");
        System.out.println(v2);
    }
}

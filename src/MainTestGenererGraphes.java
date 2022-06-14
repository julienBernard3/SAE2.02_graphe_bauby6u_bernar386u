import java.util.ArrayList;
import java.util.List;

public class MainTestGenererGraphes {
    public static void main(String[] args) {

        GenerererGraphes g = new GenerererGraphes(4000, 1000, 10);
        GrapheListe gL = g.genererGrapheAleatoire();
        long timeTotalDij = 0;
        long timeTotalBell = 0;

        //Creation d'une liste de graphes générer aléatoirement avec les mêmes paramètres
        List<GrapheListe> listeGraphes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listeGraphes.add(g.genererGrapheAleatoire());
        }

        //test algorithme BellmanFord
        long timeBellman = System.nanoTime();
        for (GrapheListe gL2 : listeGraphes) {
            BellmanFord bF = new BellmanFord();
            bF.resoudre(gL2, "1");
            timeTotalBell += System.nanoTime() - timeBellman;
        }

        //Test algorithme Dijkstra
        long timeDijkstra = System.nanoTime();
        for (GrapheListe gL2 : listeGraphes) {
            Dijkstra dJ = new Dijkstra();
            dJ.resoudre(gL2, "1");
            timeTotalDij += System.nanoTime() - timeDijkstra;
        }

        System.out.println("Temps d'execution Dijkstra: " + (timeTotalDij) / 1000000 + " ms");
        System.out.println("Temps d'execution BelmanFord: " + (timeTotalBell) / 1000000 + " ms");

    }
}

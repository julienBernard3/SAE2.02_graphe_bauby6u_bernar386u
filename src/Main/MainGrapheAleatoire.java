package Main;

import Algo.GenerererGraphes;
import Algo.GrapheListe;

public class MainGrapheAleatoire {
    public static void main(String[] args) {
        GrapheListe gA = new GrapheListe();
        GenerererGraphes gG = new GenerererGraphes(17, 10, 10);
        gA = gG.genererGrapheAleatoire();
        System.out.println(gA.toGraphviz());

    }
}

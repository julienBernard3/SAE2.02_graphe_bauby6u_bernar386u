package Main;

import Algo.GrapheListe;
import laby.Labyrinthe;

import java.io.IOException;

public class LabyTest {
    public static void main(String[] args) throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        GrapheListe g =  laby.genererGraphe();
        System.out.println(g.toGraphviz());

    }
}

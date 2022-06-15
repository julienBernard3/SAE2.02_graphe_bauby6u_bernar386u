import Algo.Dijkstra;
import Algo.GrapheLabyrinthe;
import Algo.GrapheListe;
import Algo.Valeur;
import laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testLabyrinthe {

    @Test
    public void testChargerLaby() throws IOException {
        //Preparation des donnees
        //Methode 1
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        GrapheListe g =  laby.genererGraphe();

        //Methode 2
        GrapheLabyrinthe g2 = new GrapheLabyrinthe(new Labyrinthe("labySimple/laby0.txt"));

        //Verification avec la taille car l ordre est different
        assertEquals(g2.listeDnsNoeud().size(), g.listeDnsNoeud().size());
    }

    @Test
    public void testDeuxMethods() throws IOException {
        //Preparation des donnes
        //Methode 1
        Dijkstra dJ = new Dijkstra();
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");
        GrapheListe g =  laby.genererGraphe();
        Valeur v1 = dJ.resoudre(g, "\"1,1\"");
        List<String> cheminMethode1 = v1.calculerChemin("\"5,6\"");

        //Methode 2
        GrapheLabyrinthe g2 = new GrapheLabyrinthe(new Labyrinthe("labySimple/laby1.txt"));
        List<String> cheminMethode2 = g2.cheminCourt("\"1,1\"","\"5,6\"");

        //Verifications avec un chemin minimale (1 seul juste et pas d egalite)
        assertEquals(cheminMethode1, cheminMethode2);
    }
}

package Main;

import Algo.BellmanFord;
import Algo.GrapheListe;
import Algo.Valeur;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class MainTestBellmanFord {
    public static void main(String[] args) throws IOException {
        //effectue Algo.BellmanFord pour tous les graphes du dossier graphe
        //ajout d'un timer pour comparer les temps d'execution

        //test Algo.Dijkstra
        GrapheListe gL;
        //Creation d'un dossier contenant tous les graphes
        File ListGraphes = new File("graphe");
        BellmanFord bF = new BellmanFord();
        //Creation d'un tableau de fichiers contenant tous les graphes
        File[] listeGraphes = ListGraphes.listFiles();
        long timeBelmanFord = System.nanoTime();
        int i = 0;
        //Parcours de tous les graphes dans l'ordre
        for (File f : listeGraphes) {
            //Verification si le fichier est un fichier texte
            if (f.getName().endsWith(".txt")) {
                gL = new GrapheListe("graphe/" + f.getName());
                Valeur v2 = bF.resoudre(gL, "1");
    
            }
        }

        long timeEndBelmanFord = System.nanoTime();

        System.out.println("Temps d'execution : " + (timeEndBelmanFord - timeBelmanFord) / 1000000 + " ms");
    }


}

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class MainTestBellmanFord {
    public static void main(String[] args) throws IOException {
        //effectue BellmanFord pour tous les graphes du dossier graphe
        //ajout d'un timer pour comparer les temps d'execution

        //test Dijkstra
        long timeBelmanFord = System.nanoTime();
        GrapheListe gL;
        File ListGraphes = new File("graphe");
        BellmanFord bF = new BellmanFord();
        File[] listeGraphes = ListGraphes.listFiles();
        int i = 0;
        for (File f : listeGraphes) {
            if (f.getName().endsWith(".txt")) {
                gL = new GrapheListe("graphe/" + f.getName());
                Valeur v2 = bF.resoudre(gL, "1");
                System.out.println(i);
                i++;

            }
        }

        long timeEndBelmanFord = System.nanoTime();

        System.out.println("Temps d'execution : " + (timeEndBelmanFord - timeBelmanFord) / 1000000 + " ms");
    }

    public static String getFirstChar(String s) throws IOException {
        //create reader
        StringReader reader = new StringReader(s);
        //read first char
        int c = reader.read();
        //return char
        return Character.toString((char) c);
    }
}

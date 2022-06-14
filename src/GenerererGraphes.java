public class GenerererGraphes {
    //generer un graphe aleatoire
    public static void main(String[] args) {

        int nbArcs = 10;
        int nbNoeuds = 10;
        int coutMax = 10;
        GrapheListe g = new GrapheListe();

        for (int i = 0; i < nbNoeuds; i++) {
            g.ajouterArc(String.valueOf(i), String.valueOf(i + 1), (int) (Math.random() * coutMax));
        }
        for (int i = 0; i < nbArcs; i++) {
            int depart;
            int arrivee;
            do {
                depart = (int) (Math.random() * nbNoeuds);
                arrivee = (int) (Math.random() * nbNoeuds);
            }while (depart != arrivee && g.existe(String.valueOf(depart), String.valueOf(arrivee)));

            g.ajouterArc(String.valueOf(depart), String.valueOf(arrivee), (int) (Math.random() * coutMax));
        }
        System.out.println(g.toGraphviz());
    }
}

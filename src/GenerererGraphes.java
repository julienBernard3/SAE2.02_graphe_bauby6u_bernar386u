public class GenerererGraphes {
    //generer un graphe aleatoire
    public static void main(String[] args) {

        int nbArcs = 5;
        int nbNoeuds = 10;
        int coutMax = 10;
        GrapheListe g = new GrapheListe();

        for (int i = 0; i < nbNoeuds; i++) {
            g.ajouterArc(String.valueOf(i), String.valueOf(i + 1), (int) (Math.random() * coutMax));
        }
        for (int i = 0; i < nbArcs; i++) {
            int depart = (int) (Math.random() * nbNoeuds);
            int arrivee = (int) (Math.random() * nbNoeuds);

            if (depart != arrivee) {
                g.ajouterArc(String.valueOf(depart), String.valueOf(arrivee), (int) (Math.random() * coutMax));
            }
        }
        System.out.println(g.toGraphviz());
    }
}

public class GenerererGraphes {
    //generer un graphe aleatoire

    int nbArcs;
    int nbNoeuds;
    int coutMax;

    public GenerererGraphes(int nbArc, int nbNoeud, int coutMax) {
        this.nbArcs = nbArc;
        this.nbNoeuds = nbNoeud;
        this.coutMax = coutMax;
    }

    public GrapheListe genererGrapheAleatoire() {
        GrapheListe g = new GrapheListe();

        for (int i = 0; i < nbNoeuds; i++) {
            g.ajouterArc(String.valueOf(i), String.valueOf(i + 1), (int) (Math.random() * coutMax));
        }
        for (int i = 0; i < nbArcs - nbNoeuds + 1; i++) {
            int depart;

            int arrivee;
            do {
                depart = (int) (Math.random() * nbNoeuds);
                arrivee = (int) (Math.random() * nbNoeuds);
            } while (depart == arrivee || g.existe(String.valueOf(depart), String.valueOf(arrivee)));

            g.ajouterArc(String.valueOf(depart), String.valueOf(arrivee), (int) (Math.random() * coutMax) + 1);
        }
        return g;
    }
}

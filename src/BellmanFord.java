import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    /**
     * Methode qui prend un graphe et un noeud de depart et renvoie les distances et parents de chaque noeuds
     *
     * @param g      le graphe
     * @param depart le noeud de depart
     * @return Distances pour chaque noeuds
     */
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        List<String> listeNoeuds = g.listeNoeuds();
        //parcours listeNoeuds
        for (int i = 0; i < listeNoeuds.size(); i++) {
            v.setParent(listeNoeuds.get(i), null);
            v.setValeur(listeNoeuds.get(i), Double.POSITIVE_INFINITY);
        }
        v.setValeur(depart, 0);
        Valeur ancien = new Valeur();

        while (!ancien.equals(v)) {
            ancien = new Valeur(v);
            for (int i = 0; i < listeNoeuds.size(); i++) {
                for (int j = 0; j < g.suivants(listeNoeuds.get(i)).size(); j++) {
                    if (v.getValeur(g.suivants(listeNoeuds.get(i)).get(j).getDest()) > (v.getValeur(listeNoeuds.get(i)) + g.suivants(listeNoeuds.get(i)).get(j).getPoids())) {
                        v.setValeur(g.suivants(listeNoeuds.get(i)).get(j).getDest(), v.getValeur(listeNoeuds.get(i)) + g.suivants(listeNoeuds.get(i)).get(j).getPoids());
                        v.setParent(g.suivants(listeNoeuds.get(i)).get(j).getDest(), g.listeNoeuds().get(i));
                    }

                }
            }
        }


        return v;
    }
}

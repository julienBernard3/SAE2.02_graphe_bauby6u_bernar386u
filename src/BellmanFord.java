import java.util.List;

public class BellmanFord {

    /**
     * Methode qui prend un graphe et un noeud de depart et renvoie les distances et parents de chaque noeuds
     * @param g le graphe
     * @param depart le noeud de depart
     * @return Distances pour chaque noeuds
     */
    public Valeur resoudre(Graphe g, String depart){
        Valeur v = new Valeur();
        v.setValeur(depart, 0);
        List<Arc> listeNoeuds = g.suivants(depart);
        for (int i = 0; i < listeNoeuds.size(); i++) {
            v.setParent(listeNoeuds.get(i).getDest(), depart);
        }

        return null;
    }
}

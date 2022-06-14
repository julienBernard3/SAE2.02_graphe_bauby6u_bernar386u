import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
//    Entrees :
//    G un graphe oriente avec une ponderation (poids) positive des arcs
//    A un sommet (depart) de G
//    Debut
//      Q <- {} // utilisation d’une liste de noeuds `a traiter
//      Pour chaque sommet v de G faire
//          v.distance <- Infini
//          v.parent <- Ind´efini
//          Q <- Q U {v} // ajouter le sommet v `a la liste Q
//      Fin Pour
//      A.distance <- 0
//      Tant que Q est un ensemble non vide faire
//          u <- un sommet de Q telle que u.distance est minimale
//          Q <- Q \ {u} // enlever le sommet u de la liste Q
//          Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
//          D <- u.distance + poids(u,v)
//          Si D < v.distance
//              Alors v.distance <- D
//                  v.parent <- u
//              Fin Si
//          Fin Pour
//      Fin Tant que
//      Fin

    public Valeur resoudre(Graphe g, String depart) {
//        Debut
//      Q <- {} // utilisation d’une liste de noeuds `a traiter
        List<String> Q = new ArrayList<String>();

        Valeur v = new Valeur();
//      Pour chaque sommet v de G faire
//          v.distance <- Infini
//          v.parent <- Ind´efini
//          Q <- Q U {v} // ajouter le sommet v `a la liste Q
//      Fin Pour
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setParent(g.listeNoeuds().get(i), null);
            v.setValeur(g.listeNoeuds().get(i), Double.POSITIVE_INFINITY);
            Q.add(g.listeNoeuds().get(i));
        }
//      A.distance <- 0
        v.setValeur(depart, 0);
//      Tant que Q est un ensemble non vide faire
        while (!Q.isEmpty()) {
//          u <- un sommet de Q telle que u.distance est minimale
            String u = recupererValMin(Q, v);
//          Q <- Q \ {u} // enlever le sommet u de la liste Q
            Q.remove(u);
//          Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
            for (int j = 0; j < g.suivants(u).size(); j++) {
                //D <- u.distance + poids(u,v)
                double D = v.getValeur(u) + g.suivants(u).get(j).getPoids();
//                 Si D < v.distance

                if (D < v.getValeur(g.suivants(u).get(j).getDest())) {
//                 Alors v.distance <- D
                    v.setValeur(g.suivants(u).get(j).getDest(), D);
//                 v.parent <- u
                    v.setParent(g.suivants(u).get(j).getDest(), u);
//                 Fin Si
                }
//                 Fin Pour
                System.out.println(v);
            }
//              Fin Tant que
        }
        return v;
//          Fin
    }

    /**
     * Methode qui retourne la plus petite valeur de la liste
     *
     * @param Q   la liste de valeurs
     * @param val la valeur a comparer
     * @return la plus petite valeur de la liste
     */
    public String recupererValMin(List<String> Q, Valeur val) {
        String retour = Q.get(0);
        for (int i = 1; i < Q.size(); i++) {
                if (val.getValeur(Q.get(i)) < val.getValeur(retour)) {
                    retour = Q.get(i);
                }
        }
        return retour;
    }
}

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
        v.setValeur(depart, 0);
        List<String> listeNoeuds = g.listeNoeuds();
        //parcours listeNoeuds
        for (int i = 0; i < listeNoeuds.size(); i++) {
            v.setParent(listeNoeuds.get(i), null);
            v.setValeur(listeNoeuds.get(i), Double.POSITIVE_INFINITY);
        }
        v.setValeur(depart, 0);
        Valeur ancien = new Valeur();
        System.out.println("PREMIER"  + v.getValeur(depart));
        System.out.println(v.getValeur(listeNoeuds.get(0)) + " " + v.getValeur(depart) + g.suivants(listeNoeuds.get(0)).get(0).getPoids());
        System.out.println("NOM " + listeNoeuds.get(0));
        System.out.println("NOM " + listeNoeuds.get(1));
        System.out.println("NOM " + listeNoeuds.get(2));

        while (!ancien.equals(v)) {
            ancien = new Valeur(v);
            System.out.println("VERIFICATION C LA MM VALEUR" + ancien.equals(v));

//            System.out.println(listeNoeuds.size());
//            System.out.println(g.listeNoeuds().size());
            for (int i = 0; i < listeNoeuds.size(); i++) {
                for (int j = 0; j < g.suivants(listeNoeuds.get(i)).size(); j++) {
                    System.out.println(i + " " + j);
//                    System.out.println("PREMIER"  + v.getValeur(depart));
                    System.out.println(v.getValeur(listeNoeuds.get(j)) + " " + v.getValeur(listeNoeuds.get(i)) + g.suivants(listeNoeuds.get(i)).get(j).getPoids());
                    if (v.getValeur(listeNoeuds.get(j)) > (v.getValeur(listeNoeuds.get(i)) + g.suivants(listeNoeuds.get(i)).get(j).getPoids())) {
                        v.setValeur(listeNoeuds.get(j), v.getValeur(listeNoeuds.get(i)) + g.suivants(listeNoeuds.get(i)).get(j).getPoids());
                        v.setParent(g.listeNoeuds().get(j), g.listeNoeuds().get(i));
                        System.out.println("hello");
                    }

                }
                if (i == 3) {
                    System.out.println(ancien);;
                    System.out.println(v);
                    break;
                }
            }
        }


        return v;
    }
}

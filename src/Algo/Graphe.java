package Algo;

import java.util.List;

public interface Graphe {
    /**
     * Methode qui retourne tous les noms des noeuds du graphe
     *
     * @return list des nom
     */
    public List<String> listeNoeuds();



    /**
     * Methode qui retourne la liste des arcs apres le noeuds en param
     *
     * @param n le noeud apres lequel on veut recuperer la liste
     * @return la liste des arc apres le noeud
     */
    public List<Arc> suivants(String n);

}

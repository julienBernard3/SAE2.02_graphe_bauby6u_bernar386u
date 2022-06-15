package Algo;

import java.util.ArrayList;
import java.util.List;

public class Noeud {
    /**
     * Nom du nœud
     */
    private String nom;
    /**
     * Liste des arcs reliant ce nœud `a ses nœuds adjacents
     */
    private List<Arc> adj;

    /**
     * Constructeur de noeud initialisant le nom du noeud et adj a une liste vide
     *
     * @param nom nom du noeud
     */
    public Noeud(String nom) {
        this.nom = nom;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * Methode qui specifie que deux nœuds sont egaux si et seulement si leurs noms sont egaux
     *
     * @param o Algo.Noeud avec lequelle on fait la verification
     * @return si les noeud sont egaux ou non
     */
    public boolean equals(Object o) {
        Noeud noeud = (Noeud) o;
        return this.nom == noeud.nom;
    }

    /**
     * Methode qui ajoute un arc
     *
     * @param destination destination de l arc
     * @param cout        cout de la destination
     */
    public void ajouterArc(Noeud destination, double cout) {
        this.adj.add(new Arc(destination.nom, cout));
    }

    /**
     * Getter adj
     *
     * @return liste des arcs
     */
    public List<Arc> getAdj() {
        return adj;
    }

    public String toString() {
        StringBuffer res = new StringBuffer(this.nom + " -> ");
        for (Arc arc : adj) {
            res.append(arc.toString()).append(" ");
        }
        return res.toString();
    }

    public String toGraphviz() {
        StringBuffer res = new StringBuffer();
        for (Arc arc : adj) {
            res.append(this.nom + " -> ");
            res.append(arc.toGraphviz()).append("\n");
        }
        return res.toString();
    }

    public boolean existe(String arrivee) {
        for (Arc arc : adj) {
            if (arc.getDest().equals(arrivee)) {
                return true;
            }
        }
        return false;
    }
}






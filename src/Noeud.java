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
     * @param nom nom du noeud
     */
    public Noeud (String nom){
        this.nom = nom;
        this.adj = new ArrayList<Arc>();
    }


    /**
     * Methode qui ajoute un arc
     * @param destination destination de l arc
     * @param cout cout de la destination
     */
    public void ajouterArc(Noeud destination, int cout){

    }



}

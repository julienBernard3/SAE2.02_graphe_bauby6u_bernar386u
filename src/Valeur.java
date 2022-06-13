import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * Classe fournie, permet de stocker des valeurs associées au noeud et des parents
 * - un noeud est represente par un String (son nom)
 * - on accede avec des get (getValeur et getParent)
 * - on modifie avec des set (setValeur et setParent)
 */
public class Valeur {

    /**
     * attributs pour stocker les informations (type Table = Dictionnaire)
     * dans le programme de 2 annee.
     */
    Map<String, Double> valeur;
    Map<String, String> parent;

    /**
     * constructeur vide (initialise la possibilité de stocker des valeurs)
     */
    public Valeur() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    public Valeur(Valeur v) {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
        for (String s : v.valeur.keySet()) {
            this.valeur.put(s, v.valeur.get(s));
            this.parent.put(s, v.parent.get(s));
        }
    }

    /**
     * permet d'associer une valeur a un nom de noeud (ici L(X))
     *
     * @param nom    le nom du noeud
     * @param valeur la valeur associée
     */
    public void setValeur(String nom, double valeur) {
        // modifie valeur
        this.valeur.put(nom, valeur);
    }

    /**
     * * permet d'associer un parent a un nom de noeud (ici parent(X))
     *
     * @param nom    nom du noeud
     * @param parent nom du noeud parent associe
     */
    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    /**
     * accede au parent stocke associe au noeud nom passe en parametre
     *
     * @param nom nom du noeud
     * @return le nom du noeud parent
     */
    public String getParent(String nom) {
        return this.parent.get(nom);
    }


    /**
     * accede a la valeur associee au noeud nom passe en parametre
     *
     * @param nom nom du noeud
     * @return la valeur stockee
     */
    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    /**
     * retourne une chaine qui affiche le contenu
     * - par noeud stocke
     * - a chaque noeud, affiche la valeur puis le noeud parent
     *
     * @return descriptif du noeud
     */
    public String toString() {
        String res = "";
        // pour chaque noeud
        for (String s : this.valeur.keySet()) {
            // ajoute la valeur et le noeud parent
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res += s + " ->  V:" + valeurNoeud + " p:" + noeudParent + "\n";
        }
        return res;

    }

    /**
     * Retourne list de noeuds du chemin menant au noeud en param
     *
     * @param destination
     * @return list des noeuds
     */
    public List<String> calculerChemin(String destination) {
        List<String> chemin = new ArrayList<>();
        String noeud = destination;
        while (noeud != null) {
            chemin.add(0, noeud);
            noeud = parent.get(noeud);
        }
        return chemin;
    }

    //equals
    public boolean equals(Valeur v) {
        if (this.valeur.size() != v.valeur.size()) {
            return false;
        }
        for (String s : this.valeur.keySet()) {
            if (!v.valeur.containsKey(s)) {
                return false;
            }
            if (this.valeur.get(s) != v.valeur.get(s)) {
                return false;
            }
        }
        return true;
    }
}

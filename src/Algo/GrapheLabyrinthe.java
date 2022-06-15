package Algo;

import laby.Labyrinthe;

import java.util.ArrayList;
import java.util.List;

public class GrapheLabyrinthe implements Graphe {
    Labyrinthe laby;

    private List<String> ensNom;

    private List<Noeud> ensNoeuds;

    /**
     * Constructeur avec param
     *
     * @param laby le labyrinthe a creer
     */
    public GrapheLabyrinthe(Labyrinthe laby) {
        this.laby = laby;
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();

        for (int i = 0; i < laby.getLength(); i++) {
            for (int j = 0; j < laby.getLengthY(); j++) {
                if (!laby.getMur(i, j)) {
                    int[] cellule = {i, j};
                    List<Arc> suivantes = suivants(reverse(cellule));
                    for (Arc arc : suivantes) {
                        ajouterArc(reverse(cellule), arc.getDest());
                    }
                }
            }
        }
    }

    @Override
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    /**
     * Methode qui renvoie la liste des noeuds adjacents a un noeud
     *
     * @param n le noeud apres lequel on veut recuperer la liste
     * @return la liste des noeuds adjacents
     */
    @Override
    public List<Arc> suivants(String n) {
        List<Arc> arcs = new ArrayList<>();

        //utilise l objet laby pour recuperer la liste des noeuds adjacents
        String[] postition = n.split(",");

        int[] pos = {Integer.parseInt(postition[0].substring(1)), Integer.parseInt(postition[1].substring(0, postition[1].length() - 1))};
        int[] suivantes;
        String[] direction = {Labyrinthe.HAUT, Labyrinthe.BAS, Labyrinthe.GAUCHE, Labyrinthe.DROITE};

        for (int i = 0; i < 4; i++) {
            suivantes = laby.deplacerPerso(pos[0], pos[1], direction[i]);
            if (suivantes != pos) {
                arcs.add(new Arc(reverse(suivantes), 1));
            }

        }

        return arcs;
    }


    public int[] reverse(String n) {
        String[] postition = n.split(",");
        int[] pos = {Integer.parseInt(postition[0].substring(1)), Integer.parseInt(postition[1].substring(0, postition[1].length() - 1))};
        return pos;
    }

    /**
     * Methode qui transforme un tableau de coordonnée en string
     *
     * @param n tableau de coordonnée de type {x, y}
     * @return string de type "x,y"
     */
    public String reverse(int[] n) {
        return "\"" + n[0] + "," + n[1] + "\"";
    }

    /**
     * Methode toString
     *
     * @return La representation du graphe
     */
    public String toString() {
        StringBuffer res = new StringBuffer();
        //parcours la liste des noeuds avec une boucle while
        for (Noeud ensNoeud : this.ensNoeuds) {
            res.append(ensNoeud.toString()).append("\n");

        }
        return res.toString();

    }

    /**
     * Methode toGraphviz
     *
     * @return La representation du graphe en format graphviz
     */
    public String toGraphviz() {
        StringBuffer res = new StringBuffer();
        res.append("digraph {\n");
        for (Noeud ensNoeud : this.ensNoeuds) {
            res.append(ensNoeud.toGraphviz());
        }
        res.append("}");
        return res.toString();
    }

    /**
     * Methode qui ajoute un arc dans le graphe
     *
     * @param depart  le noeud de depart
     * @param arrivee le noeud d'arrivee
     */
    public void ajouterArc(String depart, String arrivee) {
        //Verifie que le noeud ne parte pas vers lui meme
        if (!depart.equals(arrivee)) {
            //Verifie que le noeud de depart n est pas deja dans la liste
            if (!this.ensNom.contains(depart)) {
                this.ensNom.add(depart);
                this.ensNoeuds.add(new Noeud(depart));
            }
            //Verifie que le noeud darrivee n est pas deja dans la liste
            if (!this.ensNom.contains(arrivee)) {
                this.ensNom.add(arrivee);
                this.ensNoeuds.add(new Noeud(arrivee));
            }
            //Si l arc n existe pas on l ajoute
            if (!this.ensNoeuds.get(this.ensNom.indexOf(depart)).existe(arrivee)) {
                this.ensNoeuds.get(this.ensNom.indexOf(depart)).ajouterArc(this.ensNoeuds.get(this.ensNom.indexOf(arrivee)), 1);

            }
        }

    }
}

package Algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public GrapheListe() {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

    /**
     * Constructeur avec en param un nom de fichier
     *
     * @param nom du fichier a charge
     */
    public GrapheListe(String nom) {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();

        try {
            FileReader fichier = new FileReader(nom);
            BufferedReader reader = new BufferedReader(fichier);
            String ligne = reader.readLine();
            String[] ligneSplit;
            while (ligne != null) {
                ligneSplit = ligne.split("\t");
                ajouterArc(ligneSplit[0], ligneSplit[1], Double.parseDouble(ligneSplit[2]));
                ligne = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    public List<Noeud> listeDnsNoeud() {
        return this.ensNoeuds;
    }

    /**
     * Methode qui renvoie la liste des noeuds adjacents a un noeud
     * @param n le noeud apres lequel on veut recuperer la liste
     * @return la liste des noeuds adjacents
     */
    public List<Arc> suivants(String n) {
        if (!ensNom.contains(n)) {
            return null;
        } else {
            return (this.ensNoeuds.get(this.ensNom.indexOf(n)).getAdj());
        }
    }

    /**
     * Methode qui ajoute un arc
     *
     * @param depart origine de l arc
     * @param destination destination de l arc
     * @param cout cout de l arc
     */
    public void ajouterArc(String depart, String destination, double cout) {

        if (!this.ensNom.contains(depart)) {
            this.ensNoeuds.add(new Noeud(depart));
            this.ensNom.add(depart);
        }

        if (!this.ensNom.contains(destination) ) {
            this.ensNoeuds.add(new Noeud(destination));
            this.ensNom.add(destination);
        }
        this.ensNoeuds.get(this.ensNom.indexOf(depart)).ajouterArc(this.ensNoeuds.get(this.ensNom.indexOf(destination)), cout);
    }


    /**
     * Methode toString
     * @return La representation du graphe
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        //parcours la liste des noeuds avec une boucle while
        for (Noeud ensNoeud : this.ensNoeuds) {
            res.append(ensNoeud.toString()).append("\n");

        }
        return res.toString();
    }

    /**
     * affichage d'un arc au format graphviz
     * @return String avec le nom du noeud de destination et le cout au bon format
     */
    public String toGraphviz() {
        StringBuilder res = new StringBuilder();
        res.append("digraph {\n");
        for (Noeud ensNoeud : this.ensNoeuds) {
            res.append(ensNoeud.toGraphviz());
        }
        res.append("}");
        return res.toString();
    }

    /**
     * Methode permetant de savoir s'il existe deja un arc dans un certain sens
     * @param depart origine de l'arc
     * @param destination desination de l'arc
     * @return si l'arc existe deja ou non
     */
    public boolean existe(String depart, String destination){
        List<Arc> list = suivants(depart);
        for(Arc arc : list){
            if(arc.getDest().equals(destination)){
                return true;
            }
        }
        return false;
    }
}

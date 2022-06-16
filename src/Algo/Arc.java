package Algo;

public class Arc {

    private String dest;
    private double cout;

    /**
     * Constructeur d'un arc
     *
     * @param dest nom du noeud de destination
     * @param cout cout ou poids de l arc
     */
    public Arc(String dest, double cout) {
        this.dest = dest;
        this.cout = (cout < 0) ? 1 : cout;
    }

    /**
     * Getter dest
     *
     * @return nom du noeud de destination
     */
    public String getDest() {
        return dest;
    }

    /**
     * affichage d'un arc
     * @return string avec la destination et le cout
     */
    public String toString() {
        return dest + "(" + cout + ")";
    }

    /**
     * affichage d'un arc au format graphviz
     * @return String avec le nom du noeud de destination et le cout au bon format
     */
    public String toGraphviz() {
        return dest + " [label = " + cout + "]";
    }

    /**
     * Getter poids
     * @return poids de l arc
     */
    public double getPoids() {
        return cout;
    }


}

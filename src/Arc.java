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

    public String toString() {
        return dest + "(" + cout + ")";
    }

    public String toGraphviz() {
        return dest + " [label = " + cout + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        GrapheListe gL = new GrapheListe();
//        gL.ajouterArc("D", "C", 10);
//        gL.ajouterArc("A", "B", 12);
//        gL.ajouterArc("D", "B", 23);
//        gL.ajouterArc("A", "D", 87);
//        gL.ajouterArc("E", "D", 43);
//        gL.ajouterArc("B", "E", 11);
//        gL.ajouterArc("C", "A", 19);

        gL.ajouterArc("A", "B", 12);
        gL.ajouterArc("A", "D", 87);
        gL.ajouterArc("B", "E", 11);
        gL.ajouterArc("C", "A", 19);
        gL.ajouterArc("D", "B", 23);
        gL.ajouterArc("D", "C", 10);
        gL.ajouterArc("E", "D", 43);



        System.out.println(gL.toString());
        System.out.println(gL.toGraphviz());
    }

}

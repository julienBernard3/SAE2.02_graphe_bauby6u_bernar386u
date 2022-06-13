import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGraphe {
    @Test
    public void testAffichageGraphe() {
        //Preparation des donnees
        GrapheListe gL = new GrapheListe();

        //Construction du graphe
        gL.ajouterArc("A", "B", 12);
        gL.ajouterArc("A", "D", 87);
        gL.ajouterArc("B", "E", 11);
        gL.ajouterArc("C", "A", 19);
        gL.ajouterArc("D", "B", 23);
        gL.ajouterArc("D", "C", 10);
        gL.ajouterArc("E", "D", 43);

        //Verification
        String res = "A -> B(12.0) D(87.0) \n" +
                "B -> E(11.0) \n" +
                "D -> B(23.0) C(10.0) \n" +
                "E -> D(43.0) \n" +
                "C -> A(19.0)";

        assertEquals("A -> B(12.0) D(87.0) \nB -> E(11.0) \nD -> B(23.0) C(10.0) \nE -> D(43.0) \nC -> A(19.0) \n", gL.toString());
    }

    @Test
    public void testAffichageGraphviz() {

        //Preparation des donnees
        GrapheListe gL = new GrapheListe();

        //Construction du graphe
        gL.ajouterArc("A", "B", 12);
        gL.ajouterArc("A", "D", 87);
        gL.ajouterArc("B", "E", 11);
        gL.ajouterArc("C", "A", 19);
        gL.ajouterArc("D", "B", 23);
        gL.ajouterArc("D", "C", 10);
        gL.ajouterArc("E", "D", 43);

        //Verification
        assertEquals("digraph {\n" +
                "A -> B [label = 12.0]\n" +
                "A -> D [label = 87.0]\n" +
                "B -> E [label = 11.0]\n" +
                "D -> B [label = 23.0]\n" +
                "D -> C [label = 10.0]\n" +
                "E -> D [label = 43.0]\n" +
                "C -> A [label = 19.0]\n" +
                "}", gL.toGraphviz());
    }

    @Test
    public void testConstructeurFichier(){
        //Preparation des donnes
        GrapheListe gL = new GrapheListe("graphe/Graphe1.txt");

        //Verification
        assertEquals("1 -> 2(4.0) 4(15.0) \n" +
                "2 -> 1(1.0) 3(9.0) 4(12.0) 5(8.0) \n" +
                "4 -> 1(7.0) 2(17.0) 3(4.0) 5(11.0) 7(5.0) \n" +
                "3 -> 1(8.0) 2(20.0) 4(36.0) 7(19.0) 8(8.0) 9(3.0) 10(11.0) \n" +
                "5 -> 4(16.0) 6(13.0) 7(10.0) 10(9.0) \n" +
                "7 -> 6(16.0) 8(11.0) 9(5.0) \n" +
                "8 -> 5(12.0) 7(20.0) 9(18.0) \n" +
                "9 -> 3(13.0) 5(3.0) 6(8.0) 8(2.0) 10(11.0) \n" +
                "10 -> 9(18.0) \n" +
                "6 -> 2(18.0) 5(2.0) 7(24.0) 8(10.0) 10(1.0) \n", gL.toString());
    }

    @Test
    public void testBellmanFord(){
        GrapheListe gL = new GrapheListe("graphe/GrapheEx1.txt");
        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(gL, "A");
        assertEquals(0,v.getValeur("A"));
        assertEquals(null,v.getParent("A"));
        assertEquals(12,v.getValeur("B"));
        assertEquals("A",v.getParent("B"));
        assertEquals(76,v.getValeur("C"));
        assertEquals("D",v.getParent("C"));
        assertEquals(66,v.getValeur("D"));
        assertEquals("E",v.getParent("D"));
        assertEquals(23,v.getValeur("E"));
        assertEquals("B",v.getParent("E"));

    }


}

public class MainBellmanFord {

    public static void main(String[] args) {
        GrapheListe gL = new GrapheListe("grapheExemple/GrapheBoucle.txt");
        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(gL, "A");
//        System.out.println(v);


//        System.out.println( v.calculerChemin("C"));
    }
}

/*
A ->  V:0.0 p:null
B ->  V:9.0 p:C
C ->  V:7.0 p:D
D ->  V:3.0 p:A
E ->  V:38.0 p:F
F ->  V:35.0 p:G
G ->  V:30.0 p:B

A ->  V:0.0 p:null
B ->  V:9.0 p:C
C ->  V:7.0 p:D
D ->  V:3.0 p:A
E ->  V:27.0 p:F
F ->  V:24.0 p:G
G ->  V:19.0 p:B

A ->  V:0.0 p:null
B ->  V:9.0 p:C
C ->  V:7.0 p:D
D ->  V:3.0 p:A
E ->  V:27.0 p:F
F ->  V:24.0 p:G
G ->  V:19.0 p:B


 */
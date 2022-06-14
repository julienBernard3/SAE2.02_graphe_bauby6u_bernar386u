public class MainDijkstra {

    public static void main(String[] args) {
        GrapheListe gL = new GrapheListe("graphe/GrapheBoucle.txt");
        Dijkstra dJ = new Dijkstra();
        Valeur v2 = dJ.resoudre(gL, "A");
//        System.out.println(v2);
    }
}

/*
A ->  V:0.0 p:null
B ->  V:20.0 p:A
C ->  V:Infinity p:null
D ->  V:Infinity p:null
E ->  V:Infinity p:null
F ->  V:Infinity p:null
G ->  V:Infinity p:null

A ->  V:0.0 p:null
B ->  V:20.0 p:A
C ->  V:Infinity p:null
D ->  V:3.0 p:A
E ->  V:Infinity p:null
F ->  V:Infinity p:null
G ->  V:Infinity p:null

A ->  V:0.0 p:null
B ->  V:20.0 p:A
C ->  V:7.0 p:D
D ->  V:3.0 p:A
E ->  V:Infinity p:null
F ->  V:Infinity p:null
G ->  V:Infinity p:null

A ->  V:0.0 p:null
B ->  V:9.0 p:C
C ->  V:7.0 p:D
D ->  V:3.0 p:A
E ->  V:Infinity p:null
F ->  V:Infinity p:null
G ->  V:Infinity p:null

A ->  V:0.0 p:null
B ->  V:9.0 p:C
C ->  V:7.0 p:D
D ->  V:3.0 p:A
E ->  V:Infinity p:null
F ->  V:Infinity p:null
G ->  V:19.0 p:B

A ->  V:0.0 p:null
B ->  V:9.0 p:C
C ->  V:7.0 p:D
D ->  V:3.0 p:A
E ->  V:Infinity p:null
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
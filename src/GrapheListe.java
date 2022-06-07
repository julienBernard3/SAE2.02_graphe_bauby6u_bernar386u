import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public GrapheListe(){
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    public List<Arc> suivants(String n) {
        if(!ensNom.contains(n)){
            return null;
        }else {
            return(this.ensNoeuds.get(this.ensNom.indexOf(n)).getAdj());
        }
    }

     public void ajouterArc(String depart, String destination, double cout){
         if(!this.ensNom.contains(depart)){
             this.ensNoeuds.add(new Noeud(depart));
             this.ensNom.add(depart);
         }

        if(!this.ensNom.contains(destination)){
            this.ensNoeuds.add(new Noeud(destination));
            this.ensNom.add(destination);
        }
         this.ensNoeuds.get(this.ensNom.indexOf(depart)).ajouterArc(this.ensNoeuds.get(this.ensNom.indexOf(destination)),cout);
     }
}

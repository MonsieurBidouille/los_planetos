package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class System_s {
    private String nom;
    private List<CorpsCeleste> corps = new ArrayList<>();

    public System_s(String nom) {
        this.nom = nom;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<main.CorpsCeleste> getCorps() {
        return corps;
    }

    public void setCorps(List<main.CorpsCeleste> corps) {
        this.corps = corps;
    }
    public void addCorp(CorpsCeleste cc){
        corps.add(cc);
    }
    public CorpsCeleste findById(int id){
        for(CorpsCeleste cc : this.corps){
            if(cc.getId() == id){
                return cc;
            }
        }
        return null;
    }

    public void turnall(int j) throws FileNotFoundException {

        Logmachine l = new Logmachine();

        for (int i = 0; i < j; i++) {
            for (CorpsCeleste p : this.corps) {
                if (p.getClass() == Planet.class) {
                    ((Planet) p).turn();
                }
            }
            for (CorpsCeleste c:this.corps){
                Singleton.getInstance().addjson(c.toJSON());
            }

            Singleton.getInstance().wcycle();

        }
        Singleton.getInstance().printlog();
    }
}

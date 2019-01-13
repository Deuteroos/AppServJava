package Abonne;

import Document.Document;
import java.util.Date;
import TimeWorks.finInterdictionAbo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;

public class Abonne  {
    
    private static final int DUREE_INTERDICTION = 30000;
    private int num;
    private Timer interdiction;
    private Collection<Document> emprunte;
    private boolean autorise;
    
    public Abonne (int num) {
            this.num = num;
            interdiction=null;
            this.emprunte=new ArrayList<Document>();
            interdiction=new Timer();
            autorise=true;
    }


    public int getNum() {
            return this.num;
    }

    public void interdire() {
        //interdiction.cancel();
        interdiction.purge();
        interdiction.schedule(new finInterdictionAbo(this), DUREE_INTERDICTION);
        autorise=false;
    }

    public void autoriser() {
        autorise=true;
    }
    
    public boolean peutEmprunter(){
        return autorise;
    }
    public void emprunter(Document d){
        emprunte.add(d);
    }
    public void rendre(Document d){
        emprunte.remove(d);
    }
    public boolean possede(Document d){
        for(Document doc:emprunte)
            if (doc.equals(d))
                return true;
        return false;
    }
}


package TimeWorks;
import Abonne.Abonne;
import Document.Livre;
import java.util.TimerTask;


public class RetardDoc extends TimerTask {

    public RetardDoc(Abonne abo, Livre Doc) {
        this.abo = abo;
        this.Doc = Doc;
    }
    private Abonne abo;
    private Livre Doc;

    @Override
    public void run() {
        while (!Doc.estLibre()){
            synchronized(abo){
                abo.interdire();
            }
        }
    }
}

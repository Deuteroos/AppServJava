package TimeWorks;
import java.util.TimerTask;
import Document.Livre;
 
public class Resa extends TimerTask {
    private Livre doc;

    public Resa(Livre doc){
        this.doc=doc;
    }

    @Override
    public void run() {
        synchronized(doc){
            doc.annulerReservation();;
        }
    }
}
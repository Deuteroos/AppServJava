/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeWorks;

import Abonne.Abonne;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Cyril
 */
public class finInterdictionAbo extends TimerTask {
    private Abonne Abo;
    
    public finInterdictionAbo(Abonne Abo) {
        this.Abo=Abo;
    }

    @Override
    public void run() {
        synchronized(Abo){
            this.Abo.autoriser();
        }
    }
    
}


package p2flammiaramos;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AI extends Thread {
    public Semaphore mutex; 
    public Personaje pZE;
    public Personaje pSF;
    
    public AI() {
        this.mutex = Main.mutex;
        
    }
    
    public void trying(){ 
        System.out.println("jejej");
    }
    
    @Override
    public void run(){
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true){
            try { 
                this.mutex.acquire();
                
                
                System.out.println("\nAI -- Selected:   " + pZE.id + "  y  " + pSF.id);
                this.mutex.release();
                sleep(1000);
                
            }catch (InterruptedException ex) {      
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

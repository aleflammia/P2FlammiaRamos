
package p2flammiaramos;

import static java.lang.Math.abs;
import static java.lang.Thread.sleep;
import java.util.Random;
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
    
    public int resultado(){
        // 1 para Winner
        // 2 para Empate
        // 3 para Refuerzo

        int probsResultado = random();
        if (probsResultado <= 40){
            return 1;
        } else if (probsResultado>40 && probsResultado<=67){
            return 2;
        } else {
            return 3;
        }
    }
    
    public Personaje ganador(Personaje ZE, Personaje SF){
        
        if ( ZE.qAmount == SF.qAmount ){
            if (random()<50){
                return ZE;
            }
            return SF;
        }
        
        Personaje higherQ;
        Personaje lowerQ;
        if (ZE.qAmount>SF.qAmount){
            higherQ = ZE;
            lowerQ = SF;
        }else{
            higherQ = SF;
            lowerQ = ZE;
        }
        
        int diferencia = abs(ZE.qAmount-SF.qAmount);
        
        if (diferencia > 0 && diferencia <=2){
            if (random()<=60){
                return higherQ; 
            } else {
                return lowerQ;
            }
        } else if (diferencia > 2 && diferencia <=6 ){
            if (random()<=70){
                return higherQ; 
            } else {
                return lowerQ;
            }
        }else if (diferencia > 6 && diferencia <=10 ){
            if (random()<=80){
                return higherQ; 
            } else {
                return lowerQ;
            }
        } else { 
            if (random()<=90){
                return higherQ; 
            } else {
                return lowerQ;
            }
        }
    }
    
    public int random(){
        Random random = new Random();
        int randomInt = random.nextInt(100);
        return randomInt;
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
                sleep(2000);
                
            }catch (InterruptedException ex) {      
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

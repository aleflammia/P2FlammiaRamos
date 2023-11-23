
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
    public Admin admin;
    public int winsZE;
    public int winsSF;
    
    public AI() {
        this.mutex = Main.mutex;
        this.admin = Main.admin;
        this.winsZE = 0;
        this.winsSF = 0;
        
    }

    
    public int resultado(){
        // 1 para Winner
        // 2 para Empate
        // 3 para Refuerzo

        //return 1; 
        
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
                
                
                System.out.println("\n Ronda: " + Integer.toString(this.admin.roundsN) + "\nAI -- Selected:   " + pZE.id + "  y  " + pSF.id);
                
                int resultado = resultado();
                String resultadoStr;
                sleep(Main.duration);
                Main.interfaz.state("");
                switch (resultado) {
                    case 1:
                        resultadoStr = "Ganador: ";
                        Main.interfaz.printResultado(resultadoStr);
                        Personaje winner = ganador(pZE, pSF);
                        if (winner==pZE){
                            this.winsZE++;
                            Main.interfaz.updateWins(true, Integer.toString(this.winsZE));
                        }else{
                            this.winsSF++;
                            Main.interfaz.updateWins(false, Integer.toString(this.winsSF));
                        }
                        System.out.println("\tGanador: " + winner.id); 
                        Main.interfaz.printWinner(winner);
                        break;
                    case 2:
                        resultadoStr = "Empate";
                        Main.interfaz.printResultado(resultadoStr);
                        System.out.println("Empate ");
                        pZE.level = pSF.level = 1;
                        admin.queuePersonaje(pZE, admin.qZE1, admin.qZE2, admin.qZE3);
                        admin.queuePersonaje(pSF, admin.qSF1, admin.qSF2, admin.qSF3);
                        break;
                    
                    case 3: 
                        resultadoStr = "Suspendida";
                        Main.interfaz.printResultado(resultadoStr);
                        System.out.println("Refuerzo ");
                        admin.sendRefuerzo(pZE, admin.qZE4);
                        admin.sendRefuerzo(pSF, admin.qSF4);
                        break;
                }
                Main.interfaz.updateQueues(admin.qZE1,admin.qZE2,admin.qZE3,admin.qZE4,admin.qSF1,admin.qSF2,admin.qSF3,admin.qSF4);
                sleep(Main.duration/2);
                Main.interfaz.cleanFields();
                this.mutex.release();
                sleep(1000);
                
                
            }catch (InterruptedException ex) {      
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

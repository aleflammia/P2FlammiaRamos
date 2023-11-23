/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2flammiaramos;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Admin extends Thread {
    public final Random r = new Random();
    public int nNintendo;
    public int nCapcom;
    
    public Queue qZE1;
    public Queue qZE2;
    public Queue qZE3;
    public Queue qZE4;
    
    public Queue qSF1;
    public Queue qSF2;
    public Queue qSF3;
    public Queue qSF4;
    
    public int roundsN;
    
    public Semaphore mutex; 
    public AI ai; 
    
    public Admin(){
        this.mutex = Main.mutex;
        
        this.nNintendo = 0;
        this.nCapcom = 0;
        
        this.qSF1 = new Queue();
        this.qSF2 = new Queue();
        this.qSF3 = new Queue();
        this.qSF4 = new Queue();
        
        this.qZE1 = new Queue();
        this.qZE2 = new Queue();
        this.qZE3 = new Queue();
        this.qZE4 = new Queue();
        
        this.roundsN = 0;
 
    }
    
    public void probsNewPersonaje(String company){
        int result = r.nextInt(100);
        if (result<=80){
                this.newPersonaje(company);
            
        }
    }
    
    public void newPersonaje(String company){
        if (company.equals("Nintendo")){
            this.nNintendo++;
            Personaje newPersonaje = new Personaje(company, nNintendo);
            this.queuePersonaje(newPersonaje, this.qZE1,this.qZE2,this.qZE3);
            
            printPersonaje(newPersonaje);
            
        }else{
            this.nCapcom++;
            Personaje newPersonaje = new Personaje(company, nCapcom);
            this.queuePersonaje(newPersonaje, this.qSF1, this.qSF2, this.qSF3);
            printPersonaje(newPersonaje);
        }
        Main.interfaz.updateQueues(this.qZE1,this.qZE2,this.qZE3,this.qZE4, this.qSF1, this.qSF2, this.qSF3, this.qSF4);   
        
    }

    public void queuePersonaje(Personaje p, Queue q1, Queue q2, Queue q3){
        switch (p.level) {
            case 1:
                q1.enqueue(p);
                break;
            case 2:
                q2.enqueue(p);
                break;
            case 3:
                q3.enqueue(p);
                break;
            default:
                break;
        }
    } 
    
    public void sendRefuerzo(Personaje p, Queue q){
        q.enqueue(p);
    }
    
    public void exe(){
        for (int i = 0; i < 10; i++) {
            this.newPersonaje("Nintendo");
            this.newPersonaje("Capcom");
        }
        this.ai = Main.ai;
        try {
            this.mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.start();
        ai.start();
    }
    
    public void printPersonaje(Personaje equis){
        System.out.println("\nADDED: " + equis.id + " //Habilidades:  " + equis.skills + " //Vida:  " + equis.stamina + " //Fuerza:  " + equis.strength + " //Agilidad:  " + equis.agility + " //LEVEL: "+ equis.level);
        
    }
    
    private Personaje getFromQ(Queue q1, Queue q2, Queue q3){
        if (!q1.isEmpty()){
            Personaje selectedP = q1.getHead();
            q1.dequeue();
            return selectedP;
        } else if (!q2.isEmpty()){
            Personaje selectedP = q2.getHead();
            q2.dequeue();
            return selectedP;
        } else if (!q3.isEmpty()){
            Personaje selectedP = q3.getHead();
            q3.dequeue();
            return selectedP;
        }
        return null;
    }
    
    private void counterUpdates(Queue q){
        Personaje aux = q.getHead();
        while (aux!=null){
            aux.roundsCounter++;
            aux = aux.getNext();
        }
    }
    
    private void priorityCheck(Queue q1, Queue q2, Queue q3){
        Personaje head = q2.getHead();
        while (head != null && head.roundsCounter == 8){
            q2.dequeue();
            head.setNext(null);
            head.level--;
            head.roundsCounter = 0;
            this.queuePersonaje(head, q1, q2, q3);
            head = q2.getHead();
        }
        
        head = q3.getHead();
        while (head != null && head.roundsCounter == 8){
            q3.dequeue();
            head.setNext(null);
            head.level--;
            head.roundsCounter = 0;
            this.queuePersonaje(head, q1, q2, q3);
            head = q3.getHead();
        }
    }
    
    private void probsSacarRefuerzo(Queue refuerzo, Queue q1){
        int result = r.nextInt(100);
        if (result<=40 && !refuerzo.isEmpty()){
            Personaje p = refuerzo.getHead();
            refuerzo.dequeue();
            p.setNext(null);
            q1.enqueue(p);
            Main.interfaz.updateQueues(qZE1,this.qZE2,this.qZE3,this.qZE4,this.qSF1,this.qSF2,this.qSF3,this.qSF4); 
        }
     
    }
    
    @Override
    public void run(){
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true){
            try {
                
                this.probsSacarRefuerzo(qZE4, qZE1);
                this.probsSacarRefuerzo(qSF4, qSF1);
                
                Main.interfaz.state("seleccionando personaje");
                
                sleep(2000);
                if (this.roundsN != 0 &&  roundsN%2 == 0){
                    this.probsNewPersonaje("Nintendo");
                    this.probsNewPersonaje("Capcom");
                    
                }
                
                Personaje pZE = this.getFromQ(this.qZE1,this.qZE2,this.qZE3);
                pZE.setNext(null);
                Personaje pSF = this.getFromQ(this.qSF1,this.qSF2,this.qSF3);
                pSF.setNext(null);
                ai.pZE = pZE;
                ai.pSF = pSF;
                Main.interfaz.updateSelected(pZE, pSF); 
                
                Main.interfaz.state("simulando combate");
                
                Main.interfaz.updateQueues(qZE1,this.qZE2,this.qZE3,this.qZE4,this.qSF1,this.qSF2,this.qSF3,this.qSF4);       
                //System.out.println("\n-- Admin running");
            
                this.mutex.release();
                sleep(1000);
                this.mutex.acquire();
 
                
                counterUpdates(this.qZE1);
                counterUpdates(this.qZE2);
                counterUpdates(this.qZE3);
                counterUpdates(this.qSF1);
                counterUpdates(this.qSF2);
                counterUpdates(this.qSF3);
                
                priorityCheck(this.qZE1,this.qZE2,this.qZE3);
                priorityCheck(this.qSF1,this.qSF2,this.qSF3);
                
                this.roundsN++;
                
                Main.interfaz.updateQueues(this.qZE1,this.qZE2,this.qZE3,this.qZE4,this.qSF1,this.qSF2,this.qSF3,this.qSF4);
                
                
            } catch (InterruptedException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}

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
            this.queuePersonaje(newPersonaje, qZE1, qZE2, qZE3);
            
            printPersonaje(newPersonaje);
            
        }else{
            this.nCapcom++;
            Personaje newPersonaje = new Personaje(company, nCapcom);
            this.queuePersonaje(newPersonaje, qSF1, qSF2, qSF3);
            printPersonaje(newPersonaje);
        }
        
    }
    
    private void queuePersonaje(Personaje p, Queue q1, Queue q2, Queue q3){
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
            head.level++;
            head.roundsCounter = 0;
            this.queuePersonaje(head, q1, q2, q3);
            head = q2.getHead();
        }
        
        head = q3.getHead();
        while (head != null && head.roundsCounter == 8){
            q3.dequeue();
            head.level++;
            head.roundsCounter = 0;
            this.queuePersonaje(head, q1, q2, q3);
            head = q3.getHead();
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

                if (this.roundsN != 0 &&  roundsN%2 == 0){
                    this.probsNewPersonaje("Nintendo");
                    this.probsNewPersonaje("Capcom");
                    this.roundsN = 0;
                }
 
                
                Personaje pZE = this.getFromQ(qZE1, qZE2, qZE3);
                Personaje pSF = this.getFromQ(qSF1, qSF2, qSF3);
                ai.pZE = pZE;
                ai.pSF = pSF;
                        
                //System.out.println("\n-- Admin running");
            
                this.mutex.release();
                sleep(1000);
                this.mutex.acquire();
 
                
                counterUpdates(qZE1);
                counterUpdates(qZE2);
                counterUpdates(qZE3);
                counterUpdates(qSF1);
                counterUpdates(qSF2);
                counterUpdates(qSF3);
                
                priorityCheck(qZE1, qZE2, qZE3);
                priorityCheck(qSF1, qSF2, qSF3);
                
                this.roundsN++;
                
            } catch (InterruptedException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
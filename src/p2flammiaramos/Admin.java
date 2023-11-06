/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2flammiaramos;

import java.util.Random;


public class Admin extends Thread {
    public final Random r = new Random();
    public int nNintendo;
    public int nCapcom;
    
    public Admin(){
        this.nNintendo = 0;
        this.nCapcom = 0;
        
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
            printPersonaje(newPersonaje);
        }else{
            this.nCapcom++;
            Personaje newPersonaje = new Personaje(company, nCapcom);
            printPersonaje(newPersonaje);
        }
        
    }
    
    public void start(){
        for (int i = 0; i < 10; i++) {
            this.newPersonaje("Nintendo");
            this.newPersonaje("Capcom");
        }
    }
    
    public void printPersonaje(Personaje equis){
        System.out.println("");
        System.out.println(equis.id);
        System.out.println("Habilidades:  " + equis.skills);
        System.out.println("Vida:  " + equis.stamina);
        System.out.println("Fuerza:  " + equis.strength);
        System.out.println("Agilidad:  " + equis.agility);
        System.out.println("LEVEL: "+ equis.level);
    }
}

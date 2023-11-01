
package p2flammiaramos;
import java.util.Random;

public class Personaje {
    public String id; 
    public int qAmount;
    public int level; 
    public boolean skills, stamina, strength, agility;
    public String company; 
    
    private Personaje next; 
    public int counter; 
    
    public Personaje(String company, int counter){
        this.skills = (defineQuality(60));
        this.stamina = (defineQuality(70));
        this.strength = (defineQuality(50));
        this.agility = (defineQuality(40));
        
        this.company = company;
        this.qAmount = 0; 
        this.counter = 0; 
        
        this.id = defineId(company, counter);
        
        this.level = defineLevel(skills, stamina, strength, agility);
        
    }
    
    public boolean defineQuality(int percentage){
        Random r = new Random(); 
        int rInt = r.nextInt(100);
        return (rInt < percentage);
    }
    
    public int defineLevel(boolean skills, boolean stamina, boolean strength, boolean agility){
        
        if (skills){qAmount+=2;}
        if (stamina){qAmount++;}
        if (strength){qAmount+=3;}
        if (agility){qAmount+=4;}
        
        if (qAmount >= 8){return 1;}
        if (qAmount >= 4 && qAmount <= 7){return 2;}
        return 3;
    }
    
    public String defineId(String company, int counter){
        String id;
        if(company.equals("Nintendo")){
            id = "ZE";
        }else{
            id = "SF";
        }
        
        String num = Integer.toString(counter+1);
        if (num.length()==1){num=("0"+num);}
        id += num;
        return id;
    }
    
    public Personaje getNext(){
        return next;
    }
    
    public void setNext(Personaje next){
        this.next = next;
    }
}
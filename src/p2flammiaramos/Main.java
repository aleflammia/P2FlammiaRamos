
package p2flammiaramos;

import java.util.concurrent.Semaphore;

public class Main {

    public static Semaphore mutex = new Semaphore(1);
    public static Interfaz interfaz = new Interfaz();
    public static Admin admin = new Admin();
    public static AI ai = new AI();

    public static void main(String[] args) {
        admin.exe();
        interfaz.setVisible(true);
    }
    
}

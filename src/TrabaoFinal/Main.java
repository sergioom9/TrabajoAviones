package TrabaoFinal;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        texto PRUEBA=new texto();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Thread v1= new Thread(new Ventana());
                v1.start();

            }
        });


    }
}
import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
      
        //**TESTS DE ROBIN**
        
        //Tests de l'hologe concrète
        /*Chronometer chrono = new Chronometer(0);
        chrono.start();
        try
        {
            Thread.sleep(2000);
        }
        catch(java.lang.InterruptedException e)
        {
            System.out.println("Error in sleep()");
        }
        chrono.stop();
        System.out.println(chrono.getTimeInSeconds());*/

        //Test du controlleur
        ClockController controller = new ClockController();


        //**TESTS DE CLAIRE**

        //Test de l'affichage clock
        /*{
            JFrame frame = new JFrame("Analog");
            Panel panel = new AnalogViewer(false);
            frame.getContentPane().add(panel);
            frame.setSize(500, 500);
            frame.setVisible(true);
            frame.repaint();
        }
        //Test de l'affichage clock
        {
            JFrame frame = new JFrame("Roman");
            Panel panel = new AnalogViewer(true);
            frame.getContentPane().add(panel);
            frame.setSize(500, 500);
            frame.setVisible(true);
            frame.repaint();
        }

        new MixedViewer();        */

    }
}

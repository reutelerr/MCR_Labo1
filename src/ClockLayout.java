import java.awt.*;
import javax.swing.*;


public class ClockLayout {
    ClockLayout() {
        JFrame frame = new JFrame("Flow Layout");
        Panel romanPanel = getClockPanel(true);
        Panel arabPanel = getClockPanel(false);
        JLabel digital = new JLabel("hh:mm:ss");
        //frame.setLayout(new FlowLayout());
        frame.getContentPane().add(romanPanel);
        frame.getContentPane().add(arabPanel);
        frame.getContentPane().add(digital);
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.repaint();
    }


    public static Panel getClockPanel(boolean romanClock){  //TODO sert à rien méthode séparée
        Panel panel = new ClockImage(romanClock);
        return panel;
    }
}

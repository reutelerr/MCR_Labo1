import java.awt.*;
import javax.swing.*;


public class ClockLayout extends Panel {
    ClockLayout(Clock clock) {
        JFrame frame = new JFrame("Flow Layout");
        Panel romanPanel = getClockPanel(true, clock);
        Panel arabPanel = getClockPanel(false, clock);
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


    public static Panel getClockPanel(boolean romanClock, Clock clock){  //TODO sert à rien méthode séparée
        Panel panel = new AnalogObserver(romanClock, clock);
        return panel;
    }
}

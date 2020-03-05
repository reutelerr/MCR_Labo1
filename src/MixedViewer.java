import java.awt.*;
import javax.swing.*;




public class MixedViewer extends Panel {
    MixedViewer(Chronometer clock) {
        JFrame frame = new JFrame("Flow Layout");
        Panel romanPanel = getClockPanel(true, clock);
        Panel arabPanel = getClockPanel(false, clock);
        Panel digital = new DigitalViewer(clock);
        //JLabel digital = new JLabel("hh:mm:ss");
        //frame.setLayout(new FlowLayout());
        frame.getContentPane().add(romanPanel);
        frame.getContentPane().add(arabPanel);
        frame.getContentPane().add(digital);
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.repaint();
    }


    public static Panel getClockPanel(boolean romanClock, Chronometer clock){  //TODO sert à rien méthode séparée
        Panel panel = new AnalogViewer(romanClock, clock);
        return panel;
    }
}

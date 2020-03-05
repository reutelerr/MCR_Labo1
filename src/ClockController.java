import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class ClockController implements ClockViewer
{
    private Chronometer clock;
    private JButton romanButton, arabButton, numericButton, mixedButton, startButton, stopButton, resetButton, quitButton;

    ClockController(){
        clock = new Chronometer(0);//On pourrait passer un argument au constructeur pour préciser quel type d'horloge utiliser ?

        JFrame frame = new JFrame("Flow Layout");

        romanButton = new JButton("Horloge Romaine");
        arabButton = new JButton("Horloge Arabe");
        numericButton = new JButton("Horloge Numérique");
        mixedButton = new JButton("Horloge Mixte");
        startButton = new JButton("Démarrer");
        stopButton = new JButton("Arrêter");
        resetButton = new JButton("Réinitialiser");
        quitButton = new JButton("Quitter");
        frame.add(romanButton);
        frame.add(arabButton);
        frame.add(numericButton);
        frame.add(mixedButton);
        frame.add(startButton);
        frame.add(stopButton);
        frame.add(resetButton);
        frame.add(quitButton);
        frame.setLayout(new FlowLayout());
        frame.setSize(300,300);
        frame.setVisible(true);
        romanButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { createAnalogViewer(true); }
        });
        arabButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { createAnalogViewer(false); }
        });
        numericButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                createNumericClockViewer();
            }
        });
        mixedButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                createMixedClockViewer();
            }
        });
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { clock.start(); }
        });
        stopButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                clock.stop();
            }
        });
        resetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                clock.reset();
            }
        });
        quitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createNumericClockViewer()
    {
        JFrame frame = new JFrame("Horloge Numérique");
        Panel panel = new DigitalViewer(clock);
        frame.getContentPane().add(panel);
        frame.setSize(500, 200);
        frame.setVisible(true);
        frame.repaint();
    }


    private void createMixedClockViewer()
    {

    }

    private void createAnalogViewer(boolean romanClock){

        JFrame frame;
        if(romanClock)
        {
            frame = new JFrame("Horloge Romaine");
        }
        else
        {
            frame = new JFrame("Horloge Arabe");
        }

        Panel panel = new AnalogObserver(romanClock, clock);
        frame.getContentPane().add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.repaint();
    }

    public void update()
    {}

}
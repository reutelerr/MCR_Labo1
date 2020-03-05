/*
 * Laboratoire : 01
 * Fichier     : ClockController.java
 * Auteur(s)   : Delhomme Claire, Reuteler Robin
 * Date        : 05.03.2020
 *
 * But         : Contrôle du chronomètre et de ses vues
 */

import java.awt.event.*;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;


public class ClockController implements ClockViewer
{
    private final static int CLOCK_PANEL_SIDE = 500;
    private final static int CLOCK_DIGITAL_HEIGHT = 200;
    private final static int CONTROLLER_SIDE = 300;

    private Chronometer clock;

    ClockController(){
        clock = new Chronometer(0);
        JFrame frame = new JFrame("Notre super chronomètre");

        JButton romanButton, arabButton, numericButton, mixedButton, startButton, stopButton, resetButton, quitButton;
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
        frame.setSize(CONTROLLER_SIDE,CONTROLLER_SIDE);
        frame.setVisible(true);
        romanButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                CreateRomanClockViewer();
            }
        });
        arabButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                CreateArabClockViewer();
            }
        });
        numericButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                CreateNumericClockViewer();
            }
        });
        mixedButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                CreateMixedClockViewer();
            }
        });
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                clock.start();
            }
        });
        stopButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                clock.stop();
            }
        });
        resetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                clock.reset();
                clock.notifyObservers();    //rafraîchit la vue
            }
        });
        quitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void CreateRomanClockViewer()
    {
        createAnalogViewer(true);
    }

    public void CreateArabClockViewer()
    {
        createAnalogViewer(false);
    }

    public void CreateNumericClockViewer()
    {
        JFrame frame = new JFrame("Horloge Numérique");
        Panel panel = new DigitalViewer(clock);
        frame.getContentPane().add(panel);
        frame.setSize(CLOCK_PANEL_SIDE, CLOCK_DIGITAL_HEIGHT);
        frame.setVisible(true);
        frame.repaint();
    }


    public void CreateMixedClockViewer()
    {
        JFrame frame = new JFrame("Horloge mixte");
        Panel romanPanel = new AnalogViewer(true, clock);
        Panel arabPanel = new AnalogViewer(false, clock);
        Panel digital = new DigitalViewer(clock);
        frame.getContentPane().add(romanPanel);
        frame.getContentPane().add(arabPanel);
        frame.getContentPane().add(digital);
        frame.setLayout(new FlowLayout());
        frame.setSize(3* CLOCK_PANEL_SIDE, CLOCK_PANEL_SIDE);
        frame.setVisible(true);
        frame.repaint();
    }

    private void createAnalogViewer(boolean romanClock){
        JFrame frame = romanClock ? new JFrame("Horloge Romaine") : new JFrame("Horloge Arabe");
        Panel panel = new AnalogViewer(romanClock, clock);
        frame.getContentPane().add(panel);
        frame.setSize(CLOCK_PANEL_SIDE, CLOCK_PANEL_SIDE);
        frame.setVisible(true);
        frame.repaint();
    }

    public void update()
    {}

}
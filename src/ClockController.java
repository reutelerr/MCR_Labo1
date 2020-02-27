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
        //Panel panel = new ClockImage(false);
    }

    public void CreateArabClockViewer()
    {
        //Panel panel = new ClockImage(false);
    }

    public void CreateNumericClockViewer()
    {

    }

    public void CreateMixedClockViewer()
    {

    }

    public void update()
    {}

}
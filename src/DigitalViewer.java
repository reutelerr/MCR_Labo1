/*
 * Laboratoire : 01
 * Fichier     : DigitalViewer.java
 * Auteur(s)   : Delhomme Claire, Reuteler Robin
 * Date        : 05.03.2020
 *
 * But         : Vue digitale de l'horloge
 */

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class DigitalViewer extends Panel implements ClockViewer{
    private Clock myClock;
    private JLabel digitalTime;

    public DigitalViewer(Clock subject) {
            myClock = subject;
            subject.attach(this);

            digitalTime = new JLabel();
            this.add(digitalTime);
            update();
    }

    public void update()
    {
        int time = myClock.getTimeInSeconds();
        //int time = 30 + 60*15 + 60*60*19;
        int seconds = time%60;
        int minutes = (time/60)%60;
        int hours = (time/(60*60))%12;  //TODO check div

        DecimalFormat df = new DecimalFormat("##");

        String hoursText = df.format(hours)+"h ";
        String minutesText = df.format(minutes)+"m ";
        String secondsText = df.format(seconds)+"s";

        digitalTime.setText(hoursText+minutesText+secondsText);
    }

    public void repaint()
    {
        update();
    }
}

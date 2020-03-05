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
    private Chronometer chrono;
    private JLabel digitalTime;

    /**
     * @brief   Constructor
     * @param subject   the observed chronometer
     */
    public DigitalViewer(Chronometer subject) {
            chrono = subject;
            subject.attach(this);

            digitalTime = new JLabel();
            this.add(digitalTime);
            update();
    }

    @Override
    public void update()
    {
        int time = chrono.getTimeInSeconds();
        int seconds = time%CLOCK_CONTAINS_MINUTE_SECOND;
        int minutes = (time/CLOCK_CONTAINS_MINUTE_SECOND)%CLOCK_CONTAINS_MINUTE_SECOND;
        int hours = (time/(CLOCK_CONTAINS_MINUTE_SECOND*CLOCK_CONTAINS_MINUTE_SECOND))%DAY_CONTAINS_HOUR;

        DecimalFormat df = new DecimalFormat("##");

        String hoursText = df.format(hours)+"h ";
        String minutesText = df.format(minutes)+"m ";
        String secondsText = df.format(seconds)+"s";

        digitalTime.setText(hoursText+minutesText+secondsText);
    }

    @Override
    public void repaint()
    {
        update();
    }
}

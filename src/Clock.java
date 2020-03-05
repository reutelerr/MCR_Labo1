/*
 * Laboratoire : 01
 * Fichier     : Clock.java
 * Auteur(s)   : Delhomme Claire, Reuteler Robin
 * Date        : 05.03.2020
 *
 * But         : Horloge (sujet abstrait)
 */

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Clock
{
    private java.util.ArrayList<ClockViewer> observers;

    /**
     * @brief : Constructor : Creates an empty list of observers
     */
    Clock()
    {
        observers = new ArrayList<ClockViewer>();
    }

    /**
     * @brief Tells all current observers to update
     */
    public void notifyObservers()
    {
        for(ClockViewer observer : observers)
        {
            observer.update();
        }
    }

    /**
     * @brief Adds an observer to the clock
     * @param v a Clock observer
     */
    public void attach(ClockViewer v)
    {
        observers.add(v);
    }

    /**
     * @brief Removes an observer from the clock
     * @param v a Clock observer
     */
    public void detach(ClockViewer v)
    {
        observers.remove(v);
    }

    public abstract int getTimeInSeconds();
}
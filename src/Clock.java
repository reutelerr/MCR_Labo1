public abstract class Clock
{
    private java.util.ArrayList<ClockViewer> observers;

    public void notifyObservers()
    {

    }

    public void attach(ClockViewer v)
    {

    }

    public void detach(ClockViewer v)
    {

    }

}

class Chronometer extends Clock
{
    private java.util.Timer timer;

    
}

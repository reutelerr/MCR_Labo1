import java.util.Timer;
import java.util.TimerTask;

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
    private Timer timer;
    private int time_in_seconds;

    Chronometer(int startTime)
    {
        timer = new Timer();
    }

    void reInit()
    {
        time_in_seconds = 0;
    }

    void stop()
    {
        timer.cancel();
    }

    void start()
    {
        class Tick extends TimerTask
        {
            public void run()
            {
                time_in_seconds++;
                notifyObservers();
            }
        }
        Tick tick = new Tick();
        timer.scheduleAtFixedRate(tick, 0, 1000);
    }

    int getTimeInSeconds()
    {
        return time_in_seconds;
    }
}

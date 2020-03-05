import java.util.Timer;
import java.util.TimerTask;

class Chronometer extends Clock
{
    private Timer timer;
    private int time_in_seconds;
    private boolean isRunning;

    /**
     * @brief Constructor : creates a Timer and sets the starting time-value of the clock
     * @param startTime the initial clock's time
     */
    Chronometer(int startTime)
    {
        super();
        time_in_seconds = startTime;
        isRunning = false;
    }

    /**
     * @brief Resets the time to 0
     */
    void reset()
    {
        time_in_seconds = 0;
        notifyObservers();
    }

    /**
     * @brief Pauses the clock
     */
    void stop()
    {
        timer.cancel();
        isRunning = false;
    }

    /**
     * @brief Runs the clock
     */
    void start() {
        class Tick extends TimerTask {
            public void run() {
                time_in_seconds++;
                notifyObservers();
            }
        }
        Tick tick = new Tick();
        timer = new Timer();
        timer.scheduleAtFixedRate(tick, 0, 1000);
        isRunning = true;
    }

    /**
     * @brief gets the clock's time
     * @return the clock's time
     */
    public int getTimeInSeconds()
    {
        return time_in_seconds;
    }

    /**
     * @brief checks if the chronometer is running
     * @return true if the chrono is running
     */
    public boolean isRunning()
    {
        return isRunning;
    }
}

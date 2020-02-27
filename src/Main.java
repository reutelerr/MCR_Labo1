public class Main {

    public static void main(String[] args) {
        //Tests de l'hologe concrète
        Chronometer chrono = new Chronometer(0);
        chrono.start();
        try
        {
            Thread.sleep(2000);
        }
        catch(java.lang.InterruptedException e)
        {
            System.out.println("Error in sleep()");
        }
        chrono.stop();
        System.out.println(chrono.getTimeInSeconds());

        //Test du controlleur
        ClockController controller = new ClockController();
    }
}

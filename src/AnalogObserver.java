import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;



public class AnalogObserver extends Panel implements ClockViewer{
    private static final int CLOCK_SIDE = 300;
    private static final int CLOCK_HALFSIDE = CLOCK_SIDE/2;

    private static final int CLOCK_CONTAINS_MINUTE_SECOND = 60;
    private static final int CLOCK_CONTAINS_HOUR = 12;
    private static final int CLOCK_ROTATION = 360;
    private static final int CLOCK_MINUTE_SECOND_DIV = CLOCK_ROTATION/CLOCK_CONTAINS_MINUTE_SECOND;
    private static final int CLOCK_HOUR_DIV = CLOCK_ROTATION/CLOCK_CONTAINS_HOUR;

    private static final double HOUR_NEEDLE_RATIO = 0.4;
    private static final double MINUTE_NEEDLE_RATIO = 0.6;
    private static final double SECOND_NEEDLE_RATIO = 0.8;


    private Image clockImg;
    private Chronometer chrono;//TODO suppr chrono?

    /**
     *
     * @param romanClock false pour horloge arabe, true pour horloge romaine
     */
    public AnalogObserver(boolean romanClock, Chronometer subject) {
        try {
            String clockFilename = romanClock ? "/Users/robinreuteler/IdeaProjects/MCR_Labo1/clock2.jpg" : "/Users/robinreuteler/IdeaProjects/MCR_Labo1/clock1.jpg";
            Image myImg = Toolkit.getDefaultToolkit().getImage(clockFilename);
            clockImg = myImg.getScaledInstance(CLOCK_SIDE, CLOCK_SIDE, Image.SCALE_DEFAULT);

            chrono = subject;
            subject.attach(this);

            this.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e)
                {
                    if(chrono.isRunning())
                    {
                        chrono.stop();
                    }
                    else
                    {
                        chrono.start();
                    }
                }
            });

            update();
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }


    public void paint(Graphics g) {
        g.drawImage(clockImg, 0, 0, null);
        paintNeedles(g);
    }


    //Important pour flow layout
    @Override
    public Dimension getPreferredSize() {
        Dimension d = getParent().getSize();
        int side = Math.min((int) d.getWidth(), (int) d.getHeight());
        return new Dimension(side, side);
    }

    @Override
    public void update() {
        this.repaint();
    }

    private void paintNeedles(Graphics g){
      
        int time = chrono.getTimeInSeconds();
        int seconds = time%CLOCK_CONTAINS_MINUTE_SECOND;
        int minutes = (time/CLOCK_CONTAINS_MINUTE_SECOND)%CLOCK_CONTAINS_MINUTE_SECOND;
        int hours = (time/(CLOCK_CONTAINS_MINUTE_SECOND*CLOCK_CONTAINS_MINUTE_SECOND))%CLOCK_CONTAINS_HOUR;

        paintANeedle(g, seconds, SECOND_NEEDLE_RATIO, CLOCK_MINUTE_SECOND_DIV, Color.RED);
        paintANeedle(g, minutes, MINUTE_NEEDLE_RATIO, CLOCK_MINUTE_SECOND_DIV, Color.BLUE);
        paintANeedle(g, hours, HOUR_NEEDLE_RATIO, CLOCK_HOUR_DIV, Color.BLACK);

    }

    private void paintANeedle(Graphics g, int time, double needleRatio, int degree, Color color){
        Graphics2D g2 = (Graphics2D) g;

        double radians = Math.toRadians(degree*time);
        double x = Math.cos(radians - Math.PI/2.0)*CLOCK_HALFSIDE*needleRatio;
        double y = Math.sin(radians - Math.PI/2.0)*CLOCK_HALFSIDE*needleRatio;

        Line2D lin = new Line2D.Float(CLOCK_HALFSIDE, CLOCK_HALFSIDE, (float) (CLOCK_HALFSIDE + x), (float) (CLOCK_HALFSIDE + y));
        g2.setColor(color);
        g2.draw(lin);
    }
}

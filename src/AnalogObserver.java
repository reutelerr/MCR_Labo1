import java.awt.*;
import java.awt.geom.*;



public class AnalogObserver extends Panel implements ClockViewer{
    public static final int CLOCK_SIDE = 300;
    public static final int CLOCK_HALFSIDE = CLOCK_SIDE/2;


    private Image clockImg;
    private Clock myClock;    //TODO suppr chrono?

    /**
     *
     * @param romanClock false pour horloge arabe, true pour horloge romaine
     */
    public AnalogObserver(boolean romanClock, Clock subject) {
        try {
            String clockFilename = romanClock ? "C:\\Users\\Claire\\Desktop\\heig\\2019\\MCR\\Labo\\clock2.jpg" : "C:\\Users\\Claire\\Desktop\\heig\\2019\\MCR\\Labo\\clock1.jpg";
            Image myImg = Toolkit.getDefaultToolkit().getImage(clockFilename);
            clockImg = myImg.getScaledInstance(CLOCK_SIDE, CLOCK_SIDE, Image.SCALE_DEFAULT);

            myClock = subject;
            subject.attach(this);
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }


    public void paint(Graphics g) {
        g.drawImage(clockImg, 0, 0, null);
            //super.paint(g);  // fixes the immediate problem.
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
        int time = myClock.getTimeInSeconds();
        int seconds = time%60;
        int minutes = (time/60)%60;
        int hours = (time/(60*60))%12;  //TODO check div

        paintANeedle(g, seconds, 1);
        paintANeedle(g, minutes, 0.8);
        paintANeedle(g, hours, 0.4);
    }

    private void paintANeedle(Graphics g, int time, double needleRatio){
        Graphics2D g2 = (Graphics2D) g;

        double radians = Math.toRadians((360/60)*time);
        double x = Math.cos(radians - Math.PI/2.0)*CLOCK_HALFSIDE*needleRatio;
        double y = Math.sin(radians - Math.PI/2.0)*CLOCK_HALFSIDE*needleRatio;

        Line2D lin = new Line2D.Float(CLOCK_HALFSIDE, CLOCK_HALFSIDE, (float) (CLOCK_HALFSIDE + x), (float) (CLOCK_HALFSIDE + y));
        g2.draw(lin);
    }
}

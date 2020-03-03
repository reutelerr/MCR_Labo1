import java.awt.*;
import java.awt.geom.*;



public class ClockImage extends Panel {
    public static final int CLOCK_SIDE = 300;
    public static final int CLOCK_HALFSIDE = CLOCK_SIDE/2;


    private Image clockImg;

    /**
     *
     * @param romanClock false pour horloge arabe, true pour horloge romaine
     */
    public ClockImage(boolean romanClock) {
        try {
            String clockFilename = romanClock ? "C:\\Users\\Claire\\Desktop\\heig\\2019\\MCR\\Labo\\clock2.jpg" : "C:\\Users\\Claire\\Desktop\\heig\\2019\\MCR\\Labo\\clock1.jpg";
            Image myImg = Toolkit.getDefaultToolkit().getImage(clockFilename);
            clockImg = myImg.getScaledInstance(CLOCK_SIDE, CLOCK_SIDE, Image.SCALE_DEFAULT);
            //File input = new File("clock1.jpg");
            //BufferedImage image = ImageIO.read(input);
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }


    public void paint(Graphics g) {
        g.drawImage(clockImg, 0, 0, null);
            //super.paint(g);  // fixes the immediate problem.
            Graphics2D g2 = (Graphics2D) g;
            int i = 15;
            double radians = Math.toRadians((360/60)*i);
            double x = Math.cos(radians - Math.PI/2.0)*CLOCK_HALFSIDE;
            double y = Math.sin(radians - Math.PI/2.0)*CLOCK_HALFSIDE;

            Line2D lin = new Line2D.Float(CLOCK_HALFSIDE, CLOCK_HALFSIDE, (float) (CLOCK_HALFSIDE + x), (float) (CLOCK_HALFSIDE + y));
            g2.draw(lin);
    }


    //Important pour flow layout
    @Override
    public Dimension getPreferredSize() {
        Dimension d = getParent().getSize();
        int side = Math.min((int) d.getWidth(), (int) d.getHeight());
        return new Dimension(side, side);
    }
}

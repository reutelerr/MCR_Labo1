import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ClockImage extends Panel {
    private Image clockImg;

    /**
     *
     * @param romanClock false pour horloge arabe, true pour horloge romaine
     */
    public ClockImage(boolean romanClock) {
        try {
            String clockFilename = romanClock ? "C:\\Users\\Claire\\Desktop\\heig\\2019\\MCR\\Labo\\clock2.jpg" : "C:\\Users\\Claire\\Desktop\\heig\\2019\\MCR\\Labo\\clock1.jpg";
            Image myImg = Toolkit.getDefaultToolkit().getImage(clockFilename);
            clockImg = myImg.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
            //File input = new File("clock1.jpg");
            //BufferedImage image = ImageIO.read(input);
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }


    public void paint(Graphics g) {
        g.drawImage(clockImg, 0, 0, null);
    }


}

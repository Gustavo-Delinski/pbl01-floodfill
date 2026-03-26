import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/images/pinguim.png"));
        } catch (IOException e) {
        }



    }
}

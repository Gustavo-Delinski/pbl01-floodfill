import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/image/pinguim.png"));

            int x = 50;
            int y = 50;

            int corOriginal = img.getRGB(x, y);

            int novaCor = new Color(255, 0, 0).getRGB(); // mudar cor aqui

            FloodFill floodFill = new FloodFill();

            floodFill.FloodFillPilha(img, x, y, corOriginal, novaCor);

            ImageIO.write(img, "png", new File("saida.png"));

            System.out.println("Flood Fill concluído.");

        } catch (IOException e) {
            System.out.println("Erro ao carregar a imagem.");

        }
    }
}

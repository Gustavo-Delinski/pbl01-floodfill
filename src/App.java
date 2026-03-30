import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import java.awt.Color;

public class App {
    public void iniciar() {
        BufferedImage img = null;
        BufferedImage img2 = null;
        try {
            img = ImageIO.read(new File("src/image/te1.png"));
            img2 = ImageIO.read(new File("src/image/te1.png"));

            JLabel label1 = criarJanela(img, "Pilha", 0, 0);
            JLabel label2 = criarJanela(img2, "Fila", 1000, 0);

            String inputX = JOptionPane.showInputDialog("Digite X:"); // dentro do puffle é mais ou menos 300
            String inputY = JOptionPane.showInputDialog("Digite Y:"); // dentro do puffle é mais ou menos 300

            if (inputX == null || inputY == null || inputX.isEmpty() || inputY.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Coordenadas não foram inseridas");
                return;
            }

            int x, y;


            try {
                x = Integer.parseInt(inputX);
                y = Integer.parseInt(inputY);

                if (x < 0 || y < 0 || x >= img.getWidth() || y >= img.getHeight()) {
                    JOptionPane.showMessageDialog(null, "Coordenadas fora da imagem");
                    return;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números válidos");
                return;
            }



            int corOriginal = img.getRGB(x, y);

            int novaCor = new Color(41, 186, 24).getRGB(); // mudar cor aqui

            FloodFill floodFill = new FloodFill();

            BufferedImage finalImg = img;
            new Thread(() -> {
                floodFill.FloodFillPilha(finalImg, x, y, corOriginal, novaCor, label1);
            }).start();

            BufferedImage finalImg1 = img2;
            new Thread(() -> {
                floodFill.FloodFillFila(finalImg1, x, y, corOriginal, novaCor, label2);
            }).start();


            System.out.println("Flood Fill concluído.");

        } catch (IOException e) {
            System.out.println("Erro ao carregar a imagem.");

        }
    }

    private JLabel criarJanela(BufferedImage img, String titulo, int posX, int posY) {
        JFrame frame = new JFrame(titulo);
        JLabel label = new JLabel(new ImageIcon(img));

        frame.add(label);
        frame.pack();
        frame.setLocation(posX, posY);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        return label;
    }
}



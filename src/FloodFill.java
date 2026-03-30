import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FloodFill {

    public void FloodFillPilha(BufferedImage img, int x, int y, int corOriginal, int novaCor, JLabel label) {
        Stack<Ponto> stack = new Stack<>(); // vai controlar quais pixels precisam ser controlados
        stack.push(new Ponto(x, y));

        if (corOriginal == novaCor) {
            return;
        }

        int contadorPilha = 0; // vai controlar os frames

        File pasta = new File("frames");
        if (!pasta.exists()) {
            pasta.mkdirs();
        } // cria pasta se nao existir

        while (!stack.isEmpty()) {
            Ponto p = stack.pop();

            if (p.getX() < 0 || p.getY() < 0 || p.getX() >= img.getWidth() || p.getY() >= img.getHeight()) {
                continue;
            } // verifica limites

            if (img.getRGB(p.getX(), p.getY()) != corOriginal) {
                continue;
            } // verifica cor

            img.setRGB(p.getX(), p.getY(), novaCor); // pinta pixel

            try {
                contadorPilha++;
                if (contadorPilha % 50 == 0) {
                    label.setIcon(new ImageIcon(img));
                    label.repaint();

                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ImageIO.write(img, "png", new File("frames/frame_" + contadorPilha + ".png"));
                } // ele vai salvar a cada 50 pixels

            } catch (IOException e) {
                e.printStackTrace();

            }

            // vizinhos
            stack.push(new Ponto(p.getX() + 1, p.getY()));
            stack.push(new Ponto(p.getX() - 1, p.getY()));
            stack.push(new Ponto(p.getX(), p.getY() + 1));
            stack.push(new Ponto(p.getX(), p.getY() - 1));

        }
    }

    public void FloodFillFila(BufferedImage img, int x, int y, int corOriginal, int novaCor, JLabel label) {

        Queue<Ponto> queue = new Queue<>();
        queue.enqueue(new Ponto(x, y));

        if (corOriginal == novaCor) return;

        int contadorFila = 0;

        File pasta = new File("frames");
        if (!pasta.exists()) {
            pasta.mkdirs();
        } // cria pasta se nao existir

        while (!queue.isEmpty()) {

            Ponto p = queue.dequeue();

            if (p.getX() < 0 || p.getY() < 0 || p.getX() >= img.getWidth() || p.getY() >= img.getHeight()) {
                continue;
            }

            if (img.getRGB(p.getX(), p.getY()) != corOriginal) {
                continue;
            }

            img.setRGB(p.getX(), p.getY(), novaCor);

            try {
                contadorFila++;
                if (contadorFila % 50 == 0) {
                    label.setIcon(new ImageIcon(img));
                    label.repaint();
                    try {
                        Thread.sleep(0); //
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ImageIO.write(img, "png", new File("frames/frame_" + contadorFila + ".png"));
                } // ele vai salvar a cada 50 pixels

            } catch (IOException e) {
                e.printStackTrace();

            }

            queue.enqueue(new Ponto(p.getX() + 1, p.getY()));
            queue.enqueue(new Ponto(p.getX() - 1, p.getY()));
            queue.enqueue(new Ponto(p.getX(), p.getY() + 1));
            queue.enqueue(new Ponto(p.getX(), p.getY() - 1));
        }
    }
}

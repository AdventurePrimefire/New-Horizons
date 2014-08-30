package world.grid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GridPanel extends JPanel {
    public GridPanel() {

    }

    @Override
    public void paintComponents(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        drawGridLines(g2);
    }

    private void drawGridLines(Graphics2D g2) {
        File file = new File("Grid_23.gif");
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
            for (int i = 0; i < 10; i++) {// row
                for (int j = 0; j < 10; i++) {// col
                    g2.drawImage(image, i * 32 - 1, j * 32 - 1, null);// 32 is pixle offset
                }
            }
        } catch (IOException e) {
            System.out.println("Oh well...");
            e.printStackTrace();
        }

    }
}

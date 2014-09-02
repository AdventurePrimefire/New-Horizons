package panel.grid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import world.grid.Grid;

public class GridPanel extends JPanel {
    private Grid grid = null;
    
    public GridPanel() {}
    
    public GridPanel(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (g2 == null) {
            return;
        }
        g2.setColor(Color.white);
        g2.fillRect(0, 0, super.getWidth(), super.getHeight());
        this.drawGridLines(g2);
        this.drawGridActors(g2);
    }
    
    private void drawGridActors(Graphics2D g2) {
        
    }

    private void drawGridLines(Graphics2D g2) {
        int gridSize = 48;// 32 or 48 pixels
        File file = new File("resource/setPieces/Grid_" + gridSize + ".gif");
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
            for (int i = 0; i < super.getWidth() - gridSize; i += gridSize) {// row
                for (int j = 0; j < super.getHeight() - gridSize; j += gridSize) {// col
                    g2.drawImage(image, i, j, null);// 32 is pixle offset
                }
            }
        } catch (IOException e) {
            System.out.println("Oh well...");
            e.printStackTrace();
        }
        g2.dispose();
    }
}

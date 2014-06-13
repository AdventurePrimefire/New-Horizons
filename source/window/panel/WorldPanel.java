package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WorldPanel extends JPanel {
    public WorldPanel() {

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        
        Insets insets = getInsets();
        g2.setColor(Color.black);
        g2.fillRect(insets.left, insets.top, numCols * (cellSize + 1) + 1, numRows * (cellSize + 1) + 1);
    }
}

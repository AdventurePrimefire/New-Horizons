package panel.grid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import world.grid.FactoryGrid;
import world.grid.Grid;
import world.grid.Location;
import world.grid.MapLayer;
import devKit.grid.GridDevPanel;
import display.Display;
import display.GlobalDisplay;

public class GridPanel extends JPanel {
    private Grid grid = null;
    private int gridSize = 48; // image pixle size: 32 or 48
    private GridDevPanel dev = null;
    private GridPanelControl gridc = new GridPanelControl(this);

    public GridPanel() {
        this.grid = new FactoryGrid(10, 10);
        this.initUI();
    }

    public GridPanel(Grid grid) {
        this.grid = grid;
        this.initUI();
    }

    private void initUI() {
        addMouseListener(this.gridc);
        this.dev = new GridDevPanel(this);
        this.setFocusable(true);
        this.requestFocus();
    }

    public void addGridPanelListener(GridPanelListener listener) {
        this.gridc.addGridListener(listener);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        this.drawGridLines(g2);
        this.drawGridFloor(g2);
        this.drawGridActors(g2);
    }

    private void drawGridActors(Graphics2D g2) {
        if (this.grid == null) {
            return;
        }
        this.drawLocations(this.grid.getOccupiedLocations(MapLayer.ActorLevel), g2);
    }

    private void drawGridFloor(Graphics2D g2) {
        if (this.grid == null) {
            return;
        }
        this.drawLocations(this.grid.getOccupiedLocations(MapLayer.FloorLevel), g2);
    }

    private void drawLocations(Iterator<Location> locs, Graphics2D g2) {
        while (locs.hasNext()) {
            Location loc = locs.next();
            Display img = GlobalDisplay.getDisplay(this.grid.cheekLocation(loc));
            g2.drawImage(img.getImage(), loc.getRow() * this.gridSize, loc.getCol() * this.gridSize, null);
        }
    }

    private void drawGridLines(Graphics2D g2) {
        File file = new File("resource/setPieces/Grid_" + gridSize + ".gif");
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
            for (int i = 0; i < this.grid.getRows() && i * this.gridSize < super.getWidth(); i++) {// row
                for (int j = 0; j < this.grid.getCols() && j * this.gridSize < super.getHeight(); j++) {// col
                    g2.drawImage(image, i * this.gridSize, j * this.gridSize, null);
                }
            }
        } catch (IOException e) {
            System.out.println("Oh well...");
            e.printStackTrace();
        }
    }

    public Grid getGrid() {
        return this.grid;
    }
    
    public GridDevPanel getDevPanel() {
        if (this.dev == null) {
            return new GridDevPanel(this);
        }
        return this.dev;
    }

    public int getgridSize() {
        return this.gridSize;
    }
}

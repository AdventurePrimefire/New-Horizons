package panel.grid;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.event.MouseInputListener;

import world.grid.Location;

//The Control center for the panels event handling system
public class GridPanelControl implements MouseInputListener {
    private GridPanel gridp;
    private ArrayList<GridPanelListener> lis;

    public GridPanelControl(GridPanel gridp) {
        this.gridp = gridp;
        this.lis = new ArrayList<GridPanelListener>();
    }
    
    public void addGridListener(GridPanelListener listener) {
        this.lis.add(listener);
    }
    
    @Override
    public void mouseClicked(MouseEvent mouse) {
        int row = mouse.getX() / this.gridp.getgridSize() + 1;
        int col = mouse.getY() / this.gridp.getgridSize() + 1;
        Location loc = new Location(row, col);
        System.out.println(loc);// add out of bounds check
        for (int i = 0; i < this.lis.size(); i++) {
            this.lis.get(i).locationChangeEvent(loc);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

    @Override
    public void mousePressed(MouseEvent arg0) {}

    @Override
    public void mouseReleased(MouseEvent arg0) {}

    @Override
    public void mouseDragged(MouseEvent arg0) {}

    @Override
    public void mouseMoved(MouseEvent arg0) {}

    public void addMouseListener(MouseListener lis) {}

}

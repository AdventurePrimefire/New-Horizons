package devKit.grid;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import panel.grid.GridPanel;
import world.grid.Grid;

public class GridDevPanel extends JPanel {
    private GridPanel gridp = null;
    private Grid grid = null;
    private LocationEditor locEdit;
    
    public GridDevPanel(GridPanel gridPanel) {
        this.gridp = gridPanel;
        grid = this.gridp.getGrid();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.locEdit = new LocationEditor(this.grid);
        this.add(this.locEdit);
        this.gridp.addGridPanelListener(locEdit);
    }
}

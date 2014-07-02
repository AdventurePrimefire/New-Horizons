package panel;

import world.grid.Grid;
import world.grid.GridMap;

public class GridPanel {
    private static final int MIN_CELL_SIZE = 48;
    private static final int DEFAULT_CELL_SIZE = 48;
    private static final int DEFAULT_CELL_COUNT = 10;

    private Grid<?> grid;

    public GridPanel() {
        this.grid = new GridMap(10, 10);
    }
}

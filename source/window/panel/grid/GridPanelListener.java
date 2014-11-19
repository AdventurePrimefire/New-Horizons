package panel.grid;

import world.grid.Location;

public interface GridPanelListener {
    /**
     * An event for when the grid Updates
     *
     * @param loc
     *            that the grid has now selected.
     */
    public default void locationChangeEvent(Location loc) {

    }
}

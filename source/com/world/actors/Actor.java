package world.actors;

import java.io.File;

import world.grid.Grid;
import world.grid.Location;
import display.Displayable;

public class Actor implements Displayable {
    private String name;
    private Location loc;
    private Grid grid;

    public Actor() {
        this.loc = null;
        this.name = new String("" + super.hashCode());
    }

    public Actor(Location loc) {
        this.loc = loc;
        this.name = new String("" + super.hashCode());
    }

    public Actor(Location loc, String name) {
        this.loc = loc;
        this.name = name;
    }

    public Location getLocation() {
        return this.loc;
    }

    public void act() {

    }

    @Override
    public String toString() {
        return this.name + "[" + this.loc.toString() + "]";
    }

    @Override
    public File getImageFile() {
        return new File("resource/setPieces/Actor_48.gif");
    }

    @Override
    public String getDisplayName() {
        return "Actor";
    }

    public void setLocation(Location location) {
        if (grid != null) {
            this.grid.removeFromGrid(loc);
            this.loc = location;
            this.grid.putInGrid(this);
        } else {
            this.loc = location;
        }

    }

    public String getName() {
        return this.name;
    }
}

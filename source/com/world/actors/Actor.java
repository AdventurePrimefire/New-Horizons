package world.actors;

import world.grid.Location;

public class Actor {
    private String name;
    private Location loc;

    public Actor() {
        this.loc = null;
        this.name = new String("" + super.hashCode());
    }

    public Actor(Location loc, String name) {
        this.loc = loc;
        this.name = name;
    }
    
    public Location getLocation() {
        return this.loc;
    }
    
    @Override
    public String toString() {
        return this.name + "[" + this.loc.toString() + "]";
    }
}

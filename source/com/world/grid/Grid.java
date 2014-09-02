package world.grid;

import java.util.Iterator;
import java.util.TreeMap;

import world.actors.Actor;

public class Grid {
    int rows;
    int cols;
    TreeMap<Location, Actor> locations;
    
    public Grid() {
        this.rows = 9;
        this.cols = 9;
        Location loc = new Location();
        this.locations = new TreeMap<Location, Actor>(loc.newLocComp());
    }
    
    public Actor putInGrid(Actor actor) {
        Location loc = actor.getLocation();
        if (loc.getRow() < 0 || loc.getCol() < 0) {
            return null;
        }
        Actor oldAct = null;
        if (this.locations.containsKey(loc)) {// if location allready exists
            oldAct = this.locations.get(loc);
            this.locations.replace(loc, actor);
            return oldAct;
        } else if (loc.getRow() <= this.rows) {
            if (loc.getCol() <= this.cols) {
                this.locations.put(loc, actor);
            }
        }
        return oldAct;
    }
    
    public Actor removeFromGrid(Location loc) {
        if (this.locations.containsKey(loc)) {
            return this.locations.remove(loc);
        }
        return null;
    }
    
    public Actor cheekLocation(Location loc) {
        if (this.locations.containsKey(loc)) {
            return this.locations.get(loc);
        }
        return null;
    }
    
    @Override
    public String toString() {
        String out = "Grid{";
        Iterator<Location> keys = this.locations.keySet().iterator();
        while (keys.hasNext()) {
            Location loc = keys.next();
            out += this.locations.get(loc).toString();
        }
        return out + "}";
    }

    public int getRows() {
        return this.rows + 1;
    }
    
    public int getCols() {
        return this.cols + 1;
    }

}

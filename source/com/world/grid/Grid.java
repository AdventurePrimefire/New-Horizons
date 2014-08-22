package world.grid;

import java.util.TreeMap;

import world.actors.Actor;

public class Grid {
    int hight;
    int width;
    TreeMap<Location, Actor> locations;

    public Grid() {
        this.hight = 10;
        this.width = 10;
        Location loc = new Location();
        this.locations = new TreeMap<Location, Actor>(loc.newLocComp());
    }

    public Actor putInGrid(Location loc, Actor actor) {
        Actor oldAct = null;
        if (this.locations.containsKey(loc)) {// if location allready exists
            oldAct = this.locations.get(loc);
            this.locations.replace(loc, actor);
            return oldAct;
        }
        this.locations.put(loc, actor);
        return oldAct;
    }

    public Actor removeFromGrid(Location loc) {
        if (this.locations.containsKey(loc)) {
            return this.locations.remove(loc);
        }
        return null;
    }

    public Actor cheekLocation(Location loc) {
        return this.locations.get(loc);
    }
}

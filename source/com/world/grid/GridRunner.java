package world.grid;

import world.actors.Actor;

public class GridRunner {
    public static void main(String[] args) {
        Location loc = new Location(3, 3, MapLayer.ActorLevel);
        Actor act = new Actor(loc, "Basic");
        Grid grid = new Grid();
        grid.putInGrid(act);
        System.out.println(grid);
    }
}

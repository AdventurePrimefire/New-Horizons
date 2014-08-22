/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board
 * (http://www.collegeboard.com).
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Alyce Brady
 * @author Chris Nevison
 * @author APCS Development Committee
 * @author Cay Horstmann
 */

package world.grid;

import java.util.Comparator;

import world.actors.Actor;

/**
 * A <code>Location</code> object represents the row and column of a location in a two-dimensional grid. <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */
public class Location {
    private int row; // row location in grid
    private int col; // column location in grid
    private MapLayer layer;
    private Actor actor;

    public enum FACING {
        NORTH {
            @Override
            public int getValue() {
                return 0;
            }
        },
        EAST {
            @Override
            public int getValue() {
                return 90;
            }
        },
        SOUTH {
            @Override
            public int getValue() {
                return 180;
            }
        },
        WEST {
            @Override
            public int getValue() {
                return 270;
            }
        };
        public abstract int getValue();
    }

    public enum TURNANGLE {
        AHEAD {
            @Override
            public int getValue() {
                return 0;
            }
        },
        LEFT {
            @Override
            public int getValue() {
                return -90;
            }
        },
        RIGHT {
            @Override
            public int getValue() {
                return 90;
            }
        },
        HALFCIRCLE {
            @Override
            public int getValue() {
                return 180;
            }
        },
        FULLCIRCLE {

            @Override
            public int getValue() {
                return 360;
            }

        };
        public abstract int getValue();
    }

    public Location(int row, int col, MapLayer layer, Actor actor) {
        this.row = row;
        this.col = col;
        this.layer = layer;
        this.actor = actor;
    }

    public Location() {
        this.row = 0;
        this.col = 0;
        this.layer = null;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public MapLayer getLayer() {
        return this.layer;
    }

    public class LocComp implements Comparator<Location> {
        @Override
        public int compare(Location loc1, Location loc2) {
            if (loc1.getRow() < loc2.getRow()) {
                return -1;
            } else if (loc1.getRow() > loc2.getRow()) {
                return 1;
            } else {
                if (loc1.getCol() < loc2.getCol()) {
                    return -1;
                } else if (loc1.getCol() > loc2.getCol()) {
                    return 1;
                } else {
                    switch (loc1.getLayer().relative(loc2.getLayer())) {
                        case Above:
                            return 1;
                        case Below:
                            return -1;
                        case Equal:
                            return 0;
                        default:
                            return 0;

                    }
                }

            }
        }
    }

    public Comparator<? super Location> newLocComp() {
        return new LocComp();
    }

}

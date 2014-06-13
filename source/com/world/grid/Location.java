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

/**
 * A <code>Location</code> object represents the row and column of a location in
 * a two-dimensional grid. <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */
public class Location implements Comparable {
    private int row; // row location in grid
    private int col; // column location in grid
    
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

    /**
     * Constructs a location with given row and column coordinates.
     *
     * @param r
     *            the row
     * @param c
     *            the column
     */
    public Location(int r, int c) {
        row = r;
        col = c;
    }
    
    /**
     * Gets the row coordinate.
     *
     * @return the row of this location
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Gets the column coordinate.
     *
     * @return the column of this location
     */
    public int getCol() {
        return col;
    }
    
    /**
     * Gets the adjacent location in any one of the eight compass directions.
     *
     * @param direction
     *            the direction in which to find a neighbor location
     * @return the adjacent location in the direction that is closest to
     *         <tt>direction</tt>
     */
    public Location getAdjacentLocation(int direction) {
        // reduce mod 360 and round to closest multiple of 45
        int adjustedDirection = (direction + TURNANGLE.LEFT.getValue() / 2) % TURNANGLE.FULLCIRCLE.getValue();
        if (adjustedDirection < 0) {
            adjustedDirection += TURNANGLE.FULLCIRCLE.getValue();
        }
        
        adjustedDirection = adjustedDirection / TURNANGLE.RIGHT.getValue() * TURNANGLE.RIGHT.getValue();
        int dc = 0;
        int dr = 0;
        if (adjustedDirection == FACING.EAST.getValue()) {
            dc = 1;
        } else if (adjustedDirection == FACING.SOUTH.getValue()) {
            dr = 1;
        } else if (adjustedDirection == FACING.WEST.getValue()) {
            dc = -1;
        } else if (adjustedDirection == FACING.NORTH.getValue()) {
            dr = -1;
        }
        return new Location(getRow() + dr, getCol() + dc);
    }
    
    /**
     * Returns the direction from this location toward another location. The
     * direction is rounded to the nearest compass direction.
     *
     * @param target
     *            a location that is different from this location
     * @return the closest compass direction from this location toward
     *         <code>target</code>
     */
    public int getDirectionToward(Location target) {
        int dx = target.getCol() - getCol();
        int dy = target.getRow() - getRow();
        // y axis points opposite to mathematical orientation
        int angle = (int) Math.toDegrees(Math.atan2(-dy, dx));
        
        // mathematical angle is counterclockwise from x-axis,
        // compass angle is clockwise from y-axis
        int compassAngle = RIGHT - angle;
        // prepare for truncating division by 45 degrees
        compassAngle += HALF_RIGHT / 2;
        // wrap negative angles
        if (compassAngle < 0) {
            compassAngle += FULL_CIRCLE;
        }
        // round to nearest multiple of 45
        return compassAngle / HALF_RIGHT * HALF_RIGHT;
    }
    
    /**
     * Indicates whether some other <code>Location</code> object is "equal to"
     * this one.
     *
     * @param other
     *            the other location to test
     * @return <code>true</code> if <code>other</code> is a
     *         <code>Location</code> with the same row and column as this
     *         location; <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Location)) {
            return false;
        }
        
        Location otherLoc = (Location) other;
        return getRow() == otherLoc.getRow() && getCol() == otherLoc.getCol();
    }
    
    /**
     * Generates a hash code.
     *
     * @return a hash code for this location
     */
    @Override
    public int hashCode() {
        return getRow() * 3737 + getCol();
    }
    
    /**
     * Compares this location to <code>other</code> for ordering. Returns a
     * negative integer, zero, or a positive integer as this location is less
     * than, equal to, or greater than <code>other</code>. Locations are ordered
     * in row-major order. <br />
     * (Precondition: <code>other</code> is a <code>Location</code> object.)
     *
     * @param other
     *            the other location to test
     * @return a negative integer if this location is less than
     *         <code>other</code>, zero if the two locations are equal, or a
     *         positive integer if this location is greater than
     *         <code>other</code>
     */
    @Override
    public int compareTo(Object other) {
        Location otherLoc = (Location) other;
        if (getRow() < otherLoc.getRow()) {
            return -1;
        }
        if (getRow() > otherLoc.getRow()) {
            return 1;
        }
        if (getCol() < otherLoc.getCol()) {
            return -1;
        }
        if (getCol() > otherLoc.getCol()) {
            return 1;
        }
        return 0;
    }
    
    /**
     * Creates a string that describes this location.
     *
     * @return a string with the row and column of this location, in the format
     *         (row, col)
     */
    @Override
    public String toString() {
        return "(" + getRow() + ", " + getCol() + ")";
    }
}

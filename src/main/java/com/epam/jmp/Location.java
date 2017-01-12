package com.epam.jmp;

/**
 * Created by Tomasz_Kozlowski on 1/12/2017.
 */
public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Location location) {
        this(location.getX(), location.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

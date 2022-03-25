package com.chess.game;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return this.x;}

    public int getY() {return this.y;}

    public int[] getCoords() { return new int[] {this.x, this.y}; }

    public boolean equals(Point point) { return (this.x == point.getX()) && (this.y == point.getY()); }
}

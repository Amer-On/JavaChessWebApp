package com.chess.game;

import com.chess.figures.*;

public class Cell {

    private final Point point;
    private Figure figure = null;

    public Cell(int x, int y) { this.point = new Point(x, y); }

    public Cell(int x, int y, Figure figure) { this(new Point(x, y), figure); }

    public Cell(Point point) { this.point = point; }

    public Cell(Point point, Figure figure) {
        this.point = point;
        this.figure = figure;
    }

    public void clearCell() { this.figure = null; }

    public Point getPoint() { return this.point; }

    public String getFigureName() {
        if (figure != null)
            return figure.getFigureName();
        return "0";
    }

    public boolean isEmpty() {
        if (figure != null)
            return false;
        return true;
    }
}

package com.chess.figures;

import com.chess.game.Field;
import com.chess.game.Point;

public class Bishop implements Figure {

    private final FigureType figureType = FigureType.BISHOP;
    private final String figureName = "b";
    Point point;
    Field gameField;

    public Bishop(Field gameField, Point point) {
        this.point = point;
        this.gameField = gameField;
    }

    public void move(Point endPoint) {}

    public FigureType getFigureType() {return this.figureType;}

    public String getFigureName() { return this.figureName; }

}

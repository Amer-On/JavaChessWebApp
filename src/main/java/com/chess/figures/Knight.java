package com.chess.figures;

import com.chess.game.Field;
import com.chess.game.Point;

public class Knight implements Figure {

    private final FigureType figureType = FigureType.KNIGHT;
    private final String figureName = "k";
    Point point;
    Field gameField;

    public Knight(Field gameField, Point point) {
        this.point = point;
        this.gameField = gameField;
    }

    public void move(Point endPoint) {

    }


    public FigureType getFigureType() {return this.figureType;}

    public String getFigureName() {return this.figureName;}

}

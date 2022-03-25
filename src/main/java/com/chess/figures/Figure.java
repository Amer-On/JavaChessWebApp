package com.chess.figures;

import com.chess.game.Point;

public interface Figure {
//    FigureType figureType = FigureType.NOTYPE;
//    String figureName = "";

    void move(Point endPoint);

    boolean isValidMove(Point endPoint);

    String getFigureName();
//    default String getFigureName() {return this.figureName;}

    FigureType getFigureType();
//    default String getFigureType() {
//        return this.figureType.toString();}
}

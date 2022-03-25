package com.chess.figures;

import com.chess.game.Cell;
import com.chess.game.Field;
import com.chess.game.Point;

import static java.lang.Math.abs;

public class Queen implements Figure {

    private final FigureType figureType = FigureType.QUEEN;
    private final String figureName = "q";
    private Point point;
    Field gameField = null;

    public Queen(Field gameField, Point point) {
        this.point = point;
        this.gameField = gameField;
    }


    public void move(Point endPoint) {
//        if (isValidMove(this.point, endPoint, gameField)) {
//            System.out.println("cookie");
//        } else {
//            throw new RuntimeException("Invalid move for figure");
//        }


    }

    private boolean isValidMove(Point startPoint, Point endPoint, Cell[][] gameField) {
        if (startPoint.equals(endPoint)) {
            return false;
        }

        int startX = startPoint.getX(), startY = startPoint.getY();
        int endX = endPoint.getX(), endY = endPoint.getY();
        boolean isValidMove = true;

        if (startX == endX) {
            for (int y = startY + 1; y < endY; y++)
                if (!gameField[startX][y].isEmpty())
                    return false;
            return true;
        } else if (startY == endY) {
            for (int x = startX + 1; x < endX; x++)
                if (!gameField[x][startY].isEmpty())
                    return false;
            return true;
        } else if (abs(endX - startX) == abs(endY - startY)) {
            for (int x = startX + 1, y = startY + 1; x < endX && y < endY; x++, y++)
                if (!gameField[x][y].isEmpty())
                    return false;
            return true;
        } else {
            return false;
        }
    }

    public FigureType getFigureType() {return this.figureType;}

    public String getFigureName() {
        return figureName;
    }

}

package com.chess.figures;

import static java.lang.Math.abs;

import com.chess.game.Cell;
import com.chess.game.Field;
import com.chess.game.Point;

public class Queen implements Figure {

  private final FigureType figureType = FigureType.QUEEN;
  private final String figureName = "q";
  private Point point;
  Field field = null;

  public Queen(Field gameField, Point point) {
    this.point = point;
    this.field = gameField;
  }

  public boolean isValidMove(Point endPoint) {
    if (point.equals(endPoint) || !field.isValidPoint(endPoint)) {
      return false;
    }
    Cell[][] gameField = field.getGameField();

    int startX = point.getX();
    int startY = point.getY();
    int endX = endPoint.getX();
    int endY = endPoint.getY();

    if (startX == endX) {
      if (startY < endY) {
        for (int y = startY + 1; y < endY; y++) {
          if (!gameField[startX][y].isEmpty()) {
            return false;
          }
        }
      } else if (startY > endY) {
        for (int y = startY - 1; y > endY; y--) {
          if (!gameField[startX][y].isEmpty()) {
            return false;
          }
        }
      }
      return true;
    } else if (startY == endY) {
      if (startX < endX) {
        for (int x = startX + 1; x < endX; x++) {
          if (!gameField[x][startY].isEmpty()) {
            return false;
          }
        }
      } else {
        for (int x = startX - 1; x > endX; x--) {
          if (!gameField[x][startY].isEmpty()) {
            return false;
          }
        }
      }
      return true;
    } else if (abs(endX - startX) == abs(endY - startY)) {
      if (endX - startX > 0) {
        if (endY - startY > 0) {
          for (int x = startX + 1, y = startY + 1; x < endX && y < endY; x++, y++) {
            if (!gameField[x][y].isEmpty()) {
              return false;
            }
          }
        } else {
          for (int x = startX + 1, y = startY - 1; x < endX && y > endY; x++, y--) {
            if (!gameField[x][y].isEmpty()) {
              return false;
            }
          }
        }
        return true;
      } else {
        if (endY - startY > 0) {
          for (int x = startX - 1, y = startY + 1; x > endX && y < endY; x--, y++) {
            if (!gameField[x][y].isEmpty()) {
              return false;
            }
          }
        } else {
          for (int x = startX - 1, y = startY - 1; x > endX && y > endY; x--, y--) {
            if (!gameField[x][y].isEmpty()) {
              return false;
            }
          }
        }
        return true;
      }
    }
    return false;
  }

  public FigureType getFigureType() {
    return this.figureType;
  }

  public String getFigureName() {
    return figureName;
  }

}

package com.chess.figures;

import com.chess.game.Field;
import com.chess.game.Point;

public class Rook implements Figure {

  private final FigureType figureType = FigureType.ROOK;
  private final String figureName = "r";
  Point point;
  Field gameField;

  public Rook(Field gameField, Point point) {
    this.point = point;
    this.gameField = gameField;
  }

  public void move(Point endPoint) {

  }

  public boolean isValidMove(Point endPoint) {
    return false;
  }

  public FigureType getFigureType() {
    return this.figureType;
  }

  public String getFigureName() {
    return this.figureName;
  }

}

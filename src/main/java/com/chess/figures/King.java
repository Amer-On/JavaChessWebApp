package com.chess.figures;

import com.chess.game.Field;
import com.chess.game.Point;

public class King implements Figure {

  private final FigureType figureType = FigureType.KING;
  private final String figureName = "K";
  Point point;
  Field gameField;

  public King(Field gameField, Point point) {
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

package com.chess.figures;

import com.chess.game.Point;

public interface Figure {
  boolean isValidMove(Point endPoint);

  String getFigureName();

  FigureType getFigureType();
}

package com.chess.game;

import com.chess.figures.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * field for two players.
 *
 * @author amer-on
 */
public class Field {

  private Cell[][] gameField;
  private final int length;
  private final int width;
  private ArrayList<Figure> figureList = new ArrayList<Figure>();

  public Field() {
    this("src/main/resources/static/classicChess.txt", 8, 8);
  }

  public Field(String filePath, int length, int width) {
    this.length = length;
    this.width = width;
    this.gameField = createField(filePath);
  }

  private Cell[][] createField(String filePath) {
    Cell[][] gameField = new Cell[this.length][this.width];
    char[][] charField = readFileToCharArr(filePath);

    for (int i = 0; i < this.length; i++) {
      for (int j = 0; j < this.width; j++) {
        Point point = new Point(i, j);
        switch (charField[i][j]) {
          case 'z':
            gameField[i][j] = new Cell(point);
            break;

          case 'p':
            gameField[i][j] = new Cell(point, new Pawn(this, point));
            break;

          case 'r':
            gameField[i][j] = new Cell(point, new Rook(this, point));
            break;

          case 'k':
            gameField[i][j] = new Cell(point, new Knight(this, point));
            break;

          case 'b':
            gameField[i][j] = new Cell(point, new Bishop(this, point));
            break;

          case 'q':
            gameField[i][j] = new Cell(point, new Queen(this, point));
            break;

          case 'K':
            gameField[i][j] = new Cell(point, new King(this, point));
            break;

          default:
            // TODO: create an exception
            throw new RuntimeException("invalid figure");

        }
      }
    }

    return gameField;
  }

  public void printField() {
    for (int i = 0; i < this.length; i++) {
      for (int j = 0; j < this.width; j++) {
        System.out.print(this.gameField[i][j].getFigureName() + " ");
      }
      System.out.println();
    }
  }


  public static char[][] readFileToCharArr(final String filePath) {
    return readFileToCharArr(filePath, 8, 8);
  }

  public static char[][] readFileToCharArr(final String filePath, int length, int width) {
    char[][] charField = new char[length][width];
    try {
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String line;
      int currentId = 0;

      while ((line = br.readLine()) != null) {
        charField[currentId] = line.replaceAll(" ", "").toCharArray();
        currentId++;
      }

      br.close();
      return charField;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean isValidPoint(Point point) {
    if (point.getY() < 0 || point.getX() < 0) {
      return false;
    }

    if (point.getX() >= this.length) {
      return false;
    } else if (point.getY() >= this.width) {
      return false;
    }

    return true;
  }

  private static void printCharArray(char[][] charArray) {
    for (char[] line : charArray) {
      for (char chr : line) {
        System.out.print(chr + " ");
      }
      System.out.println();
    }
  }

  public Cell[][] getGameField() {
    return this.gameField;
  }

  private void execute() {
    printField();
  }

  ;

  // just to check out some funcs
  public static void main(String[] args) {
    Field field = new Field();
    field.execute();
  }
}

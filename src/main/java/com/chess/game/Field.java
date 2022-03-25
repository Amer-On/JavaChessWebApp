package com.chess.game;

import java.io.*;
import java.util.*;

// TODO: Write tests
// TODO: Learn and implement Swing for UI

import com.chess.figures.*;

// field for two players
public class Field {

    private Cell[][] gameField;
    private final int LENGTH = 8, WIDTH = 8;
    private ArrayList<Figure> figureList = new ArrayList<Figure>();

    public Field() {
        this.gameField = createField();
    }

    private Cell[][] createField() {
        Cell[][] gameField = new Cell[this.LENGTH][this.WIDTH];
        char[][] charField = readFileToCharArr();

        for (int i = 0; i < this.LENGTH; i++) {
            for (int j = 0; j < this.WIDTH; j++) {
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

                }
            }
        }

        return gameField;
    }

    private void printField() {
        for (int i = 0; i < this.LENGTH; i++) {
            for (int j = 0; j < this.WIDTH; j++)
                System.out.print(this.gameField[i][j].getFigureName() + " ");
            System.out.println();
        }
    }

    private char[][] readFileToCharArr() {
        return readFileToCharArr("src/main/resources/static/classicChess.txt",
            this.LENGTH, this.WIDTH);
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

    private static void printCharArray(char[][] charArray) {
        for (char[] line : charArray) {
            for (char chr : line)
                System.out.print(chr + " ");
            System.out.println();
        }
    }

    public Cell[][] getGameField() { return this.gameField; }

    private void execute(){
        printField();
    };

    // just to check out some funcs
    public static void main(String[] args) {
        Field field = new Field();
        field.execute();
    }
}

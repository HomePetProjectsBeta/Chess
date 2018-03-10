package com.vertex.desk;

import com.vertex.logic.Figure;
import com.vertex.logic.Pawn;

import java.util.Scanner;

public class Table {

    private int turn;
    private String turnOwner;
    private Cell[][] coords = new Cell[8][8]; // x = letters , y = numbers

    public Table() {
        turn = 1;
        turnOwner = "White";
        init();
    }

    private void init() {
        String[] letters = {"a" , "b" , "c" , "d" , "e", "f", "g", "h"};
        //init main figures
        for (int i = 0; i < 8; i++) {
            coords[0][i] = new Cell(letters[i], String.valueOf(0), new Pawn("K" , "white"));
            coords[7][i] = new Cell(letters[i], String.valueOf(7), new Pawn("K" , "black"));

        }
        //init pawns
            for (int j = 0; j < 8; j++) {
                coords[1][j] = new Cell(letters[j], String.valueOf(1), new Pawn("p" , "white"));
                coords[2][j] = new Cell(letters[j], String.valueOf(2), new Pawn("p" , "black"));
                coords[6][j] = new Cell(letters[j], String.valueOf(6), new Pawn("p" , "black"));

        }
        //init Space Cells
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                coords[i][j] = new Cell(letters[j], String.valueOf(i) , null);
            }
        }
    }

    public void turn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write coords for turn");
        String cord1 = sc.nextLine();
        String cord2 = sc.nextLine();
        Cell cell1 = toCell(cord1);
        System.out.println(cell1.getX() + "," + cell1.getY());
        Cell cell2 = toCell(cord2);
        System.out.println(cell2.getX() + "," + cell1.getY());
        System.out.println(cell1.getFigureName());
        Figure figure = cell1.getFigure();
        switch (figure.getName()) {
            case "p":
                System.out.println("we are here");
                if (!(isWhiteMovePawn(cord1, cord2))) {
                    System.out.println("Cant move");
                    if (!isWhiteMovePawnKick(cord1, cord2)) {
                        System.out.println("Cant kick with move");
                    } else {
                        figure.move(cell1 , cell2);
                        System.out.println("Turn done");
                    }
            }
        }
    }

    public void paintField() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.print(coords[i][j].getFigureName());
            }
            System.out.println();
        }
    }

    public void gameStart() {
        init();
        paintField();
        turnOwner = "white";
        turn();
        paintField();

    }

    private boolean isWhiteMovePawn(String cell1, String cell2) {
        String letter1 = cell1.substring(0);
        int number1 = Integer.parseInt(cell1.substring(1));
        String letter2 = cell2.substring(0);
        int number2 = Integer.parseInt(cell2.substring(1));
        if (letter1.equals(letter2)) {
            if ((number2 - number1) == 1) {
                if (coords[getNum(letter2)][number2].isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWhiteMovePawnKick(String cell1, String cell2) {
        String letter1 = cell1.substring(0);
        int number1 = Integer.parseInt(cell1.substring(1));
        String letter2 = cell2.substring(0);
        int number2 = Integer.parseInt(cell2.substring(1));
        if ((number2 - number1) == 1) {
            if ((Math.abs(getNum(letter2) - getNum(letter1)) == 1)){
                  if (coords[getNum(letter2)][number2].getColor().equals("black")) {
                        return true;
                }
            }
        }
        return false;
    }

    private int getNum(String letter) {
        String[] letters = {"a" , "b" , "c" , "d" , "e", "f", "g", "h"};
        for (int i = 0; i < letters.length; i++) {

            if (letters[i].equals(letter.toLowerCase()))
                return i;
        }
        return 0;
    }

    private Cell toCell(String cord) {
        System.out.println(getNum(String.valueOf(cord.charAt(0))));
        System.out.println(Integer.parseInt(String.valueOf(cord.charAt(1))));
        Cell cell = coords[getNum(String.valueOf(cord.charAt(0)))][Integer.parseInt(String.valueOf(cord.charAt(1)))];
        return cell;
    }


}

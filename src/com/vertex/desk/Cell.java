package com.vertex.desk;

import com.vertex.logic.Figure;

public class Cell {

    private String x;
    private String y;

    private Figure figure;

    public Cell(String x, String y, Figure figure) {
        this.x = x;
        this.y = y;
        this.figure = figure;
    }

    public boolean isEmpty() {
        return figure == null;
    }

    public void moveDone(Figure figure) {
        this.figure = figure;
    }

    public void moveOff() {
        figure = null;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getColor() {
        return figure.getColor();
    }

    public String getFigureName() {
        return figure != null ? figure.getName() : " ";
    }
}

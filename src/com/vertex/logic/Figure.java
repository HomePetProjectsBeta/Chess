package com.vertex.logic;

import com.vertex.desk.Cell;

public abstract class Figure {

    public String getName() {
        return name;
    }

    private String name;

    public Figure(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    private String color;

    public abstract void move(Cell cellfrom, Cell cellTo);
}

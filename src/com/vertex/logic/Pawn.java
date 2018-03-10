package com.vertex.logic;

//решка

import com.vertex.desk.Cell;

public class Pawn extends Figure{

    public Pawn(String name, String color) {
        super(name, color);
    }

    @Override
    public void move(Cell cellfrom, Cell cellTo) {
        cellfrom.moveOff();
        cellTo.moveDone(this);
    }
}

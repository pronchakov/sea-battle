package edu.seabattle.game.entity;

import lombok.Data;

import java.util.List;

public class Field {

    private Cell[][] cells;

    public Field(Cell[][] cells) {
        this.cells = cells;
    }

    public void setCellStatus(CellCoordinate coordinate, CellStatus status) {
        cells[coordinate.getCol()][coordinate.getRow()].setStatus(status);
    }
}

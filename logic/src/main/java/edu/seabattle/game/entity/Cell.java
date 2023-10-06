package edu.seabattle.game.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cell extends CellCoordinate {
    private CellStatus status;

    public Cell(int col, int row, CellStatus status) {
        super(col, row);
        this.status = status;
    }
}

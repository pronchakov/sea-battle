package edu.seabattle.game.entity;

import edu.seabattle.game.entity.exception.IdenticalCellsException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CellCoordinate implements Comparable<CellCoordinate> {
    private int col;
    private int row;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CellCoordinate that)) return false;

        if (col != that.col) return false;
        return row == that.row;
    }

    @Override
    public int hashCode() {
        int result = col;
        result = 31 * result + row;
        return result;
    }

    @Override
    public int compareTo(CellCoordinate that) {
        if (this.getCol() == that.getCol()) {
            return this.getRow() - that.getRow();
        }
        if (this.getRow() == that.getRow()) {
            return this.getCol() - that.getCol();
        }
        throw new IdenticalCellsException(that);
    }
}

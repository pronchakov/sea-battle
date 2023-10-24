package edu.seabattle.game.field.cell;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinates implements Comparable<Coordinates> {
    private int column;
    private int row;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates that)) return false;

        if (column != that.column) return false;
        return row == that.row;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        return result;
    }

    @Override
    public int compareTo(Coordinates that) {
        if (this.getColumn() == that.getColumn()) {
            return this.getRow() - that.getRow();
        }
        if (this.getRow() == that.getRow()) {
            return this.getColumn() - that.getColumn();
        }
        throw new IdenticalCellsException(that);
    }
}

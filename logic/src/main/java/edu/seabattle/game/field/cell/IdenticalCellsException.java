package edu.seabattle.game.field.cell;

import edu.seabattle.game.field.cell.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IdenticalCellsException extends RuntimeException{
    private Coordinates coordinate;
}

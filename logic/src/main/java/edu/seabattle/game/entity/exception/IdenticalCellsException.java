package edu.seabattle.game.entity.exception;

import edu.seabattle.game.entity.CellCoordinate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IdenticalCellsException extends RuntimeException{
    private CellCoordinate coordinate;
}

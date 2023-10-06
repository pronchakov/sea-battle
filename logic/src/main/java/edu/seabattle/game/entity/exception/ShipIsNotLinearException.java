package edu.seabattle.game.entity.exception;

import edu.seabattle.game.entity.CellCoordinate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
public class ShipIsNotLinearException extends Throwable {
    @NonNull
    private List<CellCoordinate> ship;
}

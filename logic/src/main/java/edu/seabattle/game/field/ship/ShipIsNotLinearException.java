package edu.seabattle.game.field.ship;

import edu.seabattle.game.field.cell.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
public class ShipIsNotLinearException extends Throwable {
    @NonNull
    private List<Coordinates> ship;
}

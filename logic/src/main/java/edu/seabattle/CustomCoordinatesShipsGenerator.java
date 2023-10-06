package edu.seabattle;

import edu.seabattle.game.entity.Ship;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomCoordinatesShipsGenerator implements ShipsGenerator{

    private List<String> coordinates;

    public CustomCoordinatesShipsGenerator(List<String> coordinates) {
        if (coordinates == null || coordinates.size() != 15 ) { // TODO: magic number
            throw new IllegalArgumentException(String.format("Ships count must be 15 not '%s'", coordinates == null ? "null" : coordinates.size()));
        }
        this.coordinates = coordinates;
    }

    @Override
    public Set<Ship> generateShips() {
        final var ships = new HashSet<Ship>();

//        coordinates.stream()
//                .map(s -> )

        return ships;
    }

    private Ship transformCoordinatesToShip(String coordinates) {
        final var split = coordinates.split(",");
        final var shipStartStr = split[0];
        final var shipEndStr = split[1];

        return null;
    }
}

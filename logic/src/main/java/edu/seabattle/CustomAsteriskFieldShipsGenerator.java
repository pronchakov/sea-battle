package edu.seabattle;

import edu.seabattle.game.entity.Ship;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class CustomAsteriskFieldShipsGenerator implements ShipsGenerator {

    private String asteriskField;

    @Override
    public Set<Ship> generateShips() {
        final var result = new HashSet<Ship>();



        return result;
    }
}

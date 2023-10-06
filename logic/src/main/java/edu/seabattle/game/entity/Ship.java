package edu.seabattle.game.entity;

import edu.seabattle.game.entity.CellCoordinate;
import lombok.Data;

import java.util.List;

@Data
public class Ship {

    private TYPE type;

    private List<CellCoordinate> cells;

    public enum TYPE {
        ONE_DECK, TWO_DECK, THREE_DECK, FOUR_DECK, FIVE_DECK;
    }

}

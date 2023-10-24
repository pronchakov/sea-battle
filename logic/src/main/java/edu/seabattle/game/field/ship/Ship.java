package edu.seabattle.game.field.ship;

import edu.seabattle.game.field.cell.Cell;
import edu.seabattle.game.field.cell.Coordinates;
import lombok.Data;

import java.util.List;

@Data
public class Ship {

    private TYPE type;

    private List<Cell> decks;

    public enum TYPE {
        ONE_DECK, TWO_DECK, THREE_DECK, FOUR_DECK, FIVE_DECK;
    }

}

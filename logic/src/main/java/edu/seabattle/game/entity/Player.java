package edu.seabattle.game.entity;

import edu.seabattle.move.Move;
import edu.seabattle.player.PlayerInteraction;
import lombok.Data;

import java.util.List;

@Data
public class Player {
    private PlayerInteraction interaction;
    private List<Ship> ships;
    private List<Move> moves;
    private Field self;
    private Field opponent;

    // make builder

    public PlayerInteraction contact() {
        return getInteraction();
    }

    public Player(PlayerInteraction interaction) {
        this.interaction = interaction;
        // make private
        // check we got all
    }

    public void setShips(List<List<CellCoordinate>> ships) {

//        this.ships = ships;
//        for (Ship ship : ships) {
//            for (CellCoordinate cellCoordinate : ship.getCells()) {
//                self[cellCoordinate.getCol()][cellCoordinate.getRow()].setStatus(CellStatus.SHIP_SAIL);
//            }
//        }
    }



    public CellStatus getCellStatus(CellCoordinate move) {
        return null;
//        return self[move.getCol()][move.getRow()].getStatus();
    }
}

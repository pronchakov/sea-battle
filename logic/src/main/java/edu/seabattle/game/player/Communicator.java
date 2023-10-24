package edu.seabattle.game.player;

import edu.seabattle.game.field.cell.Coordinates;
import edu.seabattle.game.field.ship.Ship;
import edu.seabattle.game.move.MoveResult;

import java.util.List;

public interface Communicator {
    Coordinates requestFireCoordinates();
    List<Ship> getPlacedShips();
    void opponentMoveResult(Coordinates move, MoveResult result);
    void yourMoveResult(Coordinates move, MoveResult result);
    void youWin();
    void youLost();
}

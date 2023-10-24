package edu.seabattle.game.player.bot;

import edu.seabattle.game.field.cell.Coordinates;
import edu.seabattle.game.field.ship.Ship;
import edu.seabattle.game.move.MoveResult;
import edu.seabattle.game.player.Communicator;

import java.util.List;

public class BotCommunicator implements Communicator {
    @Override
    public Coordinates requestFireCoordinates() {
        return null;
    }

    @Override
    public List<Ship> getPlacedShips() {
        return null;
    }

    @Override
    public void opponentMoveResult(Coordinates move, MoveResult result) {

    }

    @Override
    public void yourMoveResult(Coordinates move, MoveResult result) {

    }

    @Override
    public void youWin() {

    }

    @Override
    public void youLost() {

    }
}

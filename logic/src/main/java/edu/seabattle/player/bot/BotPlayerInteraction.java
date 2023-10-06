package edu.seabattle.player.bot;

import edu.seabattle.game.entity.Cell;
import edu.seabattle.game.entity.CellCoordinate;
import edu.seabattle.move.FireResult;
import edu.seabattle.player.PlayerInteraction;

import java.util.List;

public class BotPlayerInteraction implements PlayerInteraction {
    @Override
    public CellCoordinate giveMeYourMove() {
        return null;
    }

    @Override
    public List<List<CellCoordinate>> placeYourShips() {
        return null;
    }

    @Override
    public void opponentMoveResult(CellCoordinate move, FireResult result) {

    }

    @Override
    public void yourMoveResult(CellCoordinate move, FireResult result) {

    }

    @Override
    public void youWin() {

    }

    @Override
    public void youLost() {

    }
}

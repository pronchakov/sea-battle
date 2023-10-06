package edu.seabattle.player;

import edu.seabattle.game.entity.CellCoordinate;
import edu.seabattle.move.FireResult;

import java.util.List;

public interface PlayerInteraction {
    CellCoordinate giveMeYourMove();
    List<List<CellCoordinate>> placeYourShips();
    void opponentMoveResult(CellCoordinate move, FireResult result);
    void yourMoveResult(CellCoordinate move, FireResult result);
    void youWin();
    void youLost();
}

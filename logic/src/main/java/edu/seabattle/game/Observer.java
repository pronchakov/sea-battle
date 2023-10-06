package edu.seabattle.game;

import edu.seabattle.game.entity.Cell;
import edu.seabattle.game.entity.CellCoordinate;
import edu.seabattle.move.FireResult;
import edu.seabattle.player.PlayerInteraction;

public interface Observer {

    void notifyGamePreparing();
    void notifyPlayerIsReady(PlayerInteraction playerInteraction);
    void notifyGameStart();
    void notifyMove(PlayerInteraction playerInteraction, CellCoordinate move, FireResult result);
    void notifyGameEnd(PlayerInteraction winner);

}

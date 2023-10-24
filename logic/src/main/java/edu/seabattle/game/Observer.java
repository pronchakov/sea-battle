package edu.seabattle.game;

import edu.seabattle.game.field.cell.Coordinates;
import edu.seabattle.game.field.ship.Ship;
import edu.seabattle.game.move.MoveResult;
import edu.seabattle.game.player.Player;

public interface Observer {

    void notifyGamePreparing();
    void notifyPlayerIsReady(Player player);
    void notifyGameStart();
    void notifyMove(Player player, Coordinates move, MoveResult result);
    void notifyMove(Player player, Coordinates move, MoveResult result, Ship ship);
    void notifyGameEnd(Player winner);
}

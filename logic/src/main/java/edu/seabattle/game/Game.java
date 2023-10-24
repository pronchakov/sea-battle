package edu.seabattle.game;

import edu.seabattle.game.field.cell.CellStatus;
import edu.seabattle.game.move.MoveResult;
import edu.seabattle.game.player.Communicator;
import edu.seabattle.game.player.FirstMovePlayerSelectorStrategy;
import edu.seabattle.game.player.Player;

public class Game {
    private Players players;
    private Observer observer;
    private FirstMovePlayerSelectorStrategy firstMovePlayerSelectorStrategy;

    public Game(Observer observer, Communicator comm1, Communicator comm2, FirstMovePlayerSelectorStrategy firstMovePlayerSelectorStrategy) {
        this.observer = observer;
        this.firstMovePlayerSelectorStrategy = firstMovePlayerSelectorStrategy;
        players =new Players(new Player(comm1), new Player(comm2));
    }

    public void startGameProcess() {
        observer.notifyGamePreparing();

        // todo: multitask
        requestShipsFromPlayer(players.first());
        requestShipsFromPlayer(players.second());

        chooseFirstPlayerToMove();

        observer.notifyGameStart();
        do {
            final var attackPlayer = players.getCurrent();
            final var defencePlayer = players.getNext();

            final var fireCoordinates = attackPlayer.getFireCoordinates();
            final var firedCellStatus = defencePlayer.getCellStatus(fireCoordinates);

            if (firedCellStatus == CellStatus.CLEAR) {
                attackPlayer.youMissed(fireCoordinates);
                defencePlayer.opponentMissed(fireCoordinates);
                players.changePlayer();
                observer.notifyMove(attackPlayer, fireCoordinates, MoveResult.MISSED);
            } else if (firedCellStatus == CellStatus.DECK) {
                if (defencePlayer.isShipSunk(fireCoordinates)) {
                    final var ship = defencePlayer.getSunkShip(fireCoordinates);
                    attackPlayer.youDestroedShip(fireCoordinates, ship);
                    defencePlayer.opponentDestroedShip(fireCoordinates, ship);
                    observer.notifyMove(attackPlayer, fireCoordinates, MoveResult.SUNK, ship);
                } else {
                    attackPlayer.youInjuredDeck(fireCoordinates);
                    defencePlayer.opponentInjuredDeck(fireCoordinates);
                    observer.notifyMove(attackPlayer, fireCoordinates, MoveResult.INJURED);
                }
            } else {
                // todo: error, repeat request
            }

            if (defencePlayer.areAllShipsSunk()) {
                attackPlayer.youWin();
                defencePlayer.youLost();
                observer.notifyGameEnd(attackPlayer);
                break;
            }
        } while (true /*game not end*/);
    }

    private void chooseFirstPlayerToMove() {
        final var chosedPlayer = firstMovePlayerSelectorStrategy.chooseFirst(players.first(), players.second());
        players.setCurrent(chosedPlayer);
    }

    private void requestShipsFromPlayer(Player player) {
        player.placeYourShips();
        observer.notifyPlayerIsReady(player);
    }

}

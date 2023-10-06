package edu.seabattle.game;

import edu.seabattle.game.entity.CellStatus;
import edu.seabattle.game.entity.Player;
import edu.seabattle.move.FireResult;
import edu.seabattle.player.PlayerInteraction;

import java.util.concurrent.CompletableFuture;

public class Game {
    private PlayerSequence playerSequence;
    private Observer observer;

    public Game(Observer observer, PlayerInteraction playerInteraction1, PlayerInteraction playerInteraction2) {
        this.observer = observer;
        playerSequence =new PlayerSequence(new Player(playerInteraction1), new Player(playerInteraction2));
    }

    public void startGameProcess() {
        observer.notifyGamePreparing();

        requestPlayersForTheirShips();

        // TODO: decide who will be first to move
        // (multiple design strategies)

        // start the game
        // (notify coordinator about process))
        observer.notifyGameStart();

        // request moves sequentially from players until all ships will be destroyed or
        // there will be no more cells to shoot
        // (notify coordinator about process)

        do {
            playerSequence.useNextPlayer();
            final var attackPlayer = playerSequence.getCurrent();
            final var defencePlayer = playerSequence.getNext();

            final var move = attackPlayer.contact().giveMeYourMove();
            final var firedCellStatus = defencePlayer.getCellStatus(move);

            if (firedCellStatus == CellStatus.CLEAR) {
                attackPlayer.getOpponent().setCellStatus(move, CellStatus.MISSED);
                defencePlayer.getSelf().setCellStatus(move, CellStatus.MISSED);

                attackPlayer.contact().yourMoveResult(move, FireResult.MISSED);
                defencePlayer.contact().opponentMoveResult(move, FireResult.MISSED);

                observer.notifyMove(attackPlayer.contact(), move, FireResult.MISSED);
            } else if (firedCellStatus == CellStatus.DECK_ALIVE) {
                attackPlayer.getOpponent().setCellStatus(move, CellStatus.DECK_INJURED);
                defencePlayer.getSelf().setCellStatus(move, CellStatus.DECK_INJURED);

                // todo: check ship sink

                attackPlayer.contact().yourMoveResult(move, FireResult.INJURED);
                defencePlayer.contact().opponentMoveResult(move, FireResult.INJURED);

                observer.notifyMove(attackPlayer.contact(), move, FireResult.INJURED);
            } else if (firedCellStatus == CellStatus.DECK_INJURED || firedCellStatus == CellStatus.MISSED) {
                attackPlayer.contact().yourMoveResult(move, FireResult.REPEATED);
                defencePlayer.contact().opponentMoveResult(move, FireResult.REPEATED);

                observer.notifyMove(attackPlayer.contact(), move, FireResult.REPEATED);
            }


            if (true /*game ended*/) {
                attackPlayer.contact().youWin();
                defencePlayer.contact().youLost();
                observer.notifyGameEnd(attackPlayer.contact());
                break;
            }
        } while (true /*game not end*/);
    }

    private void requestPlayersForTheirShips() {
        CompletableFuture.allOf(
                placeYourShips(playerSequence.first()),
                placeYourShips(playerSequence.last())
        ).join();
    }

    // TODO: use virtual threads here
    private CompletableFuture<Void> placeYourShips(Player player) {
        return CompletableFuture
                .supplyAsync(() -> player.contact().placeYourShips())
//                .thenAcceptAsync(check ships a met rules)
                .thenAccept(ships -> {
                    player.setShips(ships);
                    observer.notifyPlayerIsReady(player.contact());
                });
    }

}

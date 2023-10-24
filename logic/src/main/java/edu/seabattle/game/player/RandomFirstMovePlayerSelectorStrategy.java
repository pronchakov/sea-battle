package edu.seabattle.game.player;

import java.util.Random;

public class RandomFirstMovePlayerSelectorStrategy implements FirstMovePlayerSelectorStrategy{
    @Override
    public Player chooseFirst(Player player1, Player player2) {
        final var random = new Random().nextInt(2);
        if (random == 0) {
            return player1;
        } else {
            return player2;
        }
    }
}

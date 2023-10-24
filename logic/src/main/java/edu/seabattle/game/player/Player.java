package edu.seabattle.game.player;

import edu.seabattle.game.field.Field;
import edu.seabattle.game.field.cell.CellStatus;
import edu.seabattle.game.field.ship.Ship;
import edu.seabattle.game.field.cell.Coordinates;
import edu.seabattle.game.move.Move;
import lombok.Getter;

public class Player {
    @Getter
    private Communicator communicator;

//    private List<Move> moves;
    private Field ownField;
    private Field opponentField;

    // make builder

    public Player(Communicator communicator) {
        this.communicator = communicator;
        // make private
        // check we got all
    }


    public CellStatus getCellStatus(Coordinates move) {
        return null;
    }

    public Coordinates getFireCoordinates() {

    }

    public void youMissed(Coordinates move) {

    }

    public void opponentMissed(Coordinates move) {

    }

    public boolean isShipSunk(Coordinates move) {
        return false;
    }

    public Ship getSunkShip(Coordinates move) {
        return null;
    }

    public void youDestroedShip(Coordinates move, Ship ship) {

    }

    public void opponentDestroedShip(Coordinates move, Ship ship) {

    }

    public void youInjuredDeck(Coordinates move) {

    }

    public void opponentInjuredDeck(Coordinates move) {

    }

    public boolean areAllShipsSunk() {
        return false;
    }

    public void placeYourShips() {
        this.ships = communicator.getPlacedShips();
    }

    public void youWin() {

    }

    public void youLost() {

    }
}

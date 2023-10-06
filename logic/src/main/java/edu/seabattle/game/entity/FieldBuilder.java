package edu.seabattle.game.entity;

import edu.seabattle.game.IsIdenticalCollector;
import edu.seabattle.game.entity.exception.FieldBuildException;
import edu.seabattle.game.entity.exception.ShipCountMismatchException;
import edu.seabattle.game.entity.exception.ShipIsNotLinearException;
import edu.seabattle.game.entity.exception.WrongShipsTypesException;

import java.util.HashMap;
import java.util.List;

public class FieldBuilder {

    private List<List<CellCoordinate>> ships;
    private Field field;

    public FieldBuilder() {
        final var cells = new Cell[10][10];
        fillWithClearCells(cells);
        field = new Field(cells);
    }

    public Field build() throws FieldBuildException {
        try {
            checkShipsCount();
            checkShipsInLine();
            checkLocation();
            checkShipTypes();
        } catch (ShipCountMismatchException e) {
            throw new FieldBuildException(e);
        } catch (ShipIsNotLinearException e) {
            throw new FieldBuildException(e);
        } catch (WrongShipsTypesException e) {
            throw new FieldBuildException(e);
        }
        return field;
    }

    public FieldBuilder withShips(List<List<CellCoordinate>> ships) {
        this.ships = ships;
        return this;
    }

    private void checkShipTypes() throws WrongShipsTypesException {
        final var decks = new HashMap<Integer, Integer>();
        ships.stream()
                .map(shipCoordinates -> shipCoordinates.size())
                .forEach(deckCount -> {
                    if (decks.containsKey(deckCount)) {
                        decks.put(deckCount, decks.get(deckCount) + 1);
                    } else {
                        decks.put(deckCount, 1);
                    }
                });
        if (decks.size() != 5 || decks.get(1) != 5 || decks.get(2) != 4 || decks.get(3) != 3 || decks.get(4) != 2 || decks.get(5) != 1) {
            throw new WrongShipsTypesException();
        }
    }

    private void checkLocation() {
//        for (List<CellCoordinate> ship : ships) {
//            for (CellCoordinate coordinate : ship) {
//                coordinate.getCol()
//            }
//        }
    }

    private void checkShipsInLine() throws ShipIsNotLinearException {
        for (List<CellCoordinate> ship : ships) {
            final var colsIdentical = ship.stream()
                    .map(value -> value.getCol())
                    .collect(new IsIdenticalCollector());

            final var rowsIdentical = ship.stream()
                    .map(value -> value.getRow())
                    .collect(new IsIdenticalCollector());

            if (!(colsIdentical || rowsIdentical)) {
                throw new ShipIsNotLinearException(ship);
            }
        }
    }

    private void checkShipsCount() throws ShipCountMismatchException {
        if (ships.size() != 15) {
            throw new ShipCountMismatchException();
        }
    }

    private void fillWithClearCells(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j, CellStatus.CLEAR);
            }
        }
    }

}

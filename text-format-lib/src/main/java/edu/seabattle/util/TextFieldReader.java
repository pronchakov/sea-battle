package edu.seabattle.util;

import edu.seabattle.game.entity.Cell;
import edu.seabattle.game.entity.CellStatus;
import edu.seabattle.game.entity.Field;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class TextFieldReader {

    public static Field parse(String textField) throws WrongFieldFormatException {
        final var cells = new Cell[10][10];

        final var tmp = Arrays.asList(textField.split("\\r?\\n"));
        final var lines = new ArrayList<String>();
        lines.addAll(tmp);

        validate(lines);

        lines.remove(0);
        lines.remove(0);
        for (int i = 10; i < lines.size(); i++) {
            lines.remove(i);
        }



        for (int i = 0; i < lines.size() - 1; i++) {
            final var line = StringUtils.substringBetween(lines.get(i), "| ", " |").toCharArray();

            int currentCellIndex = 1;
            int currentCharsIndex = 0;
            int indexIncrement = 3;

            do {
                final var prefix = line[currentCellIndex - 1];
                final var suffix = line[currentCellIndex + 1];
                final var value = line[currentCellIndex];

                if (prefix == ' ' && value == ' ' && suffix == ' ') {
                    cells[i][currentCharsIndex] = new Cell(currentCharsIndex, i - 2, CellStatus.CLEAR);
                } else if (prefix == '[' && value == ' ' && suffix == ']') {
                    cells[i][currentCharsIndex] = new Cell(currentCharsIndex, i - 2, CellStatus.DECK_ALIVE);
                } else if (value == '•') {
                    cells[i][currentCharsIndex] = new Cell(currentCharsIndex, i - 2, CellStatus.MISSED);
                } else if (prefix == '[' && value == '⨯' && suffix == ']') {
                    cells[i][currentCharsIndex] = new Cell(currentCharsIndex, i - 2, CellStatus.DECK_INJURED);
                } else {
                    throw new WrongFieldFormatException();
                }

                currentCellIndex += indexIncrement;
                currentCharsIndex++;
            } while (currentCharsIndex < 10);
        }
        return new Field(cells);
    }

    private static void validate(ArrayList<String> list) throws WrongFieldFormatException {
        if (
                list.get(1).charAt(3) != '┌' ||
                list.get(1).charAt(36) != '┐' ||
                list.get(12).charAt(3) != '└' ||
                list.get(12).charAt(36) != '┘'
        ) {
            throw new WrongFieldFormatException();
        }

        final var startBracketCount = list.stream()
                .map(s -> s.chars()
                        .filter(c -> c == '[')
                        .count()
                ).mapToLong(Long::longValue).sum();


        final var endBracketCount = list.stream()
                .map(s -> s.chars()
                        .filter(c -> c == ']')
                        .count()
                ).mapToLong(Long::longValue).sum();

        if (startBracketCount != endBracketCount || startBracketCount != 35) {
            throw new WrongFieldFormatException();
        }
    }
}

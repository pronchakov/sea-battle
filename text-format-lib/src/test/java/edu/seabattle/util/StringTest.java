package edu.seabattle.util;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @Test
    public void testBetween() {
        final var between = StringUtils.substringBetween("1  | [ ][ ]   [ ]      [ ][ ][ ][ ] |", "| ", " |");
        assertEquals("[ ][ ]   [ ]      [ ][ ][ ][ ]", between);
    }

    @Test
    public void testTest() throws WrongFieldFormatException {
        TextFieldReader.parse("""
                      A  B  C  D  E  F  G  H  I  J
                   ┌────────────────────────────────┐
                1  | [ ][ ]   [ ]      [ ][ ][ ][ ] |
                2  |          [X]                   |
                3  | [ ]      [ ]   [ ][ ][ ]   [ ] |
                4  | [ ]    •                   [ ] |
                5  | [ ] • [ ] •          [ ]       |
                6  | [ ]    •       [ ]    •    [X] |
                7  |        •       [ ]         [X] |
                8  | [X][X]   [ ]               [ ] |
                9  |  •  •                          |
                10 | [ ]   [ ]   [ ][ ][ ][ ][ ]    |
                   └────────────────────────────────┘
                """);
    }

}

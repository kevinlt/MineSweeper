package fr.sawox;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * .*.**.
 * ....*.
 * ..*...
 * La fonction minesweeper doit renvoyer la chaîne de caractère suivante :
 *
 * 1*2**2
 * 1234*2
 * 01*211
 */
public class MineSweeperTest0401 {


    String minesweeper(String map) {
        map = map.replaceAll("\\*\\.\\*", "*2*");
        map = map.replaceAll("\\.\\*", "1*");
        map = map.replaceAll("\\*\\.", "*1");
        String[] rows = map.split("\n");
        if (rows[0].equals(".") && rows[1].equals("*")) {
            rows[0] = "1";
        }
        if (rows[1].equals(".") && rows[0].equals("*")) {
            rows[1] = "1";
        }
        return Arrays.stream(rows).collect(Collectors.joining("\n"));
    }

    @Test
    public void shouldReturnAString() {
        assertNotNull(minesweeper(".*.**.\n....*.\n..*..."));
    }

    @Test
    public void shouldReturStarIfMapContainsOnlyAStar() {
        assertEquals(minesweeper("*"),"*");
    }

    @Test
    public void shouldReturn1StarIfFirstCaseIsFollowedByAStar() {
        assertEquals(minesweeper(".*"), "1*");
    }

    @Test
    public void shouldReturnStar1IfSecondCaseIsPrecededByAStar() {
        assertEquals(minesweeper("*."), "*1");
    }

    @Test
    public void shouldReturn2IfCasIsBetween2Stars() {
        assertEquals(minesweeper("*.*"), "*2*");
    }

    @Test
    public void shouldReturn1IfCaseIsAboveAStar() {
        assertEquals(minesweeper(".\n*"), "1\n*");
    }

    @Test
    public void shouldReturn1IfCaseIsBelowAStar() {
        assertEquals(minesweeper("*\n."), "*\n1");
    }

}

package fr.sawox;

import org.junit.Test;

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
        map = map.replaceAll("\\.\\*", "1*");
        map = map.replaceAll("\\*\\.", "*1");
        return map;
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

}

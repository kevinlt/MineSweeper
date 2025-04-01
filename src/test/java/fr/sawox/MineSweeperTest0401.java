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
        map = map.replaceAll("\\.", "0");
        String[] rows = map.split("\n");
        for (int i=0;i<rows.length;i++) {
            if (rows.length == 1) {
                String[] chars = rows[i].split("");
                for (int j=0;j<chars.length;j++) {
                    if (!chars[j].equals("*")) {
                        if (j >0 && chars[j-1].equals("*")) {
                            chars[j] = String.valueOf(Integer.parseInt(chars[j])+1);
                        }
                        if (j < chars.length-1 && chars[j+1].equals("*")) {
                            chars[j] = String.valueOf(Integer.parseInt(chars[j])+1);
                        }
                    }
                }
                rows[i] = String.join("", chars);
            }
        }
        if (rows.length > 2) {
            if (rows[1].equals("0") && rows[0].equals("*") && rows[2].equals("*")) {
                rows[1] = "2";
            }
        }
        if (rows.length > 1) {
            if (rows[0].equals("0") && rows[1].equals("*")) {
                rows[0] = "1";
            }
            if (rows[0].equals("*") && rows[1].equals("0")) {
                rows[1] = "1";
            }
        }

        map = String.join("\n", rows);
        return map.replaceAll("0", ".");
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

    @Test
    public void shouldReturn2IfStarsAreAboveAndBelowCase() {
        assertEquals(minesweeper("*\n.\n*"), "*\n2\n*");
    }

}

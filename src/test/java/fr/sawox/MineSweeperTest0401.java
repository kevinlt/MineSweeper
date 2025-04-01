package fr.sawox;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
        return "";
    }

    @Test
    public void shouldReturnAString() {
        assertNotNull(minesweeper(".*.**.\n....*.\n..*..."));
    }

}

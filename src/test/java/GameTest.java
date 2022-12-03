import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {


    Game game = new Game();
    Player player = new Player(1, "Biba", 100);
    Player player1 = new Player(2, "Boba", 1000);
    Player player2 = new Player(3, "Pupa", 10);
    Player player3 = new Player(4, "Lupa", 10);

    @BeforeEach
    public void setup() {
        game.registers(player);
        game.registers(player1);
        game.registers(player2);
        game.registers(player3);
    }

    @Test
    void shouldWin() {
        int expected = 1;
        int actual = game.round("Boba", "Biba");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldLose() {
        int expected = 2;
        int actual = game.round("Pupa", "Biba");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldTie() {
        int expected = 0;
        int actual = game.round("Pupa", "Lupa");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldTrowException1() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Lelik", "Biba");
        });
    }

    @Test
    void shouldTrowException2() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Biba", "Bolik");
        });
    }
}

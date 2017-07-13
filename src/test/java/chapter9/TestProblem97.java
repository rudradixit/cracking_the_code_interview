package chapter9;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestProblem97 {
    @Test
    public void test3By3() {
        String[][] screen = new String[3][3];
        screen[0] = new String[]{"white", "white", "white"};
        screen[1] = new String[]{"white", "white", "white"};
        screen[2] = new String[]{"white", "white", "white"};
        String[][] updatedScreen = Problem97.fill(screen, new Point(0, 0), "black");
        String[][] expectedScreen = new String[3][3];
        expectedScreen[0] = new String[]{"black", "black", "black"};
        expectedScreen[1] = new String[]{"black", "black", "black"};
        expectedScreen[2] = new String[]{"black", "black", "black"};
        assertArrayEquals(expectedScreen, updatedScreen);
    }

    @Test
    public void test4By4() {
        String[][] screen = new String[4][4];
        screen[0] = new String[]{"red", "white", "white", "white"};
        screen[1] = new String[]{"red", "white", "red",   "white"};
        screen[2] = new String[]{"red", "white", "white", "white"};
        screen[3] = new String[]{"red", "red",   "red",   "red"};
        String[][] updatedScreen = Problem97.fill(screen, new Point(0, 3), "black");
        String[][] expectedScreen = new String[4][4];
        expectedScreen[0] = new String[]{"red", "black", "black", "black"};
        expectedScreen[1] = new String[]{"red", "black", "red",   "black"};
        expectedScreen[2] = new String[]{"red", "black", "black", "black"};
        expectedScreen[3] = new String[]{"red", "red",   "red",   "red"};
        assertArrayEquals(expectedScreen, updatedScreen);
    }
}
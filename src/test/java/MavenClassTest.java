import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class MavenClassTest {

    @Test
    void add() {
        MavenClass mavenClass = new MavenClass();
        int expected = 6;
        int actual = mavenClass.add(3, 3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void add2() {
        MavenClass mavenClass = new MavenClass();
        boolean thrown = false;
        try {
            mavenClass.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } catch (ArithmeticException exception) {
           thrown = true;
        }
        Assertions.assertEquals(true, thrown);

    }


}
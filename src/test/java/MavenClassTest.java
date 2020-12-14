import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class MavenClassTest {

    @Test
    void testAdd() {
        MavenClass mavenClass = new MavenClass();
        int expected = 6;
        int actual = mavenClass.add(3, 3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testAdd2() {
        MavenClass mavenClass = new MavenClass();
        boolean thrown = false;
        try {
            mavenClass.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } catch (ArithmeticException exception) {
           thrown = true;
        }
        Assertions.assertEquals(true, thrown);
    }

    @Test
    // different way of testing for exceptions
    void testAdd3() {
        MavenClass mavenClass = new MavenClass();
        Assertions.assertThrows(ArithmeticException.class, () -> mavenClass.add(Integer.MAX_VALUE, Integer.MAX_VALUE),
                "Overflow should throw arith exception.");
    }


}
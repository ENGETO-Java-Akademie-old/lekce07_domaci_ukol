import org.junit.jupiter.api.*;

// Notes
// BeforeAll and AfterAll methods has to be static, because they are run before the instance of class is created
// Instances are created for every @Test and terminated afterwards
// Annotations: @DisplayName("Name of test") to give names to tests instead default method name
// @Disabled - skips the test
// @EnabledOnOs(OS.LINUX) - test runs only on specific OS ; @EnabledOnJRE(JRE.JAVA_11) specific JRE version
// assumeTrue(value); Hey Junit, dont continue running the test if the assumption is not true (ex: server has to be online)
class MavenClassTest {
    MavenClass mavenClass;

    @BeforeEach
    void init() {
        mavenClass = new MavenClass();
    }
    @Test
    @DisplayName("Testing add class with small values.")
    void testAdd() {
        int expected = 6;
        int actual = mavenClass.add(3, 3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testAdd2() {
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
        Assertions.assertThrows(ArithmeticException.class, () -> mavenClass.add(Integer.MAX_VALUE, Integer.MAX_VALUE),
                "Overflow should throw arith exception.");
    }

    @Test
    @Disabled
    void testSkipped() {
        Assertions.assertThrows(ArithmeticException.class, () -> mavenClass.add(Integer.MAX_VALUE, Integer.MAX_VALUE),
                "Overflow should throw arith exception.");
    }

}
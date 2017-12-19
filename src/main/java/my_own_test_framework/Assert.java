package my_own_test_framework;

/**
 * @author Evgeny Borisov
 */
public class Assert {
    public static void assertEquals(Object expected, Object real) {
        if (!expected.equals(real)) {
            throw new RuntimeException("expected: " + expected + " real: " + real);
        }
    }
}

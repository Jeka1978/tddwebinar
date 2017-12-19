package my_own_test_framework;

/**
 * @author Evgeny Borisov
 */
public class Maven {
    public static void main(String[] args) throws Exception {
        TestRunner testRunner = new TestRunner();
        testRunner.runTests("my_own_test_framework.TestClass");
    }
}

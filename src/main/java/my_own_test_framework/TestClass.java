package my_own_test_framework;

/**
 * @author Evgeny Borisov
 */
public class TestClass {
    public void test1(){
        Assert.assertEquals(2.0, Math.sqrt(4));
        System.out.println(1111111);
    }

    public void test2() {
        System.out.println(22222);
    }
    public void setUp() {
        System.out.println();
    }
}

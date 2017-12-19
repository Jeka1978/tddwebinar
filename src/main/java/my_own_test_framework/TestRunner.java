package my_own_test_framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class TestRunner {
    public void runTests(String testClassName) throws Exception {
        Class<?> testClass = Class.forName(testClassName);
        Method[] methods = testClass.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("test")) {
                Object testObject = testClass.newInstance();
                try {
                    method.invoke(testObject);
                } catch (Exception e) {
                    System.out.println("test "+testClassName+" was failed");
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

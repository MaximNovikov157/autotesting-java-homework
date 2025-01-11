package Task2;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class TestMethodListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        Method testMethod = method.getTestMethod().getConstructorOrMethod().getMethod();
        TestMethodInfo testMethodInfo = testMethod.getAnnotation(TestMethodInfo.class);

        if (testMethodInfo != null) {
            System.out.println("Информация о тесте:");
            System.out.println("Приоритет: " + testMethodInfo.priority());
            System.out.println("Автор: " + testMethodInfo.author());
            System.out.println("Дата последнего изменения: " + testMethodInfo.lastModified());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }
}
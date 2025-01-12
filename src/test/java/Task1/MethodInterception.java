package Task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MethodInterception {
    @Test
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        Assertions.assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        Assertions.assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    private MainPage createPage(Class clazz) {
        return (MainPage) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new MainPageInvocationHandler()
        );
    }

    private static class MainPageInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            Selector selector = method.getAnnotation(Selector.class);
            if (selector != null) {
                return selector.xpath();
            }
            return null;
        }
    }
}
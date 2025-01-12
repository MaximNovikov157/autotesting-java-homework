package Task2;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
    public void annotation() {
        System.out.println("Тест выполнен.");
        assertEquals(1, 1);
    }
}
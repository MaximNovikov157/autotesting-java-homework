package Task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestMethodInfo {
    Priority priority() default Priority.Major;
    String author() default "Bill Gates";
    String lastModified() default "01.01.2019";
}
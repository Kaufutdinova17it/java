package annotations;

import java.lang.annotation.*;

/**
 * Аннотация с двумя обязательными свойствами: строка и число.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    String first();
    int second();
}

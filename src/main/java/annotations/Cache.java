package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация @Cache задаёт список кешируемых областей.
 * Если массив пуст — кеширование считается отключённым.
 */
@Retention(RetentionPolicy.RUNTIME) // аннотация доступна во время выполнения
@Target(ElementType.TYPE)           // можно ставить только на классы
public @interface Cache {

    /**
     * Список кешируемых областей.
     * Значение по умолчанию — пустой массив.
     */
    String[] value() default {};
}

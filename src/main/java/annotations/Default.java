package annotations;

import java.lang.annotation.*;

/**
 * Аннотация, задающая тип по умолчанию для класса или поля.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    Class<?> value();
}

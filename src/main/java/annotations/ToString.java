package annotations;

import java.lang.annotation.*;

/**
 * Аннотация, управляющая тем, какие поля включаются в строковое представление объекта.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {

    /** Режим включения поля в toString. */
    enum Mode { YES, NO }

    /** Значение по умолчанию — YES. */
    Mode value() default Mode.YES;
}

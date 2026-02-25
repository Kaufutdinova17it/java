package annotations;

import java.lang.annotation.*;

/**
 * Аннотация, содержащая список классов для проверки.
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    Class<?>[] value();
}

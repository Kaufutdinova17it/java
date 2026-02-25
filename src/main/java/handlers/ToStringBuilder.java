package handlers;

import annotations.ToString;
import java.lang.reflect.Field;

/**
 * Генератор строкового представления объекта на основе @ToString.
 */
public class ToStringBuilder {

    /**
     * Формирует строку, включая только поля с @ToString(YES) или без аннотации.
     *
     * @param obj объект
     * @return строковое представление
     */
    public String build(Object obj) {
        StringBuilder sb = new StringBuilder(obj.getClass().getSimpleName()).append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            ToString annotation = field.getAnnotation(ToString.class);
            boolean include = annotation == null || annotation.value() == ToString.Mode.YES;

            if (include) {
                field.setAccessible(true);
                try {
                    sb.append(field.getName()).append("=").append(field.get(obj)).append(", ");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (sb.toString().endsWith(", ")) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("}");
        return sb.toString();
    }
}

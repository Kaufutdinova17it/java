
import java.util.*;
import java.util.function.Supplier;

public class GenericUtils {

    // 4.1 Функция - преобразование списка
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    // 4.2 Фильтр - фильтрация списка
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // 4.3 Сокращение - свертка списка
    public static <T> T reduce(List<T> list, BinaryOperator<T> operator, T identity) {
        if (list == null || list.isEmpty()) {
            return identity;
        }

        T result = identity;
        for (T item : list) {
            result = operator.apply(result, item);
        }
        return result;
    }

    // 4.4 Коллекционирование - группировка элементов
    public static <T, R> R collect(List<T> list, Supplier<R> supplier, java.util.function.BiConsumer<R, T> accumulator) {
        R result = supplier.get();
        for (T item : list) {
            accumulator.accept(result, item);
        }
        return result;
    }
}
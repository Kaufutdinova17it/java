import java.util.*;
import java.util.function.Supplier;

public class GenericUtils {

    // 3.1 Функция - преобразование списка
    //возьми каждый элемент и преврати его вот так
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        //Итерируем по каждому элементу исходного списка
        for (T item : list) {
            //add функция добавления элемента в конец списка
            result.add(function.apply(item));
            //Применяем функцию к текущему элементу и добавляем результат в новый список result
        }
        return result;
    }

    // 3.2 Фильтр - фильтрация списка
    //перебирает элементы списка и оставляет только те, для которых переданный предикат возвращает true
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            // Если условие истинно, добавляем элемент в результат
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // 3.3 Сокращение - свертка списка
    //берёт начальное значение и последовательно накапливает результат
    public static <T> T reduce(List<T> list, BinaryOperator<T> operator, T identity) {
        if (list == null || list.isEmpty()) {
            //возвращаем изначальное значение
            return identity;
        }

        T result = identity;
        for (T item : list) {
            result = operator.apply(result, item);
            //  Применяем оператор к текущему результату и следующему элементу
            //  Обновляем аккумулятор
        }
        return result;
    }

    // 3.4 Коллекционирование - группировка элементов
    public static <T, R> R collect(List<T> list, Supplier<R> supplier, java.util.function.BiConsumer<R, T> accumulator) {
        //  Объявление метода: T - тип элементов, R - тип коллектора

        R result = supplier.get();
        //  Создаём объект-коллектор с помощью Supplier(Не принимает параметров, возвращает объект типа T)


        for (T item : list) {
              accumulator.accept(result, item);
            //  Добавляем текущий элемент в коллектор
            //   BiConsumer принимает коллектор и элемент, модифицирует коллектор
        }
        return result;
        //  Возвращаем заполненный коллектор
    }
}
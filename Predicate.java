
@FunctionalInterface
public interface Predicate<T> {
    //проверяем условие для объекта t, возвращает true или false
    boolean test(T t);
}
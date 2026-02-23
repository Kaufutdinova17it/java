
@FunctionalInterface
public interface Function<T, R> {
    //принимает объект типа T а возвращает тип R
    R apply(T t);
}
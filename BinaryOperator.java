
@FunctionalInterface
public interface BinaryOperator<T> {
    //выполняем одну операцию сразу для двух объектов
    T apply(T t1, T t2);
}
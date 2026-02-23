//НЕ ЗАБУДЬ!!!! буквы в скобочках <T> называются дженерики
public class Box<T> {
    private T item;

    public Box() {
        this.item = null;
    }

    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.item = item;
    }

    public T get() {
        T temp = item;
        item = null;
        return temp;
    }

    public boolean isEmpty() {
        return item == null;
    }

    @Override
    public String toString() {
        return "Коробка{item=" + item + ", Коробка пустая?=" + isEmpty() + '}';
    }
}
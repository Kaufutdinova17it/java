

import static org.junit.Assert.assertEquals;

import annotations.Cache;
import org.junit.Test;

/**
 * Тест проверяет, что при отсутствии областей массив пуст.
 */
public class EmptyCacheTest {

    @Cache // аннотация без параметров → пустой массив
    class EmptyCacheDemo {}

    @Test
    public void emptyCacheMeansNoCaching() {
        Cache cache = EmptyCacheDemo.class.getAnnotation(Cache.class);
        assertEquals(0, cache.value().length);
    }
}

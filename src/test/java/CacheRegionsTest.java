
import static org.junit.Assert.assertArrayEquals;

import annotations.Cache;
import model.CacheDemo;
import org.junit.Test;

/**
 * Тест проверяет, что массив кешируемых областей читается корректно.
 */
public class CacheRegionsTest {

    @Test
    public void cacheRegionsAreReadCorrectly() {
        Cache cache = CacheDemo.class.getAnnotation(Cache.class);
        String[] expected = {"users", "products", "sessions"};
        assertArrayEquals(expected, cache.value());
    }
}

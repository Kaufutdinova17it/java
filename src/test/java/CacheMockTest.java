

import static org.junit.Assert.assertEquals;

import model.CacheDemo;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Мок-тест имитирует работу кеша.
 * Метод loadData() подменяется и возвращает "cached-value".
 */
public class CacheMockTest {

    @Test
    public void mockCacheReturnsCachedValue() {
        // Создаём мок-объект
        CacheDemo demo = Mockito.mock(CacheDemo.class);

        // Подменяем поведение метода
        Mockito.when(demo.loadData()).thenReturn("cached-value");

        // Проверяем результат
        String result = demo.loadData();
        assertEquals("cached-value", result);

        // Проверяем, что метод был вызван
        Mockito.verify(demo).loadData();
    }
}

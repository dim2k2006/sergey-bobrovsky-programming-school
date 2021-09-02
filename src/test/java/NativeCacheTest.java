import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NativeCacheTest {
  @Nested
  @DisplayName("put method")
  class PutMethod {
    @Test
    @DisplayName("Should put value to the cache")
    void shouldPutValueToTheCache() {
      Faker faker = new Faker();
      NativeCache<String> cache = new NativeCache<String>(20);

      cache.put("key1", faker.lorem().word());
      cache.put("key2", faker.lorem().word());
      cache.put("key3", faker.lorem().word());

      Assertions.assertEquals(3, cache.size());
      Assertions.assertEquals(3, cache.hits.size());
    }

    @Test
    @DisplayName("Should replace value with low hits value with new value")
    void shouldReplaceValueWithLowHitsValueWithNewValue() {
      NativeCache<String> cache = new NativeCache<String>(3);

      String key1 = "key1";
      String key2 = "key2";
      String key3 = "key3";
      String key4 = "key4";

      String value1 = "value1";
      String value2 = "value2";
      String value3 = "value3";
      String value4 = "value4";

      cache.put(key1, value1);
      cache.put(key2, value2);
      cache.put(key3, value3);

      cache.get(key1);
      cache.get(key1);
      cache.get(key1);

      cache.get(key2);
      cache.get(key2);

      cache.get(key3);

      cache.put(key4, value4);

      Assertions.assertEquals(3, cache.size());
      Assertions.assertNull(cache.get(key3));
      Assertions.assertEquals(0, cache.getHitsByKey(key4));
      Assertions.assertEquals(value4, cache.get(key4));
      Assertions.assertEquals(1, cache.getHitsByKey(key4));
    }
  }

  @Nested
  @DisplayName("get method")
  class GetMethod {
    @Test
    @DisplayName("Should get value from the cache")
    void shouldGetValueFromTheCache() {
      Faker faker = new Faker();
      NativeCache<String> cache = new NativeCache<String>(20);

      String key = "key1";

      cache.put(key, faker.lorem().word());

      Assertions.assertEquals(0, cache.getHitsByKey(key));

      cache.get(key);

      Assertions.assertEquals(1, cache.getHitsByKey(key));

      cache.get(key);

      Assertions.assertEquals(2, cache.getHitsByKey(key));
    }
  }
}



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

      cache.get(key);

      Assertions.assertEquals(1, cache.getHitsByKey(key));

      cache.get(key);

      Assertions.assertEquals(2, cache.getHitsByKey(key));
    }
  }
}



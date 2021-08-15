import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NativeDictionaryTest {
  @Nested
  @DisplayName("put method")
  class PutFun {
    @Test
    @DisplayName("Should put value into dictionary")
    void shouldPutValueIntoDictionary() {
      NativeDictionary<Integer> dictionary = new NativeDictionary<Integer>(20, Integer.class);
      Faker faker = new Faker();

      String key = faker.lorem().word();
      int value = (int) faker.number().numberBetween(0, 100);

      dictionary.put(key, value);

      Assertions.assertEquals(value, dictionary.get(key));
    }

    @Test
    @DisplayName("Should replace value in dictionary")
    void shouldReplaceValueInDictionary() {
      NativeDictionary<Integer> dictionary = new NativeDictionary<Integer>(20, Integer.class);
      Faker faker = new Faker();

      String key = faker.lorem().word();
      int value1 = (int) faker.number().numberBetween(0, 100);
      int value2 = (int) faker.number().numberBetween(0, 100);

      dictionary.put(key, value1);

      Assertions.assertEquals(value1, dictionary.get(key));

      dictionary.put(key, value2);

      Assertions.assertEquals(value2, dictionary.get(key));
    }
  }
}

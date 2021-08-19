import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PowerSetTest {
  @Nested
  @DisplayName("size method")
  class SizeMethod {
    @Test
    @DisplayName("Should return size of set")
    void shouldReturnSizeOfSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      Assertions.assertEquals(0, set.size());

      set.put(faker.lorem().word());
      set.put(faker.lorem().word());
      set.put(faker.lorem().word());

      Assertions.assertEquals(3, set.size());
    }
  }

  @Nested
  @DisplayName("put method")
  class PutMethod {
    @Test
    @DisplayName("Should put item to set")
    void shouldPutItemToSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      Assertions.assertEquals(0, set.size());

      set.put(faker.lorem().word());

      Assertions.assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Should not create duplicates in set")
    void shouldNotCreateDuplicatesInSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      String value = faker.lorem().word();

      Assertions.assertEquals(0, set.size());

      set.put(value);
      set.put(value);

      Assertions.assertEquals(1, set.size());
    }
  }
}

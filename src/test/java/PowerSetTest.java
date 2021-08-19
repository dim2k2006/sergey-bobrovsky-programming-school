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

  @Nested
  @DisplayName("remove method")
  class RemoveMethod {
    @Test
    @DisplayName("Should remove item from set")
    void shouldRemoveItemFromSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      String value = faker.lorem().word();

      Assertions.assertEquals(0, set.size());

      set.put(value);

      Assertions.assertEquals(1, set.size());
      Assertions.assertNotEquals(-1, set.find(value));

      Assertions.assertTrue(set.remove(value));
      Assertions.assertEquals(0, set.size());
      Assertions.assertEquals(-1, set.find(value));
    }

    @Test
    @DisplayName("Should not remove not existing item from set")
    void shouldNotRemoveNotExistingItemFromSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      String value1 = faker.lorem().word();
      String value2 = faker.lorem().word();

      set.put(value1);

      set.remove(value2);

      Assertions.assertEquals(1, set.size());
      Assertions.assertTrue(set.get(value1));
      Assertions.assertFalse(set.get(value2));
    }
  }
}

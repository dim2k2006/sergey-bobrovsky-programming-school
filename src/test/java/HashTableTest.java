import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class HashTableTest {
  @Nested
  @DisplayName("hashFun method")
  class HashFun {
    @Test
    @DisplayName("Should return different indexes for different strings")
    void shouldReturnDifferentIndexesForDifferentStrings() {
      HashTable table = new HashTable(19, 3);

      Assertions.assertNotEquals(table.hashFun("hello world!"), table.hashFun("alloy world!"));
      Assertions.assertEquals(table.hashFun("hello world!"), table.hashFun("hello world!"));
    }
  }

  @Nested
  @DisplayName("put method")
  class Put {
    @Test
    @DisplayName("Should put value into slot")
    void shouldPutValueIntoSlot() {
      HashTable table = new HashTable(19, 3);

      int slot = table.put("hello world!");

      Assertions.assertNotEquals(-1, slot);
    }

    @Test
    @DisplayName("Should find another slot if the original slot is ocupied")
    void shouldFindAnotherSlotIfTheOriginalSlotIsOcupied() {
      HashTable table = new HashTable(19, 3);

      int slot1 = table.put("hello world!");
      int slot2 = table.put("hello world!");

      Assertions.assertNotEquals(-1, slot1);
      Assertions.assertNotEquals(-1, slot2);
      Assertions.assertNotEquals(slot1, slot2);
    }

    @Test
    @DisplayName("Should return -1 if there is no empty slot")
    void shouldReturnIfThereIsNoEmptySlot() {
      HashTable table = new HashTable(3, 3);

      int slot1 = table.put("hello world!");
      int slot2 = table.put("hello world!");
      int slot3 = table.put("hello world!");

      int slot = table.put("hello world!");

      Assertions.assertNotEquals(-1, slot1);
      Assertions.assertNotEquals(-1, slot2);
      Assertions.assertNotEquals(-1, slot3);
      Assertions.assertEquals(-1, slot);
    }
  }

  @Nested
  @DisplayName("find method")
  class Find {
    @Test
    @DisplayName("Should find value")
    void shouldFindValue() {
      Faker faker = new Faker();
      HashTable table = new HashTable(19, 3);

      String value = faker.lorem().word();

      int putSlot = table.put(value);

      Assertions.assertNotEquals(-1, putSlot);

      int findSlot = table.find(value);

      Assertions.assertEquals(putSlot, findSlot);
    }

    @Test
    @DisplayName("Should not find value")
    void shouldNotFindValue() {
      Faker faker = new Faker();
      HashTable table = new HashTable(19, 3);

      String value1 = faker.lorem().word();
      String value2 = faker.lorem().word();

      int putSlot = table.put(value1);

      Assertions.assertNotEquals(-1, putSlot);

      int findSlot = table.find(value2);

      Assertions.assertEquals(-1, findSlot);
    }
  }
}

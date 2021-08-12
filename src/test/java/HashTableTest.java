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
}

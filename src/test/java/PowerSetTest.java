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
      PowerSet set = new PowerSet();

      Assertions.assertEquals(0, set.size());

      set.put("a");
      set.put("b");
      set.put("c");

      Assertions.assertEquals(3, set.size());
    }
  }
}

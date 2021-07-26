import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OrderedListTest {
  @Nested
  @DisplayName("compare method")
  class CompareMethod {
    @Test
    @DisplayName("Should return correct values")
    void shouldReturnCorrectValues() {
      OrderedList<Integer> list = new OrderedList<Integer>(true);

      Assertions.assertEquals(-1, list.compare(1, 2));
      Assertions.assertEquals(0, list.compare(1, 1));
      Assertions.assertEquals(1, list.compare(2, 1));
    }
  }
}

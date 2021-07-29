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

  @Nested
  @DisplayName("add method")
  class AddMethod {
    @Test
    @DisplayName("Should add node to the correct position asc")
    void shouldAddNodeToTheCorrectPositionAsc() {
      OrderedList<Integer> list = new OrderedList<Integer>(true);

      list.add(1);

      Assertions.assertEquals(1, list.count());

      list.add(2);

      Assertions.assertEquals(2, list.count());

      list.add(3);

      Assertions.assertEquals(3, list.count());

      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(2, list.head.next.value);
      Assertions.assertEquals(3, list.head.next.next.value);
    }
  }
}

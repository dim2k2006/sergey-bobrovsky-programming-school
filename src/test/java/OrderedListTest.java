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
      OrderedList<Integer> list1 = new OrderedList<Integer>(true);

      Assertions.assertEquals(-1, list1.compare(1, 2));
      Assertions.assertEquals(0, list1.compare(1, 1));
      Assertions.assertEquals(1, list1.compare(2, 1));

      OrderedList<String> list2 = new OrderedList<String>(true);

      Assertions.assertEquals(-1, list2.compare("Adam", "Bill"));
      Assertions.assertEquals(0, list2.compare("Adam", "Adam"));
      Assertions.assertEquals(1, list2.compare("Bill", "Adam"));
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
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertNull(list.head.next);
      Assertions.assertEquals(1, list.tail.value);
      Assertions.assertNull(list.tail.prev);
      Assertions.assertNull(list.tail.next);

      list.add(2);

      Assertions.assertEquals(2, list.count());
      Assertions.assertEquals(2, list.head.next.value);
      Assertions.assertEquals(2, list.tail.value);
      Assertions.assertEquals(1, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);

      list.add(6);

      Assertions.assertEquals(3, list.count());
      Assertions.assertEquals(6, list.head.next.next.value);
      Assertions.assertEquals(6, list.tail.value);
      Assertions.assertEquals(2, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);

      list.add(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertEquals(4, list.head.next.next.value);
      Assertions.assertEquals(6, list.tail.value);
      Assertions.assertEquals(4, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);

      list.add(5);

      Assertions.assertEquals(5, list.count());
      Assertions.assertEquals(5, list.head.next.next.next.value);
      Assertions.assertEquals(6, list.tail.value);
      Assertions.assertEquals(5, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }
  }
}

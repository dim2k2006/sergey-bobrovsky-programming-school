import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class LinkedListTest {
  @Nested
  @DisplayName("count method")
  class CountMethod {
    @Test
    @DisplayName("Should generate empty linked list")
    void shouldGenerateEmptyLinkedList() {
      LinkedList list = new LinkedList();

      Assertions.assertEquals(0, list.count());
    }

    @Test
    @DisplayName("Should generate not empty linked list")
    void shouldGenerateNotEmptyLinkedList() {
      LinkedList list = new LinkedList();

      Random rd = new Random();

      int upperbound = 100;

      int[] arr = new int[rd.nextInt(upperbound)];

      for (int i = 0; i < arr.length; i++) {
        list.addInTail(new Node(rd.nextInt(upperbound)));
      }

      Assertions.assertEquals(arr.length, list.count());
    }
  }

  @Nested
  @DisplayName("remove method")
  class RemoveMethod {
    @Test
    @DisplayName("Should remove node by value")
    void shouldRemoveNodeByValue() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(6));
      list.addInTail(new Node(18));
      list.addInTail(new Node(2));
      list.addInTail(new Node(42));

      boolean result = list.remove(18);

      Assertions.assertTrue(result);
      Assertions.assertEquals(4, list.count());
      Assertions.assertNull(list.find(18));
    }

    // удалили последний элемент

    // удалили предпоследний элемент

    // удалали первый элемент

    // список может быть пустой

    // значение может не существовать в списке
  }
}
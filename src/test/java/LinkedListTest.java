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

    @Test
    @DisplayName("Should remove last node by value")
    void shouldRemoveLastNodeByValue() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(6));
      list.addInTail(new Node(18));

      boolean result = list.remove(18);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(18));
    }

    @Test
    @DisplayName("Should remove pre last node by value")
    void shouldRemovePreLastNodeByValue() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(6));
      list.addInTail(new Node(18));

      boolean result = list.remove(6);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(6));
    }

    @Test
    @DisplayName("Should remove first node by value")
    void shouldRemoveFirstNodeByValue() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(6));
      list.addInTail(new Node(18));

      boolean result = list.remove(1);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(1));
    }

    @Test
    @DisplayName("Should not remove anything from empty list")
    void shouldNotRemoveFromEmptyList() {
      LinkedList list = new LinkedList();

      boolean result = list.remove(5);

      Assertions.assertFalse(result);
      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(5));
    }

    @Test
    @DisplayName("Should not remove not existing value")
    void shouldNotRemoveNotExistingValue() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(5));
      list.addInTail(new Node(10));

      boolean result = list.remove(15);

      Assertions.assertFalse(result);
      Assertions.assertEquals(3, list.count());
    }

    @Test
    @DisplayName("Should return empty list")
    void shouldReturnEmptyList() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));

      boolean result = list.remove(1);

      Assertions.assertTrue(result);
      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(1));
    }
  }
}
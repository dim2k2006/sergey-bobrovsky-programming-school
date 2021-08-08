import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OrderedListTest {
  public String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

  public int getListLength(Node node, Boolean inverse) {
    if (node == null) {
      return 0;
    }

    Node nextNode = inverse ? node.prev : node.next;

    return 1 + getListLength(nextNode, inverse);
  }

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

      Assertions.assertEquals(-1, list2.compare("Adam", " Bill "));
      Assertions.assertEquals(0, list2.compare(" Adam ", "Adam"));
      Assertions.assertEquals(1, list2.compare(" Bill ", " Adam    "));
    }
  }

  @Nested
  @DisplayName("add method")
  class AddMethod {
    @Test
    @DisplayName("Should create ordered numeric list asc")
    void shouldCreateOrderedNumericListAsc() {
      OrderedList<Integer> list = new OrderedList<Integer>(true);

      int upperBound = 100;

      for (int i = upperBound; i > 0; i--) {
        list.add(i);
      }

      Assertions.assertEquals(upperBound, list.count());

      ArrayList<Node<Integer>> array = list.getAll();

      int arrayLength = array.size();

      for (int i = 0; i < arrayLength - 1; i++) {
        Node<Integer> currentNode = array.get(i);
        Node<Integer> nextNode = array.get(i + 1);

        Assertions.assertTrue(currentNode.value < nextNode.value);
      }

      Assertions.assertEquals(100, getListLength(list.tail, true));
    }

    @Test
    @DisplayName("Should create ordered numeric list desc")
    void shouldCreateOrderedNumericListDesc() {
      OrderedList<Integer> list = new OrderedList<Integer>(false);

      int upperBound = 100;

      for (int i = 1; i <= 100; i++) {
        list.add(i);
      }

      Assertions.assertEquals(upperBound, list.count());

      ArrayList<Node<Integer>> array = list.getAll();

      int arrayLength = array.size();

      for (int i = 0; i < arrayLength - 1; i++) {
        Node<Integer> currentNode = array.get(i);
        Node<Integer> nextNode = array.get(i + 1);

        Assertions.assertTrue(currentNode.value > nextNode.value);
      }

      Assertions.assertEquals(100, getListLength(list.head, false));
      Assertions.assertEquals(100, getListLength(list.tail, true));
    }

    @Test
    @DisplayName("Should create ordered character list asc")
    void shouldCreateOrderedCharacterListAsc() {
      OrderedList<String> list = new OrderedList<String>(true);

      int upperBound = alphabet.length;

      for (int i = upperBound - 1; i >= 0; i--) {
        list.add(alphabet[i]);
      }

      Assertions.assertEquals(upperBound, list.count());

      ArrayList<Node<String>> array = list.getAll();

      int arrayLength = array.size();

      for (int i = 0; i < arrayLength - 1; i++) {
        Node<String> currentNode = array.get(i);
        Node<String> nextNode = array.get(i + 1);

        Assertions.assertEquals(-1, list.compare(currentNode.value, nextNode.value));
      }

      Assertions.assertEquals(26, getListLength(list.tail, true));
    }

    @Test
    @DisplayName("Should create ordered character list desc")
    void shouldCreateOrderedCharacterListDesc() {
      OrderedList<String> list = new OrderedList<String>(false);

      int upperBound = alphabet.length;;

      for (int i = 0; i < upperBound; i++) {
        list.add(alphabet[i]);
      }

      Assertions.assertEquals(upperBound, list.count());

      ArrayList<Node<String>> array = list.getAll();

      int arrayLength = array.size();

      for (int i = 0; i < arrayLength - 1; i++) {
        Node<String> currentNode = array.get(i);
        Node<String> nextNode = array.get(i + 1);

        Assertions.assertEquals(1, list.compare(currentNode.value, nextNode.value));
      }

      Assertions.assertEquals(26, getListLength(list.tail, true));
    }

    @Test
    @DisplayName("Should add nodes with same number values to the correct position asc")
    void shouldAddNodesWithSameNumberValuesToTheCorrectPositionAsc() {
      OrderedList<Integer> list = new OrderedList<Integer>(true);

      list.add(1);
      list.add(3);
      list.add(2);
      list.add(2);

      Assertions.assertEquals(4, list.count());
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(2, list.head.next.value);
      Assertions.assertEquals(2, list.head.next.next.value);
      Assertions.assertEquals(3, list.head.next.next.next.value);
    }

    @Test
    @DisplayName("Should add nodes with same number values to the correct position desc")
    void shouldAddNodesWithSameNumberValuesToTheCorrectPositionDesc() {
      OrderedList<Integer> list = new OrderedList<Integer>(false);

      list.add(1);
      list.add(3);
      list.add(2);
      list.add(2);

      Assertions.assertEquals(4, list.count());
      Assertions.assertEquals(3, list.head.value);
      Assertions.assertEquals(2, list.head.next.value);
      Assertions.assertEquals(2, list.head.next.next.value);
      Assertions.assertEquals(1, list.head.next.next.next.value);
    }

    @Test
    @DisplayName("Should add node with number value to the correct position asc")
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

    @Test
    @DisplayName("Should add node with string value to the correct position asc")
    void shouldAddNodeWithStringValueToTheCorrectPositionAsc() {
      OrderedList<String> list = new OrderedList<String>(true);

      list.add("a");

      Assertions.assertEquals(1, list.count());
      Assertions.assertEquals("a", list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertNull(list.head.next);
      Assertions.assertEquals("a", list.tail.value);
      Assertions.assertNull(list.tail.prev);
      Assertions.assertNull(list.tail.next);

      list.add("b");

      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals("a", list.head.value);
      Assertions.assertEquals("b", list.head.next.value);
      Assertions.assertEquals("b", list.tail.value);
      Assertions.assertEquals("a", list.tail.prev.value);
      Assertions.assertNull(list.tail.next);

      list.add("e");

      Assertions.assertEquals(3, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals("a", list.head.value);
      Assertions.assertEquals("b", list.head.next.value);
      Assertions.assertEquals("e", list.head.next.next.value);
      Assertions.assertEquals("e", list.tail.value);
      Assertions.assertEquals("b", list.tail.prev.value);
      Assertions.assertNull(list.tail.next);

      list.add("d");

      Assertions.assertEquals(4, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals("a", list.head.value);
      Assertions.assertEquals("b", list.head.next.value);
      Assertions.assertEquals("d", list.head.next.next.value);
      Assertions.assertEquals("e", list.head.next.next.next.value);
      Assertions.assertEquals("e", list.tail.value);
      Assertions.assertEquals("d", list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should add node with number value to the correct position desc")
    void shouldAddNodeToTheCorrectPositionDesc() {
      OrderedList<Integer> list = new OrderedList<Integer>(false);

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
      Assertions.assertEquals(2, list.head.value);
      Assertions.assertEquals(1, list.head.next.value);
      Assertions.assertEquals(1, list.tail.value);
      Assertions.assertEquals(2, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);

      list.add(6);

      Assertions.assertEquals(3, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(6, list.head.value);
      Assertions.assertEquals(2, list.head.next.value);
      Assertions.assertEquals(1, list.tail.value);
      Assertions.assertNull(list.tail.next);

      list.add(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(6, list.head.value);
      Assertions.assertEquals(4, list.head.next.value);
      Assertions.assertEquals(2, list.head.next.next.value);
      Assertions.assertEquals(1, list.head.next.next.next.value);
      Assertions.assertEquals(1, list.tail.value);
      Assertions.assertNull(list.tail.next);

      list.add(5);

      Assertions.assertEquals(5, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(6, list.head.value);
      Assertions.assertEquals(5, list.head.next.value);
      Assertions.assertEquals(1, list.tail.value);
      Assertions.assertEquals(2, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should add node with string value to the correct position desc")
    void shouldAddNodeWithStringValueToTheCorrectPositionDesc() {
      OrderedList<String> list = new OrderedList<String>(false);

      list.add("a");

      Assertions.assertEquals(1, list.count());
      Assertions.assertEquals("a", list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertNull(list.head.next);
      Assertions.assertEquals("a", list.tail.value);
      Assertions.assertNull(list.tail.prev);
      Assertions.assertNull(list.tail.next);

      list.add("b");

      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals("b", list.head.value);
      Assertions.assertEquals("a", list.head.next.value);
      Assertions.assertEquals("a", list.tail.value);
      Assertions.assertEquals("b", list.tail.prev.value);
      Assertions.assertNull(list.tail.next);

      list.add("e");

      Assertions.assertEquals(3, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals("e", list.head.value);
      Assertions.assertEquals("b", list.head.next.value);
      Assertions.assertEquals("a", list.head.next.next.value);
      Assertions.assertEquals("a", list.tail.value);
      Assertions.assertEquals("b", list.tail.prev.value);
      Assertions.assertNull(list.tail.next);

      list.add("d");

      Assertions.assertEquals(4, list.count());
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals("e", list.head.value);
      Assertions.assertEquals("d", list.head.next.value);
      Assertions.assertEquals("b", list.head.next.next.value);
      Assertions.assertEquals("a", list.head.next.next.next.value);
      Assertions.assertEquals("a", list.tail.value);
      Assertions.assertEquals("b", list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should create correct list desc")
    void shouldCreateCorrectListDesc() {
      OrderedList<Integer> list = new OrderedList<Integer>(false);

      list.add(4);

      list.add(3);
      list.add(2);
      list.add(1);

      list.add(7);
      list.add(6);
      list.add(5);

      ArrayList<Node<Integer>> array = list.getAll();

      int arrayLength = array.size();

      Assertions.assertEquals(7, arrayLength);

      for (int i = 0; i < arrayLength - 1; i++) {
        Node<Integer> currentNode = array.get(i);
        Node<Integer> nextNode = array.get(i + 1);

        Assertions.assertEquals(1, list.compare(currentNode.value, nextNode.value));
      }
    }
  }

  @Nested
  @DisplayName("find method")
  class FindMethod {
    @Test
    @DisplayName("Should find node by value")
    void shouldFindValue() {
      OrderedList<Integer> list1 = new OrderedList<Integer>(true);

      list1.add(5);
      list1.add(3);
      list1.add(6);
      list1.add(8);

      Assertions.assertEquals(5, list1.find(5).value);
      Assertions.assertEquals(6, list1.find(6).value);
      Assertions.assertEquals(8, list1.find(8).value);
      Assertions.assertNull(list1.find(10));

      OrderedList<Integer> list2 = new OrderedList<Integer>(false);

      list2.add(5);
      list2.add(3);
      list2.add(6);
      list2.add(8);

      Assertions.assertEquals(5, list2.find(5).value);
      Assertions.assertEquals(6, list2.find(6).value);
      Assertions.assertEquals(8, list2.find(8).value);
      Assertions.assertNull(list2.find(10));
    }
  }

  @Nested
  @DisplayName("delete method")
  class DeleteMethod {
    @Test
    @DisplayName("Should delete node by value")
    void shouldDeleteNodeByValue() {
      OrderedList<Integer> list1 = new OrderedList<Integer>(true);

      list1.add(5);
      list1.add(3);
      list1.add(6);
      list1.add(8);

      Assertions.assertEquals(4, list1.count());

      list1.delete(3);

      Assertions.assertEquals(3, list1.count());
      Assertions.assertEquals(5, list1.head.value);

      list1.delete(5);

      Assertions.assertEquals(2, list1.count());
      Assertions.assertEquals(6, list1.head.value);

      list1.delete(6);

      Assertions.assertEquals(1, list1.count());
      Assertions.assertEquals(8, list1.head.value);
      Assertions.assertEquals(8, list1.tail.value);

      list1.delete(8);

      Assertions.assertEquals(0, list1.count());
      Assertions.assertNull(list1.head);
      Assertions.assertNull(list1.tail);
    }
  }

  @Nested
  @DisplayName("clear method")
  class ClearMethod {
    @Test
    @DisplayName("Should clear not empty list")
    void shouldClearList() {
      OrderedList<Integer> list = new OrderedList<Integer>(true);

      list.add(1);
      list.add(2);
      list.add(3);

      list.clear(true);

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }
  }
}

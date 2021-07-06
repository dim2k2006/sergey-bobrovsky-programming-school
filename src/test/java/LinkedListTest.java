import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(42, list.tail.value);
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
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(6, list.tail.value);
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
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(18, list.tail.value);
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
      Assertions.assertEquals(6, list.head.value);
      Assertions.assertEquals(18, list.tail.value);
    }

    @Test
    @DisplayName("Should not remove anything from empty list")
    void shouldNotRemoveFromEmptyList() {
      LinkedList list = new LinkedList();

      boolean result = list.remove(5);

      Assertions.assertFalse(result);
      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(5));
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
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
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(10, list.tail.value);
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
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }
  }

  @Nested
  @DisplayName("findAll method")
  class FindAllMethod {
    @Test
    @DisplayName("Should find one node")
    void shouldFindOneNode() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));

      ArrayList<Node> result = list.findAll(1);

      Assertions.assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should find several nodes")
    void shouldFindSeveralNodes() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(5));
      list.addInTail(new Node(1));
      list.addInTail(new Node(19));
      list.addInTail(new Node(1));

      ArrayList<Node> result = list.findAll(1);

      Assertions.assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Should not find nodes in empty list")
    void shouldNotFindNodesInEmptyList() {
      LinkedList list = new LinkedList();

      ArrayList<Node> result = list.findAll(1);

      Assertions.assertEquals(0, result.size());
    }
  }

  @Nested
  @DisplayName("removeAll method")
  class RemoveAllMethod {
    @Test
    @DisplayName("Should remove one node")
    void shouldRemoveOneNode() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));

      list.removeAll(1);

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(1));
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }

    @Test
    @DisplayName("Should remove several nodes")
    void shouldRemoveSeveralNodes() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(1));
      list.addInTail(new Node(5));
      list.addInTail(new Node(10));
      list.addInTail(new Node(2));
      list.addInTail(new Node(1));
      list.addInTail(new Node(1));

      list.removeAll(1);

      Assertions.assertEquals(3, list.count());
      Assertions.assertEquals(0, list.findAll(1).size());
      Assertions.assertEquals(5, list.head.value);
      Assertions.assertEquals(2, list.tail.value);
    }

    @Test
    @DisplayName("Should return empty list")
    void shouldReturnEmptyList() {
      LinkedList list = new LinkedList();

      list.removeAll(1);

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }

    @Test
    @DisplayName("Should not remove not existing values")
    void shouldNotRemoveNotExistingValues() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(1));
      list.addInTail(new Node(5));
      list.addInTail(new Node(10));
      list.addInTail(new Node(2));
      list.addInTail(new Node(1));
      list.addInTail(new Node(1));

      list.removeAll(100);

      Assertions.assertEquals(7, list.count());
      Assertions.assertEquals(0, list.findAll(100).size());
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(1, list.tail.value);
    }
  }

  @Nested
  @DisplayName("clear method")
  class ClearMethod {
    @Test
    @DisplayName("Should clear not empty list")
    void shouldClearList() {
      LinkedList list = new LinkedList();

      list.addInTail(new Node(1));
      list.addInTail(new Node(2));
      list.addInTail(new Node(3));

      list.clear();

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }

    @Test
    @DisplayName("Should clear empty list")
    void shouldClearEmptyList() {
      LinkedList list = new LinkedList();

      list.clear();

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }
  }

  @Nested
  @DisplayName("insertAfter method")
  class InsertAfterMethod {
    @Test
    @DisplayName("Should insert node in the middle of the list")
    void shouldInsertNodeInTheMiddleOfTheList() {
      LinkedList list = new LinkedList();

      Node firstNode = new Node(1);
      Node secondNode = new Node(2);
      Node thirdNode = new Node(3);

      list.addInTail(firstNode);
      list.addInTail(secondNode);
      list.addInTail(thirdNode);

      list.insertAfter(secondNode, new Node(4));

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(list.find(4));
    }

    @Test
    @DisplayName("Should insert node after first node")
    void shouldInsertNodeAfterFirstNode() {
      LinkedList list = new LinkedList();

      Node firstNode = new Node(1);
      Node secondNode = new Node(2);
      Node thirdNode = new Node(3);

      list.addInTail(firstNode);
      list.addInTail(secondNode);
      list.addInTail(thirdNode);

      list.insertAfter(firstNode, new Node(4));

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(list.find(4));
    }

    @Test
    @DisplayName("Should insert node before first node")
    void shouldInsertNodeBeforeFirstNode() {
      LinkedList list = new LinkedList();

      Node firstNode = new Node(1);
      Node secondNode = new Node(2);
      Node thirdNode = new Node(3);

      list.addInTail(firstNode);
      list.addInTail(secondNode);
      list.addInTail(thirdNode);

      list.insertAfter(null, new Node(4));

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(list.find(4));
    }

    @Test
    @DisplayName("Should insert node to the end")
    void shouldInsertNodeToTheEnd() {
      LinkedList list = new LinkedList();

      Node firstNode = new Node(1);
      Node secondNode = new Node(2);
      Node thirdNode = new Node(3);

      list.addInTail(firstNode);
      list.addInTail(secondNode);
      list.addInTail(thirdNode);

      list.insertAfter(thirdNode, new Node(4));

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(list.find(4));
    }

    @Test
    @DisplayName("Should insert node in empty list")
    void shouldInsertNodeInEmptyList() {
      LinkedList list = new LinkedList();

      list.insertAfter(null, new Node(4));

      Assertions.assertEquals(1, list.count());
      Assertions.assertNotNull(list.find(4));
    }
  }
}
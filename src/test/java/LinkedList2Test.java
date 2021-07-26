import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LinkedList2Test {
  @Nested
  @DisplayName("find method")
  class FindMethod {
    @Test
    @DisplayName("Should find node by value")
    void shouldFindNodeByValue() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(2));
      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(3));
      list.addInTail(new LInkedNode(1));

      LInkedNode result = list.find(1);

      Assertions.assertEquals(1, result.value);
      Assertions.assertNull(result.prev);
      Assertions.assertEquals(2, result.next.value);
    }

    @Test
    @DisplayName("Should not find node")
    void shouldNotFindNode() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(2));
      list.addInTail(new LInkedNode(3));

      LInkedNode result = list.find(15);

      Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should not find node in empty list")
    void shouldNotFindNodeInEmptyList() {
      LinkedList2 list = new LinkedList2();

      LInkedNode result = list.find(15);

      Assertions.assertNull(result);
    }
  }

  @Nested
  @DisplayName("findAll method")
  class FindAllMethod {
    @Test
    @DisplayName("Should find one node")
    void shouldFindOneNode() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));

      ArrayList<LInkedNode> result = list.findAll(1);

      Assertions.assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should find several nodes")
    void shouldFindSeveralNodes() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(5));
      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(19));
      list.addInTail(new LInkedNode(1));

      ArrayList<LInkedNode> result = list.findAll(1);

      Assertions.assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Should not find nodes in empty list")
    void shouldNotFindNodesInEmptyList() {
      LinkedList2 list = new LinkedList2();

      ArrayList<LInkedNode> result = list.findAll(1);

      Assertions.assertEquals(0, result.size());
    }
  }

  @Nested
  @DisplayName("remove method")
  class RemoveMethod {
    @Test
    @DisplayName("Should remove node by value")
    void shouldRemoveNodeByValue() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(6));
      list.addInTail(new LInkedNode(18));
      list.addInTail(new LInkedNode(2));
      list.addInTail(new LInkedNode(42));

      boolean result = list.remove(18);

      Assertions.assertTrue(result);
      Assertions.assertEquals(4, list.count());
      Assertions.assertNull(list.find(18));
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(6, list.head.next.value);
      Assertions.assertEquals(42, list.tail.value);
      Assertions.assertEquals(2, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should remove last node by value")
    void shouldRemoveLastNodeByValue() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(6));
      list.addInTail(new LInkedNode(18));

      boolean result = list.remove(18);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(18));
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(6, list.head.next.value);
      Assertions.assertEquals(6, list.tail.value);
      Assertions.assertEquals(1, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should remove pre last node by value")
    void shouldRemovePreLastNodeByValue() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(6));
      list.addInTail(new LInkedNode(18));

      boolean result = list.remove(6);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(6));
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(18, list.head.next.value);
      Assertions.assertEquals(18, list.tail.value);
      Assertions.assertEquals(1, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should remove first node by value")
    void shouldRemoveFirstNodeByValue() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(6));
      list.addInTail(new LInkedNode(18));

      boolean result = list.remove(1);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(1));
      Assertions.assertEquals(6, list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(18, list.head.next.value);
      Assertions.assertEquals(18, list.tail.value);
      Assertions.assertEquals(6, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should not remove anything from empty list")
    void shouldNotRemoveFromEmptyList() {
      LinkedList2 list = new LinkedList2();

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
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(5));
      list.addInTail(new LInkedNode(10));

      boolean result = list.remove(15);

      Assertions.assertFalse(result);
      Assertions.assertEquals(3, list.count());
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(5, list.head.next.value);
      Assertions.assertEquals(10, list.tail.value);
      Assertions.assertEquals(5, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should return empty list")
    void shouldReturnEmptyList() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));

      boolean result = list.remove(1);

      Assertions.assertTrue(result);
      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(1));
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }
  }

  @Nested
  @DisplayName("removeAll method")
  class RemoveAllMethod {
    @Test
    @DisplayName("Should remove one node")
    void shouldRemoveOneNode() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));

      list.removeAll(1);

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(1));
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }

    @Test
    @DisplayName("Should remove several nodes")
    void shouldRemoveSeveralNodes() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(5));
      list.addInTail(new LInkedNode(10));
      list.addInTail(new LInkedNode(2));
      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(1));

      list.removeAll(1);

      Assertions.assertEquals(3, list.count());
      Assertions.assertEquals(0, list.findAll(1).size());
      Assertions.assertEquals(5, list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(10, list.head.next.value);
      Assertions.assertEquals(2, list.tail.value);
      Assertions.assertEquals(10, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }

    @Test
    @DisplayName("Should return empty list")
    void shouldReturnEmptyList() {
      LinkedList2 list = new LinkedList2();

      list.removeAll(1);

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }

    @Test
    @DisplayName("Should not remove not existing values")
    void shouldNotRemoveNotExistingValues() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(5));
      list.addInTail(new LInkedNode(10));
      list.addInTail(new LInkedNode(2));
      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(1));

      list.removeAll(100);

      Assertions.assertEquals(7, list.count());
      Assertions.assertEquals(0, list.findAll(100).size());
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertNull(list.head.prev);
      Assertions.assertEquals(1, list.head.next.value);
      Assertions.assertEquals(1, list.tail.value);
      Assertions.assertEquals(1, list.tail.prev.value);
      Assertions.assertNull(list.tail.next);
    }
  }

  @Nested
  @DisplayName("insertAfter method")
  class InsertAfterMethod {
    @Test
    @DisplayName("Should insert node in the middle of the list")
    void shouldInsertNodeInTheMiddleOfTheList() {
      LinkedList2 list = new LinkedList2();

      LInkedNode firstNode = new LInkedNode(1);
      LInkedNode secondNode = new LInkedNode(2);
      LInkedNode thirdNode = new LInkedNode(3);

      list.addInTail(firstNode);
      list.addInTail(secondNode);
      list.addInTail(thirdNode);

      list.insertAfter(secondNode, new LInkedNode(4));

      LInkedNode insertedNode = list.find(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(insertedNode);
      Assertions.assertEquals(2, insertedNode.prev.value);
      Assertions.assertEquals(3, insertedNode.next.value);
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(3, list.tail.value);
    }

    @Test
    @DisplayName("Should insert node after first node")
    void shouldInsertNodeAfterFirstNode() {
      LinkedList2 list = new LinkedList2();

      LInkedNode firstNode = new LInkedNode(1);
      LInkedNode secondNode = new LInkedNode(2);
      LInkedNode thirdNode = new LInkedNode(3);

      list.addInTail(firstNode);
      list.addInTail(secondNode);
      list.addInTail(thirdNode);

      list.insertAfter(firstNode, new LInkedNode(4));

      LInkedNode insertedNode = list.find(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(insertedNode);
      Assertions.assertEquals(1, insertedNode.prev.value);
      Assertions.assertEquals(2, insertedNode.next.value);
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(3, list.tail.value);
    }

    @Test
    @DisplayName("Should insert node before first node")
    void shouldInsertNodeBeforeFirstNode() {
      LinkedList2 list = new LinkedList2();

      LInkedNode firstNode = new LInkedNode(1);
      LInkedNode secondNode = new LInkedNode(2);
      LInkedNode thirdNode = new LInkedNode(3);

      list.addInTail(firstNode);
      list.addInTail(secondNode);
      list.addInTail(thirdNode);

      list.insertAfter(null, new LInkedNode(4));

      LInkedNode insertedNode = list.find(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(insertedNode);
      Assertions.assertNull(insertedNode.prev);
      Assertions.assertEquals(1, insertedNode.next.value);
      Assertions.assertEquals(4, firstNode.prev.value);
      Assertions.assertEquals(4, list.head.value);
      Assertions.assertEquals(3, list.tail.value);
    }

    @Test
    @DisplayName("Should insert node to the end")
    void shouldInsertNodeToTheEnd() {
      LinkedList2 list = new LinkedList2();

      LInkedNode firstNode = new LInkedNode(1);
      LInkedNode secondNode = new LInkedNode(2);
      LInkedNode thirdNode = new LInkedNode(3);

      list.addInTail(firstNode);
      list.addInTail(secondNode);
      list.addInTail(thirdNode);

      list.insertAfter(thirdNode, new LInkedNode(4));

      LInkedNode insertedNode = list.find(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(insertedNode);
      Assertions.assertEquals(3, insertedNode.prev.value);
      Assertions.assertNull(insertedNode.next);
      Assertions.assertEquals(1, list.head.value);
      Assertions.assertEquals(4, list.tail.value);
    }

    @Test
    @DisplayName("Should insert node in empty list")
    void shouldInsertNodeInEmptyList() {
      LinkedList2 list = new LinkedList2();

      list.insertAfter(null, new LInkedNode(4));

      LInkedNode insertedNode = list.find(4);

      Assertions.assertEquals(1, list.count());
      Assertions.assertNotNull(insertedNode);
      Assertions.assertNull(insertedNode.prev);
      Assertions.assertNull(insertedNode.next);
      Assertions.assertEquals(4, list.head.value);
      Assertions.assertEquals(4, list.tail.value);
    }
  }

  @Nested
  @DisplayName("clear method")
  class ClearMethod {
    @Test
    @DisplayName("Should clear not empty list")
    void shouldClearList() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new LInkedNode(1));
      list.addInTail(new LInkedNode(2));
      list.addInTail(new LInkedNode(3));

      list.clear();

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }

    @Test
    @DisplayName("Should clear empty list")
    void shouldClearEmptyList() {
      LinkedList2 list = new LinkedList2();

      list.clear();

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.head);
      Assertions.assertNull(list.tail);
    }
  }
}

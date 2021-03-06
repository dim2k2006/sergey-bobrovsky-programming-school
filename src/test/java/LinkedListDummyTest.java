import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class LinkedListDummyTest {
  @Nested
  @DisplayName("find method")
  class FindMethod {
    @Test
    @DisplayName("Should find BaseNode by value")
    void shouldFindBaseNodeByValue() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(2));
      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(3));
      list.addInTail(new BaseNode(1));

      BaseNode result = list.find(1);
      BaseNode head = list.getHead();

      Assertions.assertEquals(1, result.getValue());
      Assertions.assertEquals(head, result);
      Assertions.assertNull(head.getPrev());
      Assertions.assertEquals(2, result.getNext().getValue());
    }

    @Test
    @DisplayName("Should not find BaseNode")
    void shouldNotFindBaseNode() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(2));
      list.addInTail(new BaseNode(3));

      BaseNode result = list.find(15);

      Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should not find BaseNode in empty list")
    void shouldNotFindBaseNodeInEmptyList() {
      LinkedListDummy list = new LinkedListDummy();

      BaseNode result = list.find(15);

      Assertions.assertNull(result);
    }
  }

  @Nested
  @DisplayName("findAll method")
  class FindAllMethod {
    @Test
    @DisplayName("Should find one BaseNode")
    void shouldFindOneBaseNode() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));

      ArrayList<BaseNode> result = list.findAll(1);

      Assertions.assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should find several BaseNodes")
    void shouldFindSeveralBaseNodes() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(5));
      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(19));
      list.addInTail(new BaseNode(1));

      ArrayList<BaseNode> result = list.findAll(1);

      Assertions.assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Should not find BaseNodes in empty list")
    void shouldNotFindBaseNodesInEmptyList() {
      LinkedListDummy list = new LinkedListDummy();

      ArrayList<BaseNode> result = list.findAll(1);

      Assertions.assertEquals(0, result.size());
    }
  }

  @Nested
  @DisplayName("remove method")
  class RemoveMethod {
    @Test
    @DisplayName("Should remove BaseNode by value")
    void shouldRemoveBaseNodeByValue() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(6));
      list.addInTail(new BaseNode(18));
      list.addInTail(new BaseNode(2));
      list.addInTail(new BaseNode(42));

      boolean result = list.remove(18);

      Assertions.assertTrue(result);
      Assertions.assertEquals(4, list.count());
      Assertions.assertNull(list.find(18));
      Assertions.assertEquals(1, list.getHead().getValue());
      Assertions.assertNull(list.getHead().getPrev());
      Assertions.assertEquals(6, list.getHead().getNext().getValue());
      Assertions.assertEquals(42, list.getTail().getValue());
      Assertions.assertEquals(2, list.getTail().getPrev().getValue());
      Assertions.assertNull(list.getTail().getNext());
    }

    @Test
    @DisplayName("Should remove last BaseNode by value")
    void shouldRemoveLastBaseNodeByValue() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(6));
      list.addInTail(new BaseNode(18));

      boolean result = list.remove(18);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(18));
      Assertions.assertEquals(1, list.getHead().getValue());
      Assertions.assertNull(list.getHead().getPrev());
      Assertions.assertEquals(6, list.getHead().getNext().getValue());
      Assertions.assertEquals(6, list.getTail().getValue());
      Assertions.assertEquals(1, list.getTail().getPrev().getValue());
      Assertions.assertNull(list.getTail().getNext());
    }

    @Test
    @DisplayName("Should remove pre last BaseNode by value")
    void shouldRemovePreLastBaseNodeByValue() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(6));
      list.addInTail(new BaseNode(18));

      boolean result = list.remove(6);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(6));
      Assertions.assertEquals(1, list.getHead().getValue());
      Assertions.assertNull(list.getHead().getPrev());
      Assertions.assertEquals(18, list.getHead().getNext().getValue());
      Assertions.assertEquals(18, list.getTail().getValue());
      Assertions.assertEquals(1, list.getTail().getPrev().getValue());
      Assertions.assertNull(list.getTail().getNext());
    }

    @Test
    @DisplayName("Should remove first BaseNode by value")
    void shouldRemoveFirstBaseNodeByValue() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(6));
      list.addInTail(new BaseNode(18));

      boolean result = list.remove(1);

      Assertions.assertTrue(result);
      Assertions.assertEquals(2, list.count());
      Assertions.assertNull(list.find(1));
      Assertions.assertEquals(6, list.getHead().getValue());
      Assertions.assertNull(list.getHead().getPrev());
      Assertions.assertEquals(18, list.getHead().getNext().getValue());
      Assertions.assertEquals(18, list.getTail().getValue());
      Assertions.assertEquals(6, list.getTail().getPrev().getValue());
      Assertions.assertNull(list.getTail().getNext());
    }

    @Test
    @DisplayName("Should not remove anything from empty list")
    void shouldNotRemoveFromEmptyList() {
      LinkedListDummy list = new LinkedListDummy();

      boolean result = list.remove(5);

      Assertions.assertFalse(result);
      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(5));
      Assertions.assertNull(list.getHead());
      Assertions.assertNull(list.getTail());
    }

    @Test
    @DisplayName("Should not remove not existing value")
    void shouldNotRemoveNotExistingValue() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(5));
      list.addInTail(new BaseNode(10));

      boolean result = list.remove(15);

      Assertions.assertFalse(result);
      Assertions.assertEquals(3, list.count());
      Assertions.assertEquals(1, list.getHead().getValue());
      Assertions.assertNull(list.getHead().getPrev());
      Assertions.assertEquals(5, list.getHead().getNext().getValue());
      Assertions.assertEquals(10, list.getTail().getValue());
      Assertions.assertEquals(5, list.getTail().getPrev().getValue());
      Assertions.assertNull(list.getTail().getNext());
    }

    @Test
    @DisplayName("Should return empty list")
    void shouldReturnEmptyList() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));

      boolean result = list.remove(1);

      Assertions.assertTrue(result);
      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(1));
      Assertions.assertNull(list.getHead());
      Assertions.assertNull(list.getTail());
    }
  }

  @Nested
  @DisplayName("removeAll method")
  class RemoveAllMethod {
    @Test
    @DisplayName("Should remove one BaseNode")
    void shouldRemoveOneBaseNode() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));

      list.removeAll(1);

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.find(1));
      Assertions.assertNull(list.getHead());
      Assertions.assertNull(list.getTail());
    }

    @Test
    @DisplayName("Should remove several BaseNodes")
    void shouldRemoveSeveralBaseNodes() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(5));
      list.addInTail(new BaseNode(10));
      list.addInTail(new BaseNode(2));
      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(1));

      list.removeAll(1);

      Assertions.assertEquals(3, list.count());
      Assertions.assertEquals(0, list.findAll(1).size());
      Assertions.assertEquals(5, list.getHead().getValue());
      Assertions.assertNull(list.getHead().getPrev());
      Assertions.assertEquals(10, list.getHead().getNext().getValue());
      Assertions.assertEquals(2, list.getTail().getValue());
      Assertions.assertEquals(10, list.getTail().getPrev().getValue());
      Assertions.assertNull(list.getTail().getNext());
    }

    @Test
    @DisplayName("Should return empty list")
    void shouldReturnEmptyList() {
      LinkedListDummy list = new LinkedListDummy();

      list.removeAll(1);

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.getHead());
      Assertions.assertNull(list.getTail());
    }

    @Test
    @DisplayName("Should not remove not existing values")
    void shouldNotRemoveNotExistingValues() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(5));
      list.addInTail(new BaseNode(10));
      list.addInTail(new BaseNode(2));
      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(1));

      list.removeAll(100);

      Assertions.assertEquals(7, list.count());
      Assertions.assertEquals(0, list.findAll(100).size());
      Assertions.assertEquals(1, list.getHead().getValue());
      Assertions.assertNull(list.getHead().getPrev());
      Assertions.assertEquals(1, list.getHead().getNext().getValue());
      Assertions.assertEquals(1, list.getTail().getValue());
      Assertions.assertEquals(1, list.getTail().getPrev().getValue());
      Assertions.assertNull(list.getTail().getNext());
    }
  }

  @Nested
  @DisplayName("insertAfter method")
  class InsertAfterMethod {
    @Test
    @DisplayName("Should insert BaseNode in the middle of the list")
    void shouldInsertBaseNodeInTheMiddleOfTheList() {
      LinkedListDummy list = new LinkedListDummy();

      BaseNode firstBaseNode = new BaseNode(1);
      BaseNode secondBaseNode = new BaseNode(2);
      BaseNode thirdBaseNode = new BaseNode(3);

      list.addInTail(firstBaseNode);
      list.addInTail(secondBaseNode);
      list.addInTail(thirdBaseNode);

      list.insertAfter(secondBaseNode, new BaseNode(4));

      BaseNode insertedBaseNode = list.find(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(insertedBaseNode);
      Assertions.assertEquals(2, insertedBaseNode.getPrev().getValue());
      Assertions.assertEquals(3, insertedBaseNode.getNext().getValue());
      Assertions.assertEquals(1, list.getHead().getValue());
      Assertions.assertEquals(3, list.getTail().getValue());
    }

    @Test
    @DisplayName("Should insert BaseNode after first BaseNode")
    void shouldInsertBaseNodeAfterFirstBaseNode() {
      LinkedListDummy list = new LinkedListDummy();

      BaseNode firstBaseNode = new BaseNode(1);
      BaseNode secondBaseNode = new BaseNode(2);
      BaseNode thirdBaseNode = new BaseNode(3);

      list.addInTail(firstBaseNode);
      list.addInTail(secondBaseNode);
      list.addInTail(thirdBaseNode);

      list.insertAfter(firstBaseNode, new BaseNode(4));

      BaseNode insertedBaseNode = list.find(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(insertedBaseNode);
      Assertions.assertEquals(1, insertedBaseNode.getPrev().getValue());
      Assertions.assertEquals(2, insertedBaseNode.getNext().getValue());
      Assertions.assertEquals(1, list.getHead().getValue());
      Assertions.assertEquals(3, list.getTail().getValue());
    }

    @Test
    @DisplayName("Should insert BaseNode before first BaseNode")
    void shouldInsertBaseNodeBeforeFirstBaseNode() {
      LinkedListDummy list = new LinkedListDummy();

      BaseNode firstBaseNode = new BaseNode(1);
      BaseNode secondBaseNode = new BaseNode(2);
      BaseNode thirdBaseNode = new BaseNode(3);

      list.addInTail(firstBaseNode);
      list.addInTail(secondBaseNode);
      list.addInTail(thirdBaseNode);

      list.insertAfter(null, new BaseNode(4));

      BaseNode insertedBaseNode = list.find(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(insertedBaseNode);
      Assertions.assertNull(insertedBaseNode.getPrev());
      Assertions.assertEquals(1, insertedBaseNode.getNext().getValue());
      Assertions.assertEquals(4, firstBaseNode.getPrev().getValue());
      Assertions.assertEquals(4, list.getHead().getValue());
      Assertions.assertEquals(3, list.getTail().getValue());
    }

    @Test
    @DisplayName("Should insert BaseNode to the end")
    void shouldInsertBaseNodeToTheEnd() {
      LinkedListDummy list = new LinkedListDummy();

      BaseNode firstBaseNode = new BaseNode(1);
      BaseNode secondBaseNode = new BaseNode(2);
      BaseNode thirdBaseNode = new BaseNode(3);

      list.addInTail(firstBaseNode);
      list.addInTail(secondBaseNode);
      list.addInTail(thirdBaseNode);

      list.insertAfter(thirdBaseNode, new BaseNode(4));

      BaseNode insertedBaseNode = list.find(4);

      Assertions.assertEquals(4, list.count());
      Assertions.assertNotNull(insertedBaseNode);
      Assertions.assertEquals(3, insertedBaseNode.getPrev().getValue());
      Assertions.assertNull(insertedBaseNode.getNext());
      Assertions.assertEquals(1, list.getHead().getValue());
      Assertions.assertEquals(4, list.getTail().getValue());
    }

    @Test
    @DisplayName("Should insert BaseNode in empty list")
    void shouldInsertBaseNodeInEmptyList() {
      LinkedListDummy list = new LinkedListDummy();

      list.insertAfter(null, new BaseNode(4));

      BaseNode insertedBaseNode = list.find(4);

      Assertions.assertEquals(1, list.count());
      Assertions.assertNotNull(insertedBaseNode);
      Assertions.assertNull(insertedBaseNode.getPrev());
      Assertions.assertNull(insertedBaseNode.getNext());
      Assertions.assertEquals(4, list.getHead().getValue());
      Assertions.assertEquals(4, list.getTail().getValue());
    }
  }

  @Nested
  @DisplayName("clear method")
  class ClearMethod {
    @Test
    @DisplayName("Should clear not empty list")
    void shouldClearList() {
      LinkedListDummy list = new LinkedListDummy();

      list.addInTail(new BaseNode(1));
      list.addInTail(new BaseNode(2));
      list.addInTail(new BaseNode(3));

      list.clear();

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.getHead());
      Assertions.assertNull(list.getTail());
    }

    @Test
    @DisplayName("Should clear empty list")
    void shouldClearEmptyList() {
      LinkedListDummy list = new LinkedListDummy();

      list.clear();

      Assertions.assertEquals(0, list.count());
      Assertions.assertNull(list.getHead());
      Assertions.assertNull(list.getTail());
    }
  }

  @Nested
  @DisplayName("count method")
  class CountMethod {
    @Test
    @DisplayName("Should generate empty linked list")
    void shouldGenerateEmptyLinkedList() {
      LinkedListDummy list = new LinkedListDummy();

      Assertions.assertEquals(0, list.count());
    }

    @Test
    @DisplayName("Should generate not empty linked list")
    void shouldGenerateNotEmptyLinkedList() {
      LinkedListDummy list = new LinkedListDummy();

      Random rd = new Random();

      int upperbound = 100;

      int[] arr = new int[rd.nextInt(upperbound)];

      for (int i = 0; i < arr.length; i++) {
        list.addInTail(new BaseNode(rd.nextInt(upperbound)));
      }

      Assertions.assertEquals(arr.length, list.count());
    }
  }
}
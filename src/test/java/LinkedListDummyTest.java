import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

      Assertions.assertEquals(1, result.getValue());
      Assertions.assertNull(result.getPrev());
//      Assertions.assertEquals(2, result.getNext().getValue());
    }

//    @Test
//    @DisplayName("Should not find BaseNode")
//    void shouldNotFindBaseNode() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(2));
//      list.addInTail(new BaseNode(3));
//
//      BaseNode result = list.find(15);
//
//      Assertions.assertNull(result);
//    }
//
//    @Test
//    @DisplayName("Should not find BaseNode in empty list")
//    void shouldNotFindBaseNodeInEmptyList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      BaseNode result = list.find(15);
//
//      Assertions.assertNull(result);
//    }
  }
//
//  @Nested
//  @DisplayName("findAll method")
//  class FindAllMethod {
//    @Test
//    @DisplayName("Should find one BaseNode")
//    void shouldFindOneBaseNode() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//
//      ArrayList<BaseNode> result = list.findAll(1);
//
//      Assertions.assertEquals(1, result.size());
//    }
//
//    @Test
//    @DisplayName("Should find several BaseNodes")
//    void shouldFindSeveralBaseNodes() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(5));
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(19));
//      list.addInTail(new BaseNode(1));
//
//      ArrayList<BaseNode> result = list.findAll(1);
//
//      Assertions.assertEquals(3, result.size());
//    }
//
//    @Test
//    @DisplayName("Should not find BaseNodes in empty list")
//    void shouldNotFindBaseNodesInEmptyList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      ArrayList<BaseNode> result = list.findAll(1);
//
//      Assertions.assertEquals(0, result.size());
//    }
//  }

//  @Nested
//  @DisplayName("remove method")
//  class RemoveMethod {
//    @Test
//    @DisplayName("Should remove BaseNode by value")
//    void shouldRemoveBaseNodeByValue() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(6));
//      list.addInTail(new BaseNode(18));
//      list.addInTail(new BaseNode(2));
//      list.addInTail(new BaseNode(42));
//
//      boolean result = list.remove(18);
//
//      Assertions.assertTrue(result);
//      Assertions.assertEquals(4, list.count());
//      Assertions.assertNull(list.find(18));
//      Assertions.assertEquals(1, list.head.value);
//      Assertions.assertNull(list.head.prev);
//      Assertions.assertEquals(6, list.head.next.value);
//      Assertions.assertEquals(42, list.tail.value);
//      Assertions.assertEquals(2, list.tail.prev.value);
//      Assertions.assertNull(list.tail.next);
//    }
//
//    @Test
//    @DisplayName("Should remove last BaseNode by value")
//    void shouldRemoveLastBaseNodeByValue() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(6));
//      list.addInTail(new BaseNode(18));
//
//      boolean result = list.remove(18);
//
//      Assertions.assertTrue(result);
//      Assertions.assertEquals(2, list.count());
//      Assertions.assertNull(list.find(18));
//      Assertions.assertEquals(1, list.head.value);
//      Assertions.assertNull(list.head.prev);
//      Assertions.assertEquals(6, list.head.next.value);
//      Assertions.assertEquals(6, list.tail.value);
//      Assertions.assertEquals(1, list.tail.prev.value);
//      Assertions.assertNull(list.tail.next);
//    }
//
//    @Test
//    @DisplayName("Should remove pre last BaseNode by value")
//    void shouldRemovePreLastBaseNodeByValue() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(6));
//      list.addInTail(new BaseNode(18));
//
//      boolean result = list.remove(6);
//
//      Assertions.assertTrue(result);
//      Assertions.assertEquals(2, list.count());
//      Assertions.assertNull(list.find(6));
//      Assertions.assertEquals(1, list.head.value);
//      Assertions.assertNull(list.head.prev);
//      Assertions.assertEquals(18, list.head.next.value);
//      Assertions.assertEquals(18, list.tail.value);
//      Assertions.assertEquals(1, list.tail.prev.value);
//      Assertions.assertNull(list.tail.next);
//    }
//
//    @Test
//    @DisplayName("Should remove first BaseNode by value")
//    void shouldRemoveFirstBaseNodeByValue() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(6));
//      list.addInTail(new BaseNode(18));
//
//      boolean result = list.remove(1);
//
//      Assertions.assertTrue(result);
//      Assertions.assertEquals(2, list.count());
//      Assertions.assertNull(list.find(1));
//      Assertions.assertEquals(6, list.head.value);
//      Assertions.assertNull(list.head.prev);
//      Assertions.assertEquals(18, list.head.next.value);
//      Assertions.assertEquals(18, list.tail.value);
//      Assertions.assertEquals(6, list.tail.prev.value);
//      Assertions.assertNull(list.tail.next);
//    }
//
//    @Test
//    @DisplayName("Should not remove anything from empty list")
//    void shouldNotRemoveFromEmptyList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      boolean result = list.remove(5);
//
//      Assertions.assertFalse(result);
//      Assertions.assertEquals(0, list.count());
//      Assertions.assertNull(list.find(5));
//      Assertions.assertNull(list.head);
//      Assertions.assertNull(list.tail);
//    }
//
//    @Test
//    @DisplayName("Should not remove not existing value")
//    void shouldNotRemoveNotExistingValue() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(5));
//      list.addInTail(new BaseNode(10));
//
//      boolean result = list.remove(15);
//
//      Assertions.assertFalse(result);
//      Assertions.assertEquals(3, list.count());
//      Assertions.assertEquals(1, list.head.value);
//      Assertions.assertNull(list.head.prev);
//      Assertions.assertEquals(5, list.head.next.value);
//      Assertions.assertEquals(10, list.tail.value);
//      Assertions.assertEquals(5, list.tail.prev.value);
//      Assertions.assertNull(list.tail.next);
//    }
//
//    @Test
//    @DisplayName("Should return empty list")
//    void shouldReturnEmptyList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//
//      boolean result = list.remove(1);
//
//      Assertions.assertTrue(result);
//      Assertions.assertEquals(0, list.count());
//      Assertions.assertNull(list.find(1));
//      Assertions.assertNull(list.head);
//      Assertions.assertNull(list.tail);
//    }
//  }
//
//  @Nested
//  @DisplayName("removeAll method")
//  class RemoveAllMethod {
//    @Test
//    @DisplayName("Should remove one BaseNode")
//    void shouldRemoveOneBaseNode() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//
//      list.removeAll(1);
//
//      Assertions.assertEquals(0, list.count());
//      Assertions.assertNull(list.find(1));
//      Assertions.assertNull(list.head);
//      Assertions.assertNull(list.tail);
//    }
//
//    @Test
//    @DisplayName("Should remove several BaseNodes")
//    void shouldRemoveSeveralBaseNodes() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(5));
//      list.addInTail(new BaseNode(10));
//      list.addInTail(new BaseNode(2));
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(1));
//
//      list.removeAll(1);
//
//      Assertions.assertEquals(3, list.count());
//      Assertions.assertEquals(0, list.findAll(1).size());
//      Assertions.assertEquals(5, list.head.value);
//      Assertions.assertNull(list.head.prev);
//      Assertions.assertEquals(10, list.head.next.value);
//      Assertions.assertEquals(2, list.tail.value);
//      Assertions.assertEquals(10, list.tail.prev.value);
//      Assertions.assertNull(list.tail.next);
//    }
//
//    @Test
//    @DisplayName("Should return empty list")
//    void shouldReturnEmptyList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.removeAll(1);
//
//      Assertions.assertEquals(0, list.count());
//      Assertions.assertNull(list.head);
//      Assertions.assertNull(list.tail);
//    }
//
//    @Test
//    @DisplayName("Should not remove not existing values")
//    void shouldNotRemoveNotExistingValues() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(5));
//      list.addInTail(new BaseNode(10));
//      list.addInTail(new BaseNode(2));
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(1));
//
//      list.removeAll(100);
//
//      Assertions.assertEquals(7, list.count());
//      Assertions.assertEquals(0, list.findAll(100).size());
//      Assertions.assertEquals(1, list.head.value);
//      Assertions.assertNull(list.head.prev);
//      Assertions.assertEquals(1, list.head.next.value);
//      Assertions.assertEquals(1, list.tail.value);
//      Assertions.assertEquals(1, list.tail.prev.value);
//      Assertions.assertNull(list.tail.next);
//    }
//  }
//
//  @Nested
//  @DisplayName("insertAfter method")
//  class InsertAfterMethod {
//    @Test
//    @DisplayName("Should insert BaseNode in the middle of the list")
//    void shouldInsertBaseNodeInTheMiddleOfTheList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      BaseNode firstBaseNode = new BaseNode(1);
//      BaseNode secondBaseNode = new BaseNode(2);
//      BaseNode thirdBaseNode = new BaseNode(3);
//
//      list.addInTail(firstBaseNode);
//      list.addInTail(secondBaseNode);
//      list.addInTail(thirdBaseNode);
//
//      list.insertAfter(secondBaseNode, new BaseNode(4));
//
//      BaseNode insertedBaseNode = list.find(4);
//
//      Assertions.assertEquals(4, list.count());
//      Assertions.assertNotNull(insertedBaseNode);
//      Assertions.assertEquals(2, insertedBaseNode.prev.value);
//      Assertions.assertEquals(3, insertedBaseNode.next.value);
//      Assertions.assertEquals(1, list.head.value);
//      Assertions.assertEquals(3, list.tail.value);
//    }
//
//    @Test
//    @DisplayName("Should insert BaseNode after first BaseNode")
//    void shouldInsertBaseNodeAfterFirstBaseNode() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      BaseNode firstBaseNode = new BaseNode(1);
//      BaseNode secondBaseNode = new BaseNode(2);
//      BaseNode thirdBaseNode = new BaseNode(3);
//
//      list.addInTail(firstBaseNode);
//      list.addInTail(secondBaseNode);
//      list.addInTail(thirdBaseNode);
//
//      list.insertAfter(firstBaseNode, new BaseNode(4));
//
//      BaseNode insertedBaseNode = list.find(4);
//
//      Assertions.assertEquals(4, list.count());
//      Assertions.assertNotNull(insertedBaseNode);
//      Assertions.assertEquals(1, insertedBaseNode.prev.value);
//      Assertions.assertEquals(2, insertedBaseNode.next.value);
//      Assertions.assertEquals(1, list.head.value);
//      Assertions.assertEquals(3, list.tail.value);
//    }
//
//    @Test
//    @DisplayName("Should insert BaseNode before first BaseNode")
//    void shouldInsertBaseNodeBeforeFirstBaseNode() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      BaseNode firstBaseNode = new BaseNode(1);
//      BaseNode secondBaseNode = new BaseNode(2);
//      BaseNode thirdBaseNode = new BaseNode(3);
//
//      list.addInTail(firstBaseNode);
//      list.addInTail(secondBaseNode);
//      list.addInTail(thirdBaseNode);
//
//      list.insertAfter(null, new BaseNode(4));
//
//      BaseNode insertedBaseNode = list.find(4);
//
//      Assertions.assertEquals(4, list.count());
//      Assertions.assertNotNull(insertedBaseNode);
//      Assertions.assertNull(insertedBaseNode.prev);
//      Assertions.assertEquals(1, insertedBaseNode.next.value);
//      Assertions.assertEquals(4, firstBaseNode.prev.value);
//      Assertions.assertEquals(4, list.head.value);
//      Assertions.assertEquals(3, list.tail.value);
//    }
//
//    @Test
//    @DisplayName("Should insert BaseNode to the end")
//    void shouldInsertBaseNodeToTheEnd() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      BaseNode firstBaseNode = new BaseNode(1);
//      BaseNode secondBaseNode = new BaseNode(2);
//      BaseNode thirdBaseNode = new BaseNode(3);
//
//      list.addInTail(firstBaseNode);
//      list.addInTail(secondBaseNode);
//      list.addInTail(thirdBaseNode);
//
//      list.insertAfter(thirdBaseNode, new BaseNode(4));
//
//      BaseNode insertedBaseNode = list.find(4);
//
//      Assertions.assertEquals(4, list.count());
//      Assertions.assertNotNull(insertedBaseNode);
//      Assertions.assertEquals(3, insertedBaseNode.prev.value);
//      Assertions.assertNull(insertedBaseNode.next);
//      Assertions.assertEquals(1, list.head.value);
//      Assertions.assertEquals(4, list.tail.value);
//    }
//
//    @Test
//    @DisplayName("Should insert BaseNode in empty list")
//    void shouldInsertBaseNodeInEmptyList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.insertAfter(null, new BaseNode(4));
//
//      BaseNode insertedBaseNode = list.find(4);
//
//      Assertions.assertEquals(1, list.count());
//      Assertions.assertNotNull(insertedBaseNode);
//      Assertions.assertNull(insertedBaseNode.prev);
//      Assertions.assertNull(insertedBaseNode.next);
//      Assertions.assertEquals(4, list.head.value);
//      Assertions.assertEquals(4, list.tail.value);
//    }
//  }
//
//  @Nested
//  @DisplayName("clear method")
//  class ClearMethod {
//    @Test
//    @DisplayName("Should clear not empty list")
//    void shouldClearList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.addInTail(new BaseNode(1));
//      list.addInTail(new BaseNode(2));
//      list.addInTail(new BaseNode(3));
//
//      list.clear();
//
//      Assertions.assertEquals(0, list.count());
//      Assertions.assertNull(list.head);
//      Assertions.assertNull(list.tail);
//    }
//
//    @Test
//    @DisplayName("Should clear empty list")
//    void shouldClearEmptyList() {
//      LinkedListDummy list = new LinkedListDummy();
//
//      list.clear();
//
//      Assertions.assertEquals(0, list.count());
//      Assertions.assertNull(list.head);
//      Assertions.assertNull(list.tail);
//    }
//  }
}

// count method ???
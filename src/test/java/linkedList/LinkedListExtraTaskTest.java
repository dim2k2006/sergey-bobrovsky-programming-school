package linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListExtraTaskTest {
  @Test
  @DisplayName("Should return zipped list")
  void shouldReturnZippedList() {
    LinkedList listA = new LinkedList();
    LinkedList listB = new LinkedList();

    listA.addInTail(new linkedList.Node(1));
    listA.addInTail(new linkedList.Node(2));
    listA.addInTail(new linkedList.Node(3));

    listB.addInTail(new linkedList.Node(4));
    listB.addInTail(new linkedList.Node(5));
    listB.addInTail(new linkedList.Node(6));

    LinkedList result = LinkedListExtraTask.zip(listA, listB);

    Assertions.assertEquals(3, result.count());
    Assertions.assertNotNull(result.find(5));
    Assertions.assertNotNull(result.find(7));
    Assertions.assertNotNull(result.find(9));
  }

  @Test
  @DisplayName("Should return empty list")
  void shouldReturnEmptyList() {
    LinkedList listA = new LinkedList();
    LinkedList listB = new LinkedList();

    LinkedList result = LinkedListExtraTask.zip(listA, listB);

    Assertions.assertEquals(0, result.count());
  }

  @Test
  @DisplayName("Should return empty list")
  void shouldReturnEmptyList1() {
    LinkedList listA = new LinkedList();
    LinkedList listB = new LinkedList();

    listA.addInTail(new linkedList.Node(1));
    listA.addInTail(new linkedList.Node(2));

    listB.addInTail(new linkedList.Node(4));
    listB.addInTail(new linkedList.Node(5));
    listB.addInTail(new linkedList.Node(6));

    LinkedList result = LinkedListExtraTask.zip(listA, listB);

    Assertions.assertEquals(0, result.count());
  }
}

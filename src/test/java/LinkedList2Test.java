import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class LinkedList2Test {
  @Nested
  @DisplayName("find method")
  class FindMethod {
    @Test
    @DisplayName("Should find node by value")
    void shouldFindNodeByValue() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new Node(1));
      list.addInTail(new Node(2));
      list.addInTail(new Node(1));
      list.addInTail(new Node(3));
      list.addInTail(new Node(1));

      Node result = list.find(1);

      Assertions.assertEquals(1, result.value);
      Assertions.assertNull(result.prev);
      Assertions.assertEquals(2, result.next.value);
    }

    @Test
    @DisplayName("Should not find node")
    void shouldNotFindNode() {
      LinkedList2 list = new LinkedList2();

      list.addInTail(new Node(1));
      list.addInTail(new Node(2));
      list.addInTail(new Node(3));

      Node result = list.find(15);

      Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should not find node in empty list")
    void shouldNotFindNodeInEmptyList() {
      LinkedList2 list = new LinkedList2();

      Node result = list.find(15);

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

      list.addInTail(new Node(1));

      ArrayList<Node> result = list.findAll(1);

      Assertions.assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should find several nodes")
    void shouldFindSeveralNodes() {
      LinkedList2 list = new LinkedList2();

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
      LinkedList2 list = new LinkedList2();

      ArrayList<Node> result = list.findAll(1);

      Assertions.assertEquals(0, result.size());
    }
  }
}

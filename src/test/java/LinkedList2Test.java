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
  }
}

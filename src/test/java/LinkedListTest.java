import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
  @Test
  void shouldShowSimpleAssertions() {
    Assertions.assertEquals(1, 1);
  }

  @Test
  @DisplayName("Should generate empty linked list")
  void shouldGenerateEmptyLinkedList() {
    LinkedList list = new LinkedList();

    Assertions.assertNull(list.head);
  }


}
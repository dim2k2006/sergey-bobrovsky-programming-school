import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class LinkedListTest {
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
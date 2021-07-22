import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DequeTest {
  @Nested
  @DisplayName("addFront method")
  class AddFrontMethod {
    @Test
    @DisplayName("Should add items to the head of queue")
    public void shouldAddItemsToTheHeadOfQueue() {
      Deque<Integer> queue = new Deque<Integer>();

      Assertions.assertEquals(0, queue.size());

      queue.addFront(1);

      Assertions.assertEquals(1, queue.size());

      queue.addFront(2);

      Assertions.assertEquals(2, queue.size());

      Assertions.assertEquals(2, queue.array[0].value);
      Assertions.assertEquals(1, queue.array[1].value);
    }
  }
}

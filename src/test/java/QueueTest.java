import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QueueTest {
  @Nested
  @DisplayName("enqueue method")
  class EnqueueMethod {
    @Test
    @DisplayName("Should add items to the tail of queue")
    public void shouldAddItemsToTheTailOfQueue() {
      Queue<Integer> queue = new Queue<Integer>();

      Assertions.assertEquals(0, queue.size());

      queue.enqueue(1);

      Assertions.assertEquals(1, queue.size());

      queue.enqueue(2);

      Assertions.assertEquals(2, queue.size());
    }
  }
}

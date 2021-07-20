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

  @Nested
  @DisplayName("dequeue method")
  class DequeueMethod {
    @Test
    @DisplayName("Should return item from the head of queue")
    public void shouldReturnItemFromTheHeadOfQueue() {
      Queue<Integer> queue = new Queue<Integer>();

      queue.enqueue(1);
      queue.enqueue(2);
      queue.enqueue(3);

      Assertions.assertEquals(1, queue.dequeue());

      Assertions.assertEquals(2, queue.size());

      Assertions.assertEquals(2, queue.dequeue());

      Assertions.assertEquals(1, queue.size());

      Assertions.assertEquals(3, queue.dequeue());

      Assertions.assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("Should return null if queue is empty")
    public void shouldReturnNullIfQueueIsEmpty() {
      Queue<Integer> queue = new Queue<Integer>();

      Assertions.assertNull(queue.dequeue());
    }
  }
}

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

  @Nested
  @DisplayName("removeFront method")
  class RemoveFrontMethod {
    @Test
    @DisplayName("Should remove items from the head of queue")
    public void shouldRemoveItemsFromTheHeadOfQueue() {
      Deque<Integer> queue = new Deque<Integer>();

      Assertions.assertEquals(0, queue.size());

      Assertions.assertNull(queue.removeFront());

      queue.addFront(1);

      Assertions.assertEquals(1, queue.size());

      queue.addFront(2);

      Assertions.assertEquals(2, queue.size());

      Assertions.assertEquals(2, queue.removeFront());

      Assertions.assertEquals(1, queue.size());

      Assertions.assertEquals(1, queue.removeFront());

      Assertions.assertEquals(0, queue.size());
    }
  }

  @Nested
  @DisplayName("addTail method")
  class AddTailMethod {
    @Test
    @DisplayName("Should add items to the tail of queue")
    public void shouldAddItemsToTheTailOfQueue() {
      Deque<Integer> queue = new Deque<Integer>();

      Assertions.assertEquals(0, queue.size());

      queue.addTail(1);

      Assertions.assertEquals(1, queue.size());

      queue.addTail(2);

      Assertions.assertEquals(2, queue.size());

      Assertions.assertEquals(1, queue.array[0].value);
      Assertions.assertEquals(2, queue.array[1].value);
    }
  }

  @Nested
  @DisplayName("removeTail method")
  class RemoveTailMethod {
    @Test
    @DisplayName("Should remove items from the tail of queue")
    public void shouldRemoveItemsFromTheHeadOfQueue() {
      Deque<Integer> queue = new Deque<Integer>();

      Assertions.assertEquals(0, queue.size());

      Assertions.assertNull(queue.removeTail());

      queue.addTail(1);

      Assertions.assertEquals(1, queue.size());

      queue.addTail(2);

      Assertions.assertEquals(2, queue.size());

      Assertions.assertEquals(2, queue.removeTail());

      Assertions.assertEquals(1, queue.size());

      Assertions.assertEquals(1, queue.removeTail());

      Assertions.assertEquals(0, queue.size());
    }
  }
}

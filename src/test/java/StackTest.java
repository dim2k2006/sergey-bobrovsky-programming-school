import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StackTest {
  @Nested
  @DisplayName("push method")
  class PushMethod {
    @Test
    @DisplayName("Should push items to stack")
    public void shouldPushItemsToStack() {
      Stack<Integer> stack = new Stack<Integer>(Integer.class);

      stack.push(1);

      Assertions.assertEquals(1, stack.size());
      Assertions.assertEquals(1, stack.peek());

      stack.push(2);

      Assertions.assertEquals(2, stack.size());
      Assertions.assertEquals(2, stack.peek());

      stack.push(3);

      Assertions.assertEquals(3, stack.size());
      Assertions.assertEquals(3, stack.peek());
    }
  }

  @Nested
  @DisplayName("peek method")
  class PeekMethod {
    @Test
    @DisplayName("Should return last item from stack")
    public void shouldReturnLastItemFromStack() {
      Stack<Integer> stack = new Stack<Integer>(Integer.class);

      stack.push(1);

      int last1 = stack.peek();

      Assertions.assertEquals(1, last1);
      Assertions.assertEquals(1, stack.size());

      stack.push(2);
      stack.push(3);

      int last2 = stack.peek();

      Assertions.assertEquals(3, last2);
      Assertions.assertEquals(3, stack.size());
    }

    @Test
    @DisplayName("Should return null if stack is empty")
    public void shouldReturnNullIfStackIsEmpty() {
      Stack<Integer> stack = new Stack<Integer>(Integer.class);

      Assertions.assertNull(stack.peek());
    }
  }
}

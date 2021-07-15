import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StackTest {
  @Nested
  @DisplayName("push method")
  class PushMethod {
    @Test
    @DisplayName("Should make array with new capacity")
    public void shouldMakeArrayWithNewCapacity() {
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
}

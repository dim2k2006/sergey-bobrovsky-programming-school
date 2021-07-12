import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DynArrayTest {
  @Nested
  @DisplayName("find method")
  class MakeArrayMethod {
    @Test
    @DisplayName("Should make array with new capacity")
    public void shouldMakeArrayWithNewCapacity() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      Assertions.assertEquals(16, array.capacity);
      Assertions.assertEquals(0, array.count);
    }
  }
}

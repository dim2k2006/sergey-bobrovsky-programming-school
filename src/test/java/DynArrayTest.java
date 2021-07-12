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

  @Nested
  @DisplayName("append method")
  class AppendMethod {
    @Test
    @DisplayName("Should add one item to the array")
    public void shouldAddItemToTheEmptyArray() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(4);

      Assertions.assertEquals(1, array.count);
    }

    @Test
    @DisplayName("Should add several items to the array")
    public void shouldAddSeveralItemsToTheArray() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(4);
      array.append(5);
      array.append(6);

      Assertions.assertEquals(3, array.count);
    }

    @Test
    @DisplayName("Should add several items to the array with full capacity")
    public void shouldAddSeveralItemsToTheArrayWithFullCapacity() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      int[] arr = new int[16];

      for (int i = 0; i < arr.length; i++) {
        array.append(1);
      }

      Assertions.assertEquals(16, array.count);
      Assertions.assertEquals(array.count, array.capacity);

      array.append(5);

      Assertions.assertEquals(17, array.count);
      Assertions.assertEquals(32, array.capacity);
    }
  }
}

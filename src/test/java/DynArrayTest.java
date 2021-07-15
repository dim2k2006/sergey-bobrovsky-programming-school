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

  @Nested
  @DisplayName("getItem method")
  class GetItemMethod {
    @Test
    @DisplayName("Should return item by index")
    public void shouldReturnItemByIndex() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(1);
      array.append(2);
      array.append(3);

      Assertions.assertEquals(2, array.getItem(1));
    }

    @Test
    @DisplayName("Should throw an exception if the index is negative")
    public void shouldThrowAnExceptionIfTheIndexIsNegative() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(1);
      array.append(2);
      array.append(3);

      Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
        array.getItem(-1);
      });
    }

    @Test
    @DisplayName("Should throw an exception if the index is greater then array capacity")
    public void shouldThrowAnExceptionIfTheIndexIsGreaterThenArrayCapacity() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(1);
      array.append(2);
      array.append(3);

      Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
        array.getItem(20);
      });
    }

    @Test
    @DisplayName("Should throw an exception if the array is empty")
    public void shouldThrowAnExceptionIfTheArrayIsEmpty() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
        array.getItem(4);
      });
    }
  }

  @Nested
  @DisplayName("insert method")
  class InsertMethod {
    @Test
    @DisplayName("Should insert item in array")
    public void shouldInsertItemInArray() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(1);
      array.append(2);
      array.append(3);

      array.insert(5, 1);

      Assertions.assertEquals(4, array.count);
      Assertions.assertEquals(5, array.getItem(1));
    }

    @Test
    @DisplayName("Should throw an exception if the index is negative")
    public void shouldThrowAnExceptionIfTheIndexIsNegative() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(1);
      array.append(2);
      array.append(3);

      Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
        array.insert(5, -1);
      });
    }

    @Test
    @DisplayName("Should throw an exception if the index is greater then array capacity")
    public void shouldThrowAnExceptionIfTheIndexIsGreaterThenArrayCapacity() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(1);
      array.append(2);
      array.append(3);

      Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
        array.insert(5, 20);
      });
    }

    @Test
    @DisplayName("Should insert item in empty array")
    public void shouldInsertItemInEmptyArray() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.insert(5, 0);

      Assertions.assertEquals(1, array.count);
    }

    @Test
    @DisplayName("Should insert item in the array with full capacity")
    public void shouldInsertItemInTheArrayWithFullCapacity() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      int[] arr = new int[16];

      for (int i = 0; i < arr.length; i++) {
        array.append(1);
      }

      Assertions.assertEquals(16, array.count);
      Assertions.assertEquals(array.count, array.capacity);

      array.insert(13, 13);

      Assertions.assertEquals(17, array.count);
      Assertions.assertEquals(32, array.capacity);
      Assertions.assertEquals(13, array.getItem(13));
    }

    @Test
    @DisplayName("Should insert item in the tail of array")
    public void shouldInsertItemInTheTailOfArray() {
      DynArray<Integer> array = new DynArray<Integer>(Integer.class);

      array.append(1);
      array.append(2);
      array.append(3);

      array.insert(4, 2);

      Assertions.assertEquals(4, array.count);
      Assertions.assertEquals(3, array.getItem(2));
      Assertions.assertEquals(4, array.getItem(3));
    }
  }
}

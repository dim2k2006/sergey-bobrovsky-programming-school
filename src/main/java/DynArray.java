import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T>
{
  public T [] array;
  public int count;
  public int capacity;
  Class<Integer> clazz;

  public DynArray(Class<Integer> clz)
  {
    clazz = clz; // нужен для безопасного приведения типов
    // new DynArray<Integer>(Integer.class);

    count = 0;
    makeArray(16);
  }

  @SuppressWarnings("unchecked")
  public void makeArray(int new_capacity)
  {
    // ваш код
    if (count == 0) {
      array = (T[]) Array.newInstance(this.clazz, new_capacity);
    }

    T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);

    System.arraycopy(array, 0, newArray, 0, count);

    array = newArray;

    capacity = new_capacity;
    count = getCount(array);
  }

  private int getCount(T[] array) {
    int result = 0;

    for (T item : array) {
      if (item == null) continue;

      result += 1;
    }

    return result;
  }

  public T getItem(int index)
  {
    // ваш код
    return null;
  }

  public void append(T itm)
  {
    // ваш код
  }

  public void insert(T itm, int index)
  {
    // ваш код
  }

  public void remove(int index)
  {
    // ваш код
  }

}
import java.lang.reflect.Array;
import java.util.*;

public class Stack<T> {
  public T[] array;
  Class<Integer> clazz;

  public Stack(Class<Integer> clz) {
    // инициализация внутреннего хранилища стека
    clazz = clz;

    makeArray(0);
  }

  @SuppressWarnings("unchecked")
  public void makeArray(int new_capacity) {
    if (array == null) {
      array = (T[]) Array.newInstance(this.clazz, new_capacity);
    }

    T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);

    System.arraycopy(array, 0, newArray, 0, array.length);

    array = newArray;
  }

  public int size() {
    // размер текущего стека
    return array.length;
  }

  @SuppressWarnings("unchecked")
  public T pop() {
    // ваш код
    if (array.length == 0) {
      return null;
    }

    T result = array[array.length - 1];

    T[] newArray = (T[]) Array.newInstance(this.clazz, array.length - 1);

    System.arraycopy(array, 0, newArray, 0, array.length - 1);

    array = newArray;

    return result;
  }

  public void push(T val) {
    // ваш код
    makeArray(array.length + 1);

    array[array.length - 1] = val;
  }

  public T peek() {
    // ваш код
    if (array.length == 0) {
      return null;
    }

    T result = array[array.length - 1];

    return result;
  }
}
import java.util.*;

public class Stack<T> {
  public StackItem<T>[] array;

  public Stack() {
    // инициализация внутреннего хранилища стека
    makeArray(0);
  }

  public void makeArray(int new_capacity) {
    if (array == null) {
      array = new StackItem[new_capacity];
    }

    StackItem<T>[] newArray = new StackItem[new_capacity];

    System.arraycopy(array, 0, newArray, 0, array.length);

    array = newArray;
  }

  public int size() {
    // размер текущего стека
    return array.length;
  }

  public T pop() {
    // ваш код
    if (array.length == 0) {
      return null;
    }

    StackItem<T> item = array[array.length - 1];

    StackItem<T>[] newArray = new StackItem[array.length - 1];

    System.arraycopy(array, 0, newArray, 0, array.length - 1);

    array = newArray;

    T result = item.value;

    return result;
  }

  public void push(T val) {
    // ваш код
    makeArray(array.length + 1);

    array[array.length - 1] = new StackItem<T>(val);
  }

  public T peek() {
    // ваш код
    if (array.length == 0) {
      return null;
    }

    StackItem<T> result = array[array.length - 1];

    return result.value;
  }
}

class StackItem<T> {
  public T value;

  public StackItem(T val) {
    value = val;
  }
}
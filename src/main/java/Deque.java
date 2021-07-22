import java.util.*;

public class Deque<T> {
  public DequeItem<T>[] array;

  public Deque() {
    // инициализация внутреннего хранилища
    array = new DequeItem[0];
  }

  public void addFront(T item) {
    // добавление в голову
    DequeItem<T>[] newArray = new DequeItem[array.length + 1];

    System.arraycopy(array, 0, newArray, 1, array.length);

    newArray[0] = new DequeItem<T>(item);

    array = newArray;
  }

  public void addTail(T item) {
    // добавление в хвост
    DequeItem<T>[] newArray = new DequeItem[array.length + 1];

    System.arraycopy(array, 0, newArray, 0, array.length);

    newArray[newArray.length - 1] = new DequeItem<T>(item);

    array = newArray;
  }

  public T removeFront() {
    // удаление из головы
    if (array.length == 0) {
      return null;
    }

    DequeItem<T> queueItem = array[0];

    T result = queueItem.value;

    DequeItem<T>[] newArray = new DequeItem[array.length - 1];

    System.arraycopy(array, 1, newArray, 0, array.length - 1);

    array = newArray;

    return result;
  }

  public T removeTail() {
    // удаление из хвоста
    if (array.length == 0) {
      return null;
    }

    DequeItem<T> item = array[array.length - 1];

    DequeItem<T>[] newArray = new DequeItem[array.length - 1];

    System.arraycopy(array, 0, newArray, 0, array.length - 1);

    array = newArray;

    T result = item.value;

    return result;
  }

  public int size() {
    return array.length; // размер очереди
  }
}

class DequeItem<T> {
  public T value;

  public DequeItem(T val) {
    value = val;
  }
}
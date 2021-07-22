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
  }

  public T removeFront() {
    // удаление из головы
    return null;
  }

  public T removeTail() {
    // удаление из хвоста
    return null;
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
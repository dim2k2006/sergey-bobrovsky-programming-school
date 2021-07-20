import java.util.*;

public class Queue<T> {
  public QueueItem<T>[] array;

  public Queue() {
    // инициализация внутреннего хранилища очереди
    array = new QueueItem[0];
  }

  public void enqueue(T item) {
    // вставка в хвост
    QueueItem<T>[] newArray = new QueueItem[array.length + 1];

    System.arraycopy(array, 0, newArray, 0, array.length);

    array = newArray;

    array[array.length - 1] = new QueueItem<T>(item);
  }

  public T dequeue() {
    // выдача из головы
    if (array.length == 0) {
      return null;
    }

    QueueItem<T> queueItem = array[0];

    T result = queueItem.value;

    QueueItem<T>[] newArray = new QueueItem[array.length - 1];

    System.arraycopy(array, 1, newArray, 0, array.length - 1);

    array = newArray;

    return result;
  }

  public int size() {
    return array.length; // размер очереди
  }
}

class QueueItem<T> {
  public T value;

  public QueueItem(T val) {
    value = val;
  }
}
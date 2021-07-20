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
  }

  public T dequeue() {
    // выдача из головы
    return null; // null если очередь пустая
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
import java.util.*;

class Node<T> {
  public T value;
  public Node<T> next, prev;

  public Node(T _value) {
    value = _value;
    next = null;
    prev = null;
  }
}

public class OrderedList<T> {
  public Node<T> head, tail;
  private boolean _ascending;

  public OrderedList(boolean asc) {
    head = null;
    tail = null;
    _ascending = asc;
  }

  public int compare(T v1, T v2) {
    // -1 если v1 < v2
    // 0 если v1 == v2
    // +1 если v1 > v2
    if (v1 < v2) return -1;

    return Integer.compare(v1, v2);
  }

  private void addAfter(Node<T> currentNode, Node<T> nextNode, Node<T> nodeToInsert) {
    if (nextNode == null) {
      currentNode.next = nodeToInsert;
      tail = nodeToInsert;
      tail.prev = currentNode;

      return;
    }

    if (nextNode.value >= nodeToInsert.value) {
      currentNode.next = nodeToInsert;
      nodeToInsert.next = nextNode;
      nodeToInsert.prev = currentNode;
      nextNode.prev = nodeToInsert;

      return;
    }

    addAfter(currentNode.next, nextNode.next, nodeToInsert);
  }

  public void add(T value) {
    // автоматическая вставка value
    // в нужную позицию
    Node<T> node = new Node<T>(value);

    if (count() == 0) {
      head = node;
      head.next = tail;
      tail.prev = head;

      return;
    }

    addAfter(head, head.next, node);
  }

  public Node<T> find(T val) {
    return null; // здесь будет ваш код
  }

  public void delete(T val) {
    // здесь будет ваш код
  }

  public void clear(boolean asc) {
    _ascending = asc;
    // здесь будет ваш код
  }

  private int getCount(Node<T> node) {
    if (node == null) {
      return 0;
    }

    return 1 + getCount(node.next);
  }

  public int count() {
    return getCount(head); // здесь будет ваш код подсчёта количества элементов в списке
  }

  ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
  // списка в виде стандартного списка
  {
    ArrayList<Node<T>> r = new ArrayList<Node<T>>();
    Node<T> node = head;
    while (node != null) {
      r.add(node);
      node = node.next;
    }
    return r;
  }
}
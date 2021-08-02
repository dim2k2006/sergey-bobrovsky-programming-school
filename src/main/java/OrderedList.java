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
    if (v1 instanceof Integer && v2 instanceof Integer) {
      return Integer.compare((Integer) v1, (Integer) v2);
    }

    if (v1 instanceof String && v2 instanceof String) {
      String value1 = ((String) v1).trim();
      String value2 = ((String) v2).trim();

      return value1.compareTo(value2);
    }

    return 0;
  }

  private void addAsc(Node<T> currentNode, Node<T> nextNode, Node<T> nodeToInsert) {
    if (nextNode == null) {
      currentNode.next = nodeToInsert;
      tail = nodeToInsert;
      tail.prev = currentNode;

      return;
    }

    if (compare(nextNode.value, nodeToInsert.value) == 1) {
      currentNode.next = nodeToInsert;
      nodeToInsert.next = nextNode;
      nodeToInsert.prev = currentNode;
      nextNode.prev = nodeToInsert;

      return;
    }

    addAsc(currentNode.next, nextNode.next, nodeToInsert);
  }

  private void addDesc(Node<T> currentNode, Node<T> prevNode, Node<T> nodeToInsert) {
    if (prevNode == null) {
      currentNode.prev = nodeToInsert;
      head = nodeToInsert;
      head.next = currentNode;

      return;
    }

    if (compare(prevNode.value, nodeToInsert.value) == 1) {
      currentNode.prev = nodeToInsert;
      nodeToInsert.prev = prevNode;
      nodeToInsert.next = currentNode;
      prevNode.next = nodeToInsert;

      return;
    }

    addDesc(currentNode.prev, prevNode.prev, nodeToInsert);
  }

  public void add(T value) {
    // автоматическая вставка value
    // в нужную позицию
    Node<T> node = new Node<T>(value);

    int listLength = count();

    if (listLength == 0) {
      node.next = head;
      head = node;
      tail = node;

      return;
    }

    if (_ascending) {
      if (compare(node.value, head.value) == -1) {
        node.next = head;
        head = node;

        return;
      }

      addAsc(head, head.next, node);

      return;
    }

    addDesc(tail, tail.prev, node);
  }

  private Node<T> finByValue(Node<T> currentNode, T val) {
    if (currentNode == null) {
      return null;
    }

    if (currentNode.value == val) {
      return currentNode;
    }

    return finByValue(currentNode.next, val);
  }

  public Node<T> find(T val) {
    return finByValue(head, val);
  }

  private void deleteByValue(Node<T> node, T value) {
    if (node == null) {
      return;
    }

    if (node == head && node == tail && node.value == value) {
      head = null;
      tail = null;

      return;
    }

    if (node == head && node.value == value) {
      node.next.prev = null;
      head = node.next;

      return;
    }

    if (node == tail && node.value == value) {
      tail = node.prev;
      node.prev.next = null;

      return;
    }

    if (node.value == value) {
      node.prev.next = node.next;
      node.next.prev = node.prev;

      return;
    }

    deleteByValue(node.next, value);
  }

  public void delete(T val) {
    // здесь будет ваш код
    deleteByValue(head, val);
  }

  public void clear(boolean asc) {
    _ascending = asc;
    // здесь будет ваш код
    head = null;
    tail = null;
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
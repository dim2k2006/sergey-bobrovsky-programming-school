import java.util.*;

public class LinkedList2 {
  public Node head;
  public Node tail;

  public LinkedList2() {
    head = null;
    tail = null;
  }

  public void addInTail(Node _item) {
    if (head == null) {
      this.head = _item;
      this.head.next = null;
      this.head.prev = null;
    } else {
      this.tail.next = _item;
      _item.prev = tail;
    }
    this.tail = _item;
  }

  private Node findByValue(int value, Node node) {
    if (node == null) {
      return null;
    }

    if (node.value == value) {
      return node;
    }

    return findByValue(value, node.next);
  }

  public Node find(int _value) {
    // здесь будет ваш код поиска
    return findByValue(_value, head);
  }

  private ArrayList<Node> findAllByValue(int value, Node node, ArrayList<Node> accumulator) {
    if (node == null) {
      return accumulator;
    }

    if (node.value == value) {
      accumulator.add(node);
    }

    return findAllByValue(value, node.next, accumulator);
  }

  public ArrayList<Node> findAll(int _value) {
    ArrayList<Node> nodes = new ArrayList<Node>();
    // здесь будет ваш код поиска всех узлов по заданному значению
    return findAllByValue(_value, head, nodes);
  }

  public boolean remove(int _value) {
    // здесь будет ваш код удаления одного узла по заданному значению
    return true; // если узел был удалён
  }

  public void removeAll(int _value) {
    // здесь будет ваш код удаления всех узлов по заданному значению
  }

  public void clear() {
    // здесь будет ваш код очистки всего списка
  }

  public int count() {
    return 0; // здесь будет ваш код подсчёта количества элементов в списке
  }

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
    // здесь будет ваш код вставки узла после заданного узла

    // если _nodeAfter = null
    // добавьте новый элемент первым в списке
  }
}

class Node {
  public int value;
  public Node next;
  public Node prev;

  public Node(int _value) {
    value = _value;
    next = null;
    prev = null;
  }
}
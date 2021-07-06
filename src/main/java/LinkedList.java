import java.util.*;

public class LinkedList {
  public Node head;
  public Node tail;

  public LinkedList() {
    head = null;
    tail = null;
  }

  public void addInTail(Node item) {
    if (this.head == null)
      this.head = item;
    else
      this.tail.next = item;
    this.tail = item;
  }

  public Node find(int value) {
    Node node = this.head;
    while (node != null) {
      if (node.value == value)
        return node;
      node = node.next;
    }
    return null;
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

    // здесь будет ваш код поиска всех узлов

    return findAllByValue(_value, head, nodes);
  }

  private boolean removeNodeByValue(int value, Node node) {
    if (node == null) {
      return false;
    }

    if (node == head && node == tail && node.value == value) {
      head = null;
      tail = null;

      return true;
    }

    if (node == head && node.value == value) {
      head = node.next;

      return true;
    }

    if (node.next != null && node.next == tail && node.next.value == value) {
      tail = node;
      node.next = null;

      return true;
    }

    if (node.next != null && node.next.value == value) {
      node.next = node.next.next;

      return true;
    }

    return removeNodeByValue(value, node.next);
  }

  public boolean remove(int _value) {
    // здесь будет ваш код удаления одного узла по заданному значению
    return removeNodeByValue(_value, head);
  }

  public void removeAll(int _value) {
    // здесь будет ваш код удаления всех узлов по заданному значению
    ArrayList<Node> nodes = findAll(_value);

    for (int i = 0; i < nodes.size(); i += 1) {
      remove(_value);
    }
  }

  public void clear() {
    // здесь будет ваш код очистки всего списка
    head = null;
    tail = null;
  }

  private int getCount(Node node) {
    if (node == null) {
      return 0;
    }

    return 1 + getCount(node.next);
  }

  public int count() {
    return getCount(head); // здесь будет ваш код подсчёта количества элементов в списке
  }

  private void insertAfterNode(Node currentNode, Node nodeAfter, Node nodeToInsert) {
    if (currentNode == null) {
      return;
    }

    if (currentNode == nodeAfter && currentNode == tail) {
      nodeToInsert.next = currentNode.next;
      currentNode.next = nodeToInsert;
      tail = nodeToInsert;

      return;
    }

    if (currentNode == nodeAfter) {
      nodeToInsert.next = currentNode.next;
      currentNode.next = nodeToInsert;

      return;
    }

    insertAfterNode(currentNode.next, nodeAfter, nodeToInsert);
  }

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
    // здесь будет ваш код вставки узла после заданного

    // если _nodeAfter = null ,
    // добавьте новый элемент первым в списке
    if (_nodeAfter == null && tail == null) {

      _nodeToInsert.next = head;
      head = _nodeToInsert;
      tail = _nodeToInsert;

      return;
    }

    if (_nodeAfter == null) {

      _nodeToInsert.next = head;
      head = _nodeToInsert;

      return;
    }

    insertAfterNode(head, _nodeAfter, _nodeToInsert);
  }

}

class Node {
  public int value;
  public Node next;

  public Node(int _value) {
    value = _value;
    next = null;
  }
}
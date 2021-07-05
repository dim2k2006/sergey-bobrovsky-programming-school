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

  public ArrayList<Node> findAll(int _value) {
    ArrayList<Node> nodes = new ArrayList<Node>();
    // здесь будет ваш код поиска всех узлов
    return nodes;
  }

  private boolean removeNodeByValue(int value, Node node) {
    if (node == null || node.next == null) {
      return false;
    }

    if (node.value == value) {
      head = node.next;

      return true;
    }

    if (node.next.value == value) {
      node.next = node.next.next;

      return true;
    }

    return removeNodeByValue(value, node.next);
  }

  public boolean remove(int _value) { // здесь будет ваш код удаления одного узла по заданному значению
    return removeNodeByValue(_value, head);
  }

  public void removeAll(int _value) {
    // здесь будет ваш код удаления всех узлов по заданному значению
  }

  public void clear() {
    // здесь будет ваш код очистки всего списка
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

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
    // здесь будет ваш код вставки узла после заданного

    // если _nodeAfter = null ,
    // добавьте новый элемент первым в списке
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
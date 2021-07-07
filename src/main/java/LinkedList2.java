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
      node.next.prev = null;
      head = node.next;

      return true;
    }

    if (node == tail && node.value == value) {
      tail = node.prev;
      node.prev.next = null;

      return true;
    }

    if (node.value == value) {
      node.prev.next = node.next;
      node.next.prev = node.prev;

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
      nodeToInsert.prev = currentNode;
      nodeToInsert.next = currentNode.next;
      currentNode.next = nodeToInsert;
      tail = nodeToInsert;

      return;
    }

    if (currentNode == nodeAfter) {
      nodeToInsert.prev = currentNode;
      nodeToInsert.next = currentNode.next;
      currentNode.next.prev = nodeToInsert;
      currentNode.next = nodeToInsert;

      return;
    }

    insertAfterNode(currentNode.next, nodeAfter, nodeToInsert);
  }

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
    // здесь будет ваш код вставки узла после заданного узла

    // если _nodeAfter = null
    // добавьте новый элемент первым в списке
    if (_nodeAfter == null && tail == null) {
      _nodeToInsert.next = head;
      head = _nodeToInsert;
      tail = _nodeToInsert;

      return;
    }

    if (_nodeAfter == null) {
      _nodeToInsert.next = head;
      _nodeToInsert.next.prev = _nodeToInsert;
      head = _nodeToInsert;

      return;
    }

    insertAfterNode(head, _nodeAfter, _nodeToInsert);
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
package linkedList2;

import java.util.*;

public class LinkedList2 {
  public linkedList2.Node head;
  public linkedList2.Node tail;

  public LinkedList2() {
    head = null;
    tail = null;
  }

  public void addInTail(linkedList2.Node _item) {
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

  public linkedList2.Node find(int _value) {
    // здесь будет ваш код поиска
    return null;
  }

  public ArrayList<linkedList2.Node> findAll(int _value) {
    ArrayList<linkedList2.Node> nodes = new ArrayList<linkedList2.Node>();
    // здесь будет ваш код поиска всех узлов по заданному значению
    return nodes;
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

  public void insertAfter(linkedList2.Node _nodeAfter, linkedList2.Node _nodeToInsert) {
    // здесь будет ваш код вставки узла после заданного узла

    // если _nodeAfter = null
    // добавьте новый элемент первым в списке
  }
}

class Node {
  public int value;
  public linkedList2.Node next;
  public linkedList2.Node prev;

  public Node(int _value) {
    value = _value;
    next = null;
    prev = null;
  }
}
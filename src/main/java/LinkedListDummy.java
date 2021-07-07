import java.util.*;

public class LinkedListDummy {
  public BaseNode head;
  public BaseNode tail;

  public LinkedListDummy() {
    head = null;
    tail = null;
  }

  private void addDummyNodes() {
    DummyNode dummyHead = new DummyNode();
    DummyNode dummyTail = new DummyNode();

    if (head == null && tail == null) {
      head = dummyHead;
      tail = dummyTail;

      head.next = tail;
      tail.prev = head;
    }

    dummyHead.next = head;
    dummyHead.next.prev = dummyHead;
    head = dummyHead;

    tail.next = dummyTail;
    dummyTail.prev = tail;
    tail = dummyTail;
  }

  private void removeDummyNodes() {
    if (head == null && tail == null) {

    }
  }

  public void addInTail(BaseNode _item) {
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

  public BaseNode find(int _value) {
    // здесь будет ваш код поиска
    return null;
  }

  public ArrayList<BaseNode> findAll(int _value) {
    ArrayList<BaseNode> nodes = new ArrayList<BaseNode>();
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

  public void insertAfter(BaseNode _nodeAfter, BaseNode _nodeToInsert) {
    // здесь будет ваш код вставки узла после заданного узла

    // если _nodeAfter = null
    // добавьте новый элемент первым в списке
  }
}

class BaseNode {
  public int value;
  public BaseNode next;
  public BaseNode prev;

  public BaseNode(int _value) {
    value = _value;
    next = null;
    prev = null;
  }

  public boolean isDummy() {
    return false;
  }
}

class DummyNode extends BaseNode {
  public DummyNode() {
    super(0);
  }

  public boolean isDummy() {
    return true;
  }
}
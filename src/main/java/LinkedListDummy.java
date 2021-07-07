import java.util.*;

public class LinkedListDummy {
  public BaseNode head;
  public BaseNode tail;

  public LinkedListDummy() {
    head = null;
    tail = null;
  }

  public void addInTail(BaseNode _item) {
    tail.setNext(_item);
    _item.setPrev(tail);
    tail = _item;
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
  private int value;
  private BaseNode next;
  private BaseNode prev;

  public BaseNode(int _value) {
    value = _value;
    next = null;
    prev = null;
  }

  public boolean isDummy() {
    return false;
  }

  public int getValue() {
    return value;
  }

  public BaseNode getPrev() {
    if (prev == null) {
      return null;
    }

    if (prev.isDummy()) {
      return null;
    }

    return prev;
  }

  public BaseNode getNext() {
    if (next == null) {
      return null;
    }

    if (next.isDummy()) {
      return null;
    }

    return next;
  }

  public void setPrev(BaseNode _prev) {
    prev = _prev;
  }

  public void setNext(BaseNode _next) {
    next = _next;
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
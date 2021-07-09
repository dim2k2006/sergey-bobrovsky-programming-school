import java.util.*;

public class LinkedListDummy {
  private BaseNode head;
  private BaseNode tail;

  public LinkedListDummy() {
    head = new DummyNode();
    tail = new DummyNode();

    head.setNext(tail);
    tail.setPrev(head);
  }

  public BaseNode getHead() {
    return head.getNext();
  }

  public void setHead(BaseNode node) {
    node.setNext(head.getNextWithDummy());
    node.setPrev(head);
    head.setNext(node);
  }

  public BaseNode getTail() {
    return tail.getPrev();
  }

  public void setTail(BaseNode node) {
    node.setNext(tail);
    node.setPrev(tail.getPrev());
    tail.setPrev(node);
  }

  public void addInTail(BaseNode _item) {
    insertAfter(tail.getPrevWithDummy(), _item);
  }

  private BaseNode findByValue(int value, BaseNode node) {
    if (node == null) {
      return null;
    }

    if (node.getValue() == value) {
      return node;
    }

    return findByValue(value, node.getNextWithDummy());
  }

  public BaseNode find(int _value) {
    return findByValue(_value, getHead());
  }

  private ArrayList<BaseNode> findAllByValue(int value, BaseNode node, ArrayList<BaseNode> accumulator) {
    if (node == null) {
      return accumulator;
    }

    if (node.getValue() == value) {
      accumulator.add(node);
    }

    return findAllByValue(value, node.getNextWithDummy(), accumulator);
  }

  public ArrayList<BaseNode> findAll(int _value) {
    ArrayList<BaseNode> nodes = new ArrayList<BaseNode>();
    // здесь будет ваш код поиска всех узлов по заданному значению
    return findAllByValue(_value, head, nodes);
  }

  private boolean removeNodeByValue(int value, BaseNode node) {
    if (node == null) {
      return false;
    }

    if (node.getValue() == value) {
      node.getPrevWithDummy().setNext(node.getNextWithDummy());
      node.getNextWithDummy().setPrev(node.getPrevWithDummy());

      return true;
    }

    return removeNodeByValue(value, node.getNextWithDummy());
  }

  public boolean remove(int _value) {
    // здесь будет ваш код удаления одного узла по заданному значению
    return removeNodeByValue(_value, head);
  }

  public void removeAll(int _value) {
    // здесь будет ваш код удаления всех узлов по заданному значению
  }

  public void clear() {
    // здесь будет ваш код очистки всего списка
  }

  private int getCount(BaseNode node) {
    if (node == null) {
      return 0;
    }

    if (node.isDummy()) {
      return 0;
    }

    return 1 + getCount(node.getNextWithDummy());
  }

  public int count() {
    return getCount(getHead());
  }

  private void insertAfterNode(BaseNode currentNode, BaseNode nodeAfter, BaseNode nodeToInsert) {
    if (currentNode == null) {
      return;
    }

    if (currentNode == nodeAfter) {
      nodeToInsert.setPrev(currentNode);
      nodeToInsert.setNext(currentNode.getNextWithDummy());
      currentNode.getNextWithDummy().setPrev(nodeToInsert);
      currentNode.setNext(nodeToInsert);

      return;
    }

    insertAfterNode(currentNode.getNextWithDummy(), nodeAfter, nodeToInsert);
  }

  public void insertAfter(BaseNode _nodeAfter, BaseNode _nodeToInsert) {
    insertAfterNode(head, _nodeAfter, _nodeToInsert);
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
    if (prev.isDummy()) {
      return null;
    }

    return prev;
  }

  public BaseNode getPrevWithDummy() {
    return prev;
  }

  public BaseNode getNext() {
    if (next.isDummy()) {
      return null;
    }

    return next;
  }

  public BaseNode getNextWithDummy() {
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
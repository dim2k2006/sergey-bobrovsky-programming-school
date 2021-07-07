//public class LinkedListExtraTask {
//  private static LinkedList zipLists(Node nodeA, Node nodeB, LinkedList accumulator) {
//    if (nodeA == null || nodeB == null) {
//      return accumulator;
//    }
//
//    int valueA = nodeA.value;
//    int valueB = nodeB.value;
//    int sum = valueA + valueB;
//
//    accumulator.addInTail(new Node(sum));
//
//    return zipLists(nodeA.next, nodeB.next, accumulator);
//  }
//
//  public static LinkedList zip(LinkedList listA, LinkedList listB) {
//    if (listA.count() != listB.count()) {
//      return new LinkedList();
//    }
//
//    return zipLists(listA.head, listB.head, new LinkedList());
//  }
//}

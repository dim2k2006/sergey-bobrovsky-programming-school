public class DequePalindrome {
  public static boolean isPalindrome(String str) {
    Deque<String> queue = new Deque<String>();

    String[] parts = str.split("");

    for (String part : parts) {
      queue.addTail(part.toLowerCase());
    }

    if (queue.size() == 1) {
      return true;
    }

    int halfLength = (int) Math.ceil(queue.size() / 2);

    for (int i = 0; i < halfLength; i++) {
      String head = queue.removeFront();
      String tail = queue.removeTail();

      if (head != null && tail == null) {
        return true;
      }

      if (!head.equals(tail)) {
        return false;
      }
    }

    return true;
  }
}

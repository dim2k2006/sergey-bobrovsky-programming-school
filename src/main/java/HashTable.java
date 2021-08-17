public class HashTable {
  public int size;
  public int step;
  public String [] slots;
  public int p = 239017;

  public HashTable(int sz, int stp) {
    size = sz;
    step = stp;
    slots = new String[size];
    for(int i=0; i<size; i++) slots[i] = null;
  }

  public int hashFun(String value) {
    // всегда возвращает корректный индекс слота
    int hash = 0;

    for (int n = 0; n < value.length(); n += 1) {
      int charCode = value.charAt(n);

      if (n == 0) {
        hash = hash + charCode;

        continue;
      }

      int multiplicationResult = (int) ((double) charCode * Math.pow(p, n));

      hash = Math.abs(hash + multiplicationResult);
    }

    int result = hash % size;

    return result;
  }

  public static boolean contains(final int[] array, final int v) {
    for (final int e : array)
      if (e == v) return true;

    return false;
  }

  public static int[] append(int[] array, int value) {
    int[] newArray = new int[array.length + 1];

    for (int i = 0; i < array.length; i++) {
      int val = array[i];

      newArray[i] = val;
    }

    newArray[newArray.length - 1] = value;

    return newArray;
  }

  public int seekSlot(String value) {
    // находит индекс пустого слота для значения, или -1
    int hash = hashFun(value);

    if (slots[hash] == null) {
      return hash;
    }

    int slotIndex = hash + step;
    int[] visitedSlots = new int[]{ hash };

    while (visitedSlots.length != slots.length) {
      if (contains(visitedSlots, slotIndex)) {
        slotIndex = slotIndex + 1;

        continue;
      }

      if (slotIndex > slots.length - 1) {
        slotIndex = slotIndex - slots.length;

        continue;
      }

      String val = slots[slotIndex];

      if (val == null) {
        return slotIndex;
      }

      visitedSlots = append(visitedSlots, slotIndex);

      slotIndex = slotIndex + step;
    }

    return -1;
  }

  public int put(String value) {
    // записываем значение по хэш-функции
    int slotIndex = seekSlot(value);

    if (slotIndex == -1) return -1;

    slots[slotIndex] = value;

    return slotIndex;
  }

  private int findByValue(int slotIndex, int[] visitedSlots, String value) {
    if (visitedSlots.length == slots.length) {
      return -1;
    }

    if (contains(visitedSlots, slotIndex)) {
      return findByValue(slotIndex + 1, visitedSlots, value);
    }

    if (slotIndex > slots.length - 1) {
      return findByValue(slotIndex - slots.length, visitedSlots, value);
    }

    String slotValue = slots[slotIndex];

    if (slotValue == null) {
      return findByValue(slotIndex + step, append(visitedSlots, slotIndex), value);
    }

    if (slotValue.equals(value)) {
      return slotIndex;
    }

    return findByValue(slotIndex + step, append(visitedSlots, slotIndex), value);
  }

  public int find(String value) {
    // находит индекс слота со значением, или -1
    return findByValue(0, new int[0], value);
  }
}
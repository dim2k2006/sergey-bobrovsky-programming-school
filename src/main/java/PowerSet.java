public class PowerSet {
  public int size = 5000;
  public int step = 3;
  public String [] slots;
  public int p = 239017;

  public PowerSet() {
    // ваша реализация хранилища
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

  public int find(String value) {
    // находит индекс слота со значением, или -1
    int slotIndex = 0;
    int[] visitedSlots = new int[0];

    while (visitedSlots.length != slots.length) {
      if (contains(visitedSlots, slotIndex)) {
        slotIndex = slotIndex + 1;

        continue;
      }

      if (slotIndex > slots.length - 1) {
        slotIndex = slotIndex - slots.length;

        continue;
      }

      String slotValue = slots[slotIndex];

      if (slotValue == null) {
        visitedSlots = append(visitedSlots, slotIndex);
        slotIndex = slotIndex + step;

        continue;
      }

      if (slotValue.equals(value)) {
        return slotIndex;
      }

      visitedSlots = append(visitedSlots, slotIndex);
      slotIndex = slotIndex + step;
    }

    return -1;
  }

  public int size() {
    // количество элементов в множестве
    int slotsLength = slots.length;
    int result = 0;

    for (int i = 0; i < slotsLength; i++) {
      String value = slots[i];

      if (value == null) continue;

      result = result + 1;
    }

    return result;
  }

  public void put(String value) {
    // всегда срабатывает
    // записываем значение по хэш-функции
    boolean isValueExists = get(value);

    if (isValueExists) return;

    int slotIndex = seekSlot(value);

    slots[slotIndex] = value;
  }

  public boolean get(String value) {
    // возвращает true если value имеется в множестве,
    // иначе false
    int index = find(value);

    if (index != -1) return true;

    return false;
  }

  public boolean remove(String value) {
    // возвращает true если value удалено
    // иначе false
    boolean isValueExists = get(value);

    if (!isValueExists) return false;

    int slotIndex = find(value);

    slots[slotIndex] = null;

    return true;
  }

  public PowerSet intersection(PowerSet set2) {
      // пересечение текущего множества и set2
      return null;
  }

  public PowerSet union(PowerSet set2) {
      // объединение текущего множества и set2
      return null;
  }

  public PowerSet difference(PowerSet set2) {
      // разница текущего множества и set2
      return null;
  }

  public boolean isSubset(PowerSet set2) {
      // возвращает true, если set2 есть
      // подмножество текущего множества,
      // иначе false
      return false;
  }
}
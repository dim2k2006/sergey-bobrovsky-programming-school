import java.util.*;

public class PowerSet {
  public int slotsSize = 20000;
  public int step = 3;
  public String [] slots;
  public int p = 239017;

  public PowerSet() {
    // ваша реализация хранилища
    slots = new String[slotsSize];
    for(int i=0; i<slotsSize; i++) slots[i] = null;
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

    int result = hash % slotsSize;

    return result;
  }

  public int seekSlot(String value) {
    // находит индекс пустого слота для значения, или -1
    int hash = hashFun(value);

    if (slots[hash] == null) {
      return hash;
    }

    int slotIndex = hash + step;
    Hashtable<Integer, Boolean> visitedSlots = new Hashtable<Integer, Boolean>();

    while (visitedSlots.size() != slots.length) {
      if (visitedSlots.containsKey(slotIndex)) {
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

      visitedSlots.put(slotIndex, true);

      slotIndex = slotIndex + step;
    }

    return -1;
  }

  public int find(String value) {
    // находит индекс слота со значением, или -1
    int slotIndex = 0;
    Hashtable<Integer, Boolean> visitedSlots = new Hashtable<Integer, Boolean>();

    while (visitedSlots.size() != slots.length) {
      if (visitedSlots.containsKey(slotIndex)) {
        slotIndex = slotIndex + 1;

        continue;
      }

      if (slotIndex > slots.length - 1) {
        slotIndex = slotIndex - slots.length;

        continue;
      }

      String slotValue = slots[slotIndex];

      if (slotValue == null) {
        visitedSlots.put(slotIndex, true);
        slotIndex = slotIndex + step;

        continue;
      }

      if (slotValue.equals(value)) {
        return slotIndex;
      }

      visitedSlots.put(slotIndex, true);
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
    int index = find(value);

    if (index != -1) return;

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

  public String getByIndex(int index) {
    return slots[index];
  }

  public PowerSet intersection(PowerSet set2) {
    // пересечение текущего множества и set2
    PowerSet result = new PowerSet();

    for (int i = 0; i < slotsSize; i++) {
      String value = this.getByIndex(i);

      if (value == null) continue;

      if (this.get(value) && set2.get(value)) {
        result.put(value);
      }
    }

    return result;
  }

  public PowerSet union(PowerSet set2) {
      // объединение текущего множества и set2
      PowerSet result = new PowerSet();

      for (int i = 0; i < slotsSize; i++) {
        String value = this.getByIndex(i);

        if (value == null) continue;

        result.put(value);
      }

      for (int i = 0; i < slotsSize; i++) {
        String value = set2.getByIndex(i);

        if (value == null) continue;

        result.put(value);
      }

      return result;
  }

  public PowerSet difference(PowerSet set2) {
    // разница текущего множества и set2
    PowerSet result = new PowerSet();

    for (int i = 0; i < slotsSize; i++) {
      String value = this.getByIndex(i);

      if (value == null) continue;

      if (!set2.get(value)) {
        result.put(value);
      }
    }

    return result;
  }

  public boolean isSubset(PowerSet set2) {
      // возвращает true, если set2 есть
      // подмножество текущего множества,
      // иначе false
      return false;
  }
}
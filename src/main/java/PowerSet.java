import java.util.ArrayList;

public class PowerSet {
  public ArrayList<String> slots;

  public PowerSet() {
    // ваша реализация хранилища
    slots = new ArrayList<String>();
  }

  public int find(String value) {
    // находит индекс слота со значением, или -1
    for (int i = 0; i < slots.size(); i++) {
      String slotValue = slots.get(i);

      if (slotValue == null) {
        continue;
      }

      if (slotValue.equals(value)) {
        return i;
      }
    }

    return -1;
  }

  public int size() {
    // количество элементов в множестве
    int slotsLength = slots.size();
    int result = 0;

    for (int i = 0; i < slotsLength; i++) {
      String value = slots.get(i);

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

    slots.add(value);
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

    slots.set(slotIndex, null);

    return true;
  }

  public String getByIndex(int index) {
    return slots.get(index);
  }

  public PowerSet intersection(PowerSet set2) {
    // пересечение текущего множества и set2
    PowerSet result = new PowerSet();

    for (String value : slots) {
      if (set2.get(value)) {
        result.put(value);
      }
    }

    return result;
  }

  public PowerSet union(PowerSet set2) {
      // объединение текущего множества и set2
      PowerSet result = new PowerSet();

      for (String value : slots) {
        result.put(value);
      }

      for (String value : set2.slots) {
        result.put(value);
      }

      return result;
  }

  public PowerSet difference(PowerSet set2) {
    // разница текущего множества и set2
    PowerSet result = new PowerSet();

    for (String value : slots) {
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
    for (int i = 0; i < set2.size(); i++) {
      String value = set2.getByIndex(i);

      if (!this.get(value)) {
        return false;
      }
    }

    return true;
  }
}
import java.util.ArrayList;

public class BloomFilter {
  public int filter_len;
  public ArrayList<Integer> slots;

  public BloomFilter(int f_len) {
    filter_len = f_len;
    // создаём битовый массив длиной f_len ...
    slots = new ArrayList<Integer>();

    for (int i = 0; i < filter_len; i++) {
      slots.add(0);
    }

    System.out.println("slots.size(): " + slots.size());
  }

  // хэш-функции
  public int hash1(String str1) {
    // 17
    int hash = 0;

    for(int i=0; i<str1.length(); i++) {
        int code = (int)str1.charAt(i);

        hash = (hash * 17) + code;
    }

    int result = hash % filter_len;

    return result;
  }

  public int hash2(String str1) {
    // 223
    int hash = 0;

    for(int i=0; i<str1.length(); i++) {
        int code = (int)str1.charAt(i);

        hash = Math.abs((hash * 223) + code);
    }

    int result = hash % filter_len;

    return result;
  }

  public void add(String value) {
    // добавляем строку str1 в фильтр
    int index1 = hash1(value);
    int index2 = hash2(value);

    System.out.println("value: " + value);
    System.out.println("index1: " + index1);
    System.out.println("index2: " + index2);

    slots.set(index1, 1);
    slots.set(index2, 1);
  }

  public boolean isValue(String value) {
    // проверка, имеется ли строка str1 в фильтре
    int index1 = hash1(value);
    int index2 = hash2(value);

    int value1 = slots.get(index1);
    int value2 = slots.get(index2);

    if (value1 == 1 && value2 == 1) return true;

    return false;
  }
}
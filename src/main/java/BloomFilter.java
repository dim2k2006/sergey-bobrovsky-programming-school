import java.util.BitSet;

public class BloomFilter {
  public int filter_len;
  public BitSet slots;

  public BloomFilter(int f_len) {
    filter_len = f_len;
    // создаём битовый массив длиной f_len ...
    slots = new BitSet(filter_len);
  }

  // хэш-функции
  public int hash1(String str1) {
    // 17
    int hash = 0;

    for(int i=0; i<str1.length(); i++) {
        int code = (int)str1.charAt(i);

        hash = Math.abs((hash * 17) + code);
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

    slots.set(index1);
    slots.set(index2);
  }

  public boolean isValue(String value) {
    // проверка, имеется ли строка str1 в фильтре
    int index1 = hash1(value);
    int index2 = hash2(value);

    if (slots.get(index1) && slots.get(index2)) return true;

    return false;
  }
}
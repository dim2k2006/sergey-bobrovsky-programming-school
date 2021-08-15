import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int p = 239017;

    public NativeDictionary(int sz, Class clazz)
    {
      size = sz;
      slots = new String[size];
      values = (T[]) Array.newInstance(clazz, this.size);
      for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String key)
    {
      // всегда возвращает корректный индекс слота
      int hash = 0;

      for (int n = 0; n < key.length(); n += 1) {
        int charCode = key.charAt(n);

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

    public boolean isKey(String key)
    {
      // возвращает true если ключ имеется,
      // иначе false
      int slotIndex = hashFun(key);

      String foundedKey = slots[slotIndex];

      if (foundedKey != null) return true;

      return false;
    }

    public void put(String key, T value)
    {
      // гарантированно записываем
      // значение value по ключу key
      int slotIndex = hashFun(key);

      slots[slotIndex] = key;
      values[slotIndex] = value;
    }

    public T get(String key)
    {
      // возвращает value для key,
      // или null если ключ не найден
      if (!isKey(key)) return null;

      int slotIndex = hashFun(key);

      T value = values[slotIndex];

      return value;
    }
}
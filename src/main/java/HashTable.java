public class HashTable
  {
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
      size = sz;
      step = stp;
      slots = new String[size];
      for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        // всегда возвращает корректный индекс слота
        int p = 239017;
        int hash = 0;

        for (int i = 0; i < value.length(); i += 1) {
          if (i == 0) {
            hash = hash + (int) value.charAt(i);

            continue;
          }

          int exp = i == 1 ? 1 : i - 1;

          hash = hash + (int) ((double) value.charAt(i) * Math.pow(p, exp));
        }

        int result = hash % size;

        return result;
    }

    public int seekSlot(String value)
    {
         // находит индекс пустого слота для значения, или -1
         return -1;
    }

     public int put(String value)
     {
         // записываем значение по хэш-функции

         // возвращается индекс слота или -1
         // если из-за коллизий элемент не удаётся разместить
         return -1;
     }

     public int find(String value)
     {
         // находит индекс слота со значением, или -1
         return -1;
     }
  }
public class HashTable
  {
    public int size;
    public int step;
    public String [] slots;
    public int p = 239017;

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
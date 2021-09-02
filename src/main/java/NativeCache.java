import java.util.HashMap;

public class NativeCache<T> {
  public int size;
  public HashMap<String, T> values;
  public HashMap<String, Integer> hits;

  public NativeCache(int sz) {
    size = sz;

    values = new HashMap<String, T>();
    hits = new HashMap<String, Integer>();
  }

  public void put(String key, T value) {
    values.put(key, value);
    hits.put(key, 0);
  }

  // public T get(String key) {

  // }

  public int size() {
    return values.size();
  }
}

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
    int currentSize = values.size();
    int nextSize = currentSize + 1;

    if (nextSize <= size) {
      values.put(key, value);
      hits.put(key, 0);

      return;
    }

    String keyWithLowestHits = null;

    for (String hitsKey : hits.keySet()) {
      if (keyWithLowestHits == null) {
        keyWithLowestHits = hitsKey;

        continue;
      }

      if (hits.get(hitsKey) < hits.get(keyWithLowestHits)) {
        keyWithLowestHits = hitsKey;
      }
    }

    values.remove(keyWithLowestHits);
    hits.remove(keyWithLowestHits);

    values.put(key, value);
    hits.put(key, 0);
  }

  public T get(String key) {
    if (!values.containsKey(key)) return null;

    int hitsCount = hits.get(key);

    hits.put(key, hitsCount + 1);

    return values.get(key);
  }

  public int getHitsByKey(String key) {
    return hits.get(key);
  }

  public int size() {
    return values.size();
  }
}

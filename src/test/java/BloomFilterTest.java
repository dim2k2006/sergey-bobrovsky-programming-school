import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class BloomFilterTest {
  public int filterSize = 32;
  public ArrayList<String> testValues = new ArrayList<String>();

  @Test
  @DisplayName("Should add value to filter")
  void shouldAddValueToFilter() {
    BloomFilter filter = new BloomFilter(filterSize);

    testValues.add("0123456789");
    testValues.add("1234567890");
    testValues.add("2345678901");
    testValues.add("3456789012");
    testValues.add("4567890123");
    testValues.add("5678901234");
    testValues.add("6789012345");
    testValues.add("7890123456");
    testValues.add("8901234567");
    testValues.add("9012345678");

    testValues.forEach(value -> {
      filter.add(value);
    });

    testValues.forEach(value -> {
      Assertions.assertTrue(filter.isValue(value));
    });
  }
}

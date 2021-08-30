import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BloomFilterTest {
  public int filterSize = 32;

  @Test
  @DisplayName("Should add value to filter")
  void shouldAddValueToFilter() {
    Faker faker = new Faker();
    BloomFilter filter = new BloomFilter(filterSize);

    String word = faker.lorem().word();

    filter.add(word);

    Assertions.assertTrue(filter.isValue(word));
  }
}

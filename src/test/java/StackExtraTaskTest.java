import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StackExtraTaskTest {
  @Test
  @DisplayName("Should return 59")
  void shouldReturn59() {
    int result = StackExtraTask.calculate("8 2 + 5 * 9 +");

    Assertions.assertEquals(59, result);
  }
}

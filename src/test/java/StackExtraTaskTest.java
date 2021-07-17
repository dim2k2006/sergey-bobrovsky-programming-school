import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StackExtraTaskTest {
  public String[][] testCases = new String[][]{
    { "8 2 + 5 * 9 +", "59" },
    { "13 2 * 10 + 2 *", "72" },
    { "19 16 + 2 + 8 +", "45" },
    { "14 8 * 4 * 19 *", "8512" },
  };

  @Test
  @DisplayName("Should calculate the expression")
  void ShouldCalculateTheExpression() {
    for (String[] testCase : testCases) {
      int result = StackExtraTask.calculate(testCase[0]);

      Assertions.assertEquals(Integer.parseInt(testCase[1]), result);
    }
  }
}

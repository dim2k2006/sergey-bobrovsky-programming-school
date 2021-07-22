import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DequePalindromeTest {
  @Test
  @DisplayName("Should find palindrome")
  void shouldFindPalindrome() {
    Assertions.assertTrue(DequePalindrome.isPalindrome("anna"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Civic"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Level"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Radar"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Noon"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Aibohphobia"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Racecar"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Lemel"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Sagas"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("Tenet"));
    Assertions.assertTrue(DequePalindrome.isPalindrome("b"));

    Assertions.assertFalse(DequePalindrome.isPalindrome("Hello"));
    Assertions.assertFalse(DequePalindrome.isPalindrome("same"));
    Assertions.assertFalse(DequePalindrome.isPalindrome("partial"));
    Assertions.assertFalse(DequePalindrome.isPalindrome("school"));
    Assertions.assertFalse(DequePalindrome.isPalindrome("palindrome"));
  }
}

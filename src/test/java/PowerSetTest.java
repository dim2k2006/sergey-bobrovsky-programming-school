import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PowerSetTest {
  @Nested
  @DisplayName("size method")
  class SizeMethod {
    @Test
    @DisplayName("Should return size of set")
    void shouldReturnSizeOfSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      Assertions.assertEquals(0, set.size());

      set.put(faker.lorem().word());
      set.put(faker.lorem().word());
      set.put(faker.lorem().word());

      Assertions.assertEquals(3, set.size());
    }
  }

  @Nested
  @DisplayName("put method")
  class PutMethod {
    @Test
    @DisplayName("Should put item to set")
    void shouldPutItemToSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      Assertions.assertEquals(0, set.size());

      set.put(faker.lorem().word());

      Assertions.assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Should not create duplicates in set")
    void shouldNotCreateDuplicatesInSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      String value = faker.lorem().word();

      Assertions.assertEquals(0, set.size());

      set.put(value);
      set.put(value);

      Assertions.assertEquals(1, set.size());
    }
  }

  @Nested
  @DisplayName("remove method")
  class RemoveMethod {
    @Test
    @DisplayName("Should remove item from set")
    void shouldRemoveItemFromSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      String value = faker.lorem().word();

      Assertions.assertEquals(0, set.size());

      set.put(value);

      Assertions.assertEquals(1, set.size());
      Assertions.assertNotEquals(-1, set.find(value));

      Assertions.assertTrue(set.remove(value));
      Assertions.assertEquals(0, set.size());
      Assertions.assertEquals(-1, set.find(value));
    }

    @Test
    @DisplayName("Should not remove not existing item from set")
    void shouldNotRemoveNotExistingItemFromSet() {
      Faker faker = new Faker();
      PowerSet set = new PowerSet();

      String value1 = faker.lorem().word();
      String value2 = faker.lorem().word();

      set.put(value1);

      set.remove(value2);

      Assertions.assertEquals(1, set.size());
      Assertions.assertTrue(set.get(value1));
      Assertions.assertFalse(set.get(value2));
    }
  }

  @Nested
  @DisplayName("intersection method")
  class IntersectionMethod {
    @Test
    @DisplayName("Should find intersection of sets")
    void shouldFindIntersectionOfSets() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> words = faker.lorem().words(randomBound);

      PowerSet commonWords = new PowerSet();

      words.forEach(value -> {
        set1.put(value);
        set2.put(value);
        commonWords.put(value);
      });

      List<String> set1Words = faker.lorem().words(randomBound);
      List<String> set2Words = faker.lorem().words(randomBound);

      set1Words.forEach(value -> {
        set1.put(value);
      });

      set2Words.forEach(value -> {
        set2.put(value);
      });

      PowerSet set3 = set1.intersection(set2);

      for (int i = 0; i < set3.size(); i++) {
        String value = set3.getByIndex(i);

        Assertions.assertTrue(set1.get(value));
        Assertions.assertTrue(set2.get(value));
      }
    }

    @Test
    @DisplayName("Should find intersection of sets where first set is empty")
    void shouldFindIntersectionOfSetsWhereFirstSetIsEmpty() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();
      PowerSet wordsSet = new PowerSet();

      int randomBound = 100;

      List<String> words = faker.lorem().words(randomBound);

      words.forEach(value -> {
        set2.put(value);
        wordsSet.put(value);
      });

      PowerSet set3 = set1.intersection(set2);

      Assertions.assertEquals(0, set3.size());
    }

    @Test
    @DisplayName("Should find intersection of sets where second set is empty")
    void shouldFindIntersectionOfSetsWhereSecondSetIsEmpty() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();
      PowerSet wordsSet = new PowerSet();

      int randomBound = 100;

      List<String> words = faker.lorem().words(randomBound);

      words.forEach(value -> {
        set1.put(value);
        wordsSet.put(value);
      });

      PowerSet set3 = set1.intersection(set2);

      Assertions.assertEquals(0, set3.size());
    }

    @Test
    @DisplayName("Should find intersection of sets where boths sets are empty")
    void shouldFindIntersectionOfSetsWhereBothsSetsAreEmpty() {
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      PowerSet set3 = set1.intersection(set2);

      Assertions.assertEquals(0, set3.size());
    }
  }

  @Nested
  @DisplayName("union method")
  class UnionMethod {
    @Test
    @DisplayName("Should unite sets")
    void shouldUniteSets() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> words1 = faker.lorem().words(randomBound);
      List<String> words2 = faker.lorem().words(randomBound);

      words1.forEach(value -> {
        set1.put(value);
      });

      words2.forEach(value -> {
        set2.put(value);
      });

      PowerSet set3 = set1.union(set2);

      for (int i = 0; i < set1.size(); i++) {
        String value = set1.getByIndex(i);

        Assertions.assertTrue(set3.get(value));
      }

      for (int i = 0; i < set2.size(); i++) {
        String value = set2.getByIndex(i);

        Assertions.assertTrue(set3.get(value));
      }
    }

    @Test
    @DisplayName("Should unite sets where first set is empty")
    void shouldUniteSetsWhereFirstSetIsEmpty() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> words2 = faker.lorem().words(randomBound);

      words2.forEach(value -> {
        set2.put(value);
      });

      PowerSet set3 = set1.union(set2);

      for (int i = 0; i < set1.size(); i++) {
        String value = set1.getByIndex(i);

        Assertions.assertTrue(set3.get(value));
      }

      for (int i = 0; i < set2.size(); i++) {
        String value = set2.getByIndex(i);

        Assertions.assertTrue(set3.get(value));
      }
    }

    @Test
    @DisplayName("Should unite sets where second set is empty")
    void shouldUniteSetsWhereSecondSetIsEmpty() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> words1 = faker.lorem().words(randomBound);

      words1.forEach(value -> {
        set1.put(value);
      });

      PowerSet set3 = set1.union(set2);

      for (int i = 0; i < set1.size(); i++) {
        String value = set1.getByIndex(i);

        Assertions.assertTrue(set3.get(value));
      }

      for (int i = 0; i < set2.size(); i++) {
        String value = set2.getByIndex(i);

        Assertions.assertTrue(set3.get(value));
      }
    }

    @Test
    @DisplayName("Should unite sets where both sets are empty")
    void shouldUniteSetsWhereBothSetsAreEmpty() {
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      PowerSet set3 = set1.union(set2);

      Assertions.assertEquals(0, set3.size());
    }
  }

  @Nested
  @DisplayName("difference method")
  class DifferenceMethod {
    @Test
    @DisplayName("Should find diff between two sets")
    void shouldFindDiffBetweenTwoSets() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> words1 = faker.lorem().words(randomBound);
      List<String> words2 = faker.lorem().words(randomBound);

      words1.forEach(value -> {
        set1.put(value);
      });

      words2.forEach(value -> {
        set2.put(value);
      });

      PowerSet set3 = set1.difference(set2);

      for (int i = 0; i < set3.size(); i++) {
        String value = set3.getByIndex(i);

        Assertions.assertFalse(set2.get(value));
      }
    }

    @Test
    @DisplayName("Should find diff between two sets where first set is empty")
    void shouldFindDiffBetweenTwoSetsWhereFirstSetIsEmpty() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> words2 = faker.lorem().words(randomBound);

      words2.forEach(value -> {
        set2.put(value);
      });

      PowerSet set3 = set1.difference(set2);

      Assertions.assertEquals(0, set3.size());
    }

    @Test
    @DisplayName("Should find diff between two sets where second set is empty")
    void shouldFindDiffBetweenTwoSetsWhereSecondSetIsEmpty() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> words1 = faker.lorem().words(randomBound);

      words1.forEach(value -> {
        set1.put(value);
      });

      PowerSet set3 = set1.difference(set2);

      Assertions.assertEquals(set1.size(), set3.size());
    }

    @Test
    @DisplayName("Should find diff between two sets where both sets are empty")
    void shouldFindDiffBetweenTwoSetsWhereBothSetsAreEmpty() {
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      PowerSet set3 = set1.difference(set2);

      Assertions.assertEquals(0, set3.size());
    }
  }

  @Nested
  @DisplayName("isSubset method")
  class IsSubsetMethod {
    @Test
    @DisplayName("Should find subset")
    void shouldFindSubset() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> commonWords = faker.lorem().words(randomBound);
      List<String> words1 = faker.lorem().words(randomBound);

      commonWords.forEach(value -> {
        set1.put(value);
        set2.put(value);
      });

      words1.forEach(value -> {
        set1.put(value);
      });

      Assertions.assertTrue(set1.isSubset(set2));
    }

    @Test
    @DisplayName("Should not find subset")
    void shouldNotFindSubset() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> commonWords = faker.lorem().words(randomBound);
      List<String> words2 = faker.lorem().words(randomBound);

      commonWords.forEach(value -> {
        set1.put(value);
        set2.put(value);
      });

      words2.forEach(value -> {
        set2.put(value);
      });

      Assertions.assertFalse(set1.isSubset(set2));
    }

    @Test
    @DisplayName("Should find subset where first set is empty")
    void shouldFindSubsetWhereFirstSetIsEmpty() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> commonWords = faker.lorem().words(randomBound);

      commonWords.forEach(value -> {
        set2.put(value);
      });

      Assertions.assertFalse(set1.isSubset(set2));
    }

    @Test
    @DisplayName("Should find subset where second set is empty")
    void shouldFindSubsetWhereSecondSetIsEmpty() {
      Faker faker = new Faker();
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      int randomBound = 100;

      List<String> commonWords = faker.lorem().words(randomBound);
      List<String> words1 = faker.lorem().words(randomBound);

      commonWords.forEach(value -> {
        set1.put(value);
      });

      words1.forEach(value -> {
        set1.put(value);
      });

      Assertions.assertTrue(set1.isSubset(set2));
    }

    @Test
    @DisplayName("Should find subset where both sets are empty")
    void shouldFindSubsetWhereBothSetsAreEmpty() {
      PowerSet set1 = new PowerSet();
      PowerSet set2 = new PowerSet();

      Assertions.assertTrue(set1.isSubset(set2));
    }
  }
}

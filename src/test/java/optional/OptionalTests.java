package optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class OptionalTests {
  @Test
  void empty() {
    Optional<String> empty = Optional.empty();
    assertFalse(empty.isPresent());
  }

  @Test
  void of() {
    String v = "any";
    Optional<String> value = Optional.of(v);
    assertTrue(value.isPresent());
  }

  @Test
  void of_2() {
    String v = null;
    assertThrows(NullPointerException.class, () -> Optional.of(v));
  }

  @Test
  void ofNullable() {
    String v = null;
    Optional<String> value = Optional.ofNullable(v);
    assertFalse(value.isPresent());
  }

  @Test
  void get() {
    String v = "any";
    Optional<String> value = Optional.ofNullable(v);
    assertEquals(v, value.get());
  }

  @Test
  void get_2() {
    String v = null;
    Optional<String> value = Optional.ofNullable(v);
    assertThrows(NoSuchElementException.class, () -> value.get());
  }

  @Test
  void orElseGet() {
    String v = null;
    String v2 = Optional.ofNullable(v).orElseGet(String::new);
    assertTrue(v2.isEmpty());
  }

  @Test
  void orElse() {
    String v = null;
    String v2 = Optional.ofNullable(v).orElse("");
    assertTrue(v2.isEmpty());
  }

  @Test
  void orElseThrow() {
    String v = null;
    assertThrows(IllegalArgumentException.class,
        () -> Optional.ofNullable(v).orElseThrow(IllegalArgumentException::new));
  }

  @Test
  void ifPresent() {
    String v = "any";
    Optional<String> value = Optional.of(v);
    value.ifPresent(s -> assertEquals(s, v)); // conditional action
  }

  @Test
  void ifPresentOrElse() {
    String v = "any";
    Optional<String> value = Optional.of(v);
    value.ifPresentOrElse(s -> assertEquals(s, v), () -> System.out.println("not found")); // Java 9
  }

  @Test
  void filter() {
    int number = 1;
    Optional<Integer> value = Optional.of(number).filter(n -> n == 1);
    assertTrue(value.isPresent());
  }

  @Test
  void filter_2() {
    int number = 1;
    Optional<Integer> value = Optional.of(number).filter(n -> n == 2);
    assertFalse(value.isPresent()); // empty
  }

  @Test
  void map() {

  }

  @Test
  void flatMap() {

  }

  @Test
  void stream() { // Java 9

  }

  @Test
  void or() { // Java 9
  }
}
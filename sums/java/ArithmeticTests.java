import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArithmeticTests {
  @Test
  public void sumTest() {
    assertEquals(Arithmetic.sum(3, 4), 7, 0.0);
  }
}
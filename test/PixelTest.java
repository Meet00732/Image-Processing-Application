import org.junit.Test;

import java.util.Random;

import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * The PixelTest class contains JUnit tests for the Pixel
 * class, which represents a single pixel in an image with
 * red, green, and blue color components.
 */
public class PixelTest {

  /**
   * Clamp works correctly when red, green, blue < 0.
   */
  @Test
  public void testClampPixelNegative() {
    Pixel pixel = new Pixel(-20, -15, -12);
    assertEquals(0, pixel.getRed());
    assertEquals(0, pixel.getGreen());
    assertEquals(0, pixel.getBlue());
  }

  /**
   * Clamp works correctly when red, green, blue > 255.
   */
  @Test
  public void testClampPixelGreaterThan255() {
    Pixel pixel = new Pixel(1000, 535, 256);
    assertEquals(255, pixel.getRed());
    assertEquals(255, pixel.getGreen());
    assertEquals(255, pixel.getBlue());
  }

  /**
   * Clamps an integer value to the range [0, 255].
   * If the input value is less than 0, it is set to 0.
   * If the input value is greater than 255, it is set to 255.
   * Otherwise, the input value remains unchanged.
   *
   * @param value The integer value to clamp.
   * @return The clamped value within the range [0, 255].
   */
  private int clamp(int value) {
    if (value < 0) {
      value = 0;
    } else if (value > 255) {
      value = 255;
    }
    return value;
  }

  /**
   * Fuzzy Pixel test.
   */
  @Test
  public void testFuzzyTest() {
    Random r = new Random();

    for (int i = 0; i < 10000; i++) {
      int red = r.nextInt();
      int green = r.nextInt();
      int blue = r.nextInt();

      Pixel pixel = new Pixel(red, green, blue);

      red = clamp(red);
      green = clamp(green);
      blue = clamp(blue);

      assertEquals(red, pixel.getRed());
      assertEquals(green, pixel.getGreen());
      assertEquals(blue, pixel.getBlue());
    }
  }
}
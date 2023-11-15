import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import view.ImageView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * The ImageViewTest class contains JUnit tests for the ImageView class, which represents
 * the view in the image processing application.
 */
public class ImageViewTest {
  private final ByteArrayOutputStream outResult = new ByteArrayOutputStream();

  private final PrintStream out = System.out;

  /**
   * Set up the initial state for testing by redirecting
   * the standard output to capture printed messages.
   */
  @Before
  public void setup() {
    System.setOut(new PrintStream(outResult));
  }

  /**
   * Reset the standard output to its original state after testing.
   */
  @After
  public void reset() {
    System.setOut(out);
  }

  /**
   * Test Constructor.
   */
  @Test
  public void testConstructor() {
    try {
      new ImageView();
    } catch (Exception e) {
      fail("This test should have passed!");
    }
  }

  /**
   * Test the getCommand method for reading user input.
   */
  @Test
  public void testGetCommand() {
    String inputCommand = "load sample.png testImage";
    ByteArrayInputStream inResult = new ByteArrayInputStream(inputCommand.getBytes());
    System.setIn(inResult);

    ImageView view = new ImageView();
    assertEquals(inputCommand, view.getCommand());
  }

  /**
   * Test the display method for printing messages to the standard output.
   */
  @Test
  public void testDisplay() {
    String message = "display message!";

    ImageView view = new ImageView();
    view.display(message);

    assertEquals(message + System.lineSeparator(), outResult.toString());
  }
}
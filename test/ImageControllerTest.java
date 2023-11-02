import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import controller.ImageController;
import controller.ImageControllerInterface;

import model.MockModel;
import view.ImageView;
import view.ImageViewInterface;

import static org.junit.Assert.*;

public class ImageControllerTest {

  private final ByteArrayOutputStream outResult = new ByteArrayOutputStream();

  private final PrintStream out = System.out;

  @Before
  public void setup() {
    System.setOut(new PrintStream(outResult));
  }

  @After
  public void reset() {
    System.setOut(out);
  }

  /**
   * Test redComponentCommand.
   */
  @Test
  public void testControllerRedComponentMethodMock() {
    String inputData = "red-component testNYC testRed\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "red-component executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("redComponentCommand method is invoked!"));
  }

  /**
   * Test greenComponentCommand.
   */
  @Test
  public void testControllerGreenComponentMethodMock() {
    String inputData = "green-component testNYC testGreen\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "green-component executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("greenComponentCommand method is invoked!"));
  }

  /**
   * Test blueComponentCommand.
   */
  @Test
  public void testControllerBlueComponentMethodMock() {
    String inputData = "blue-component testNYC testBlue\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "blue-component executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("blueComponentCommand method is invoked!"));
  }

  /**
   * Test valueComponentCommand.
   */
  @Test
  public void testControllerValueComponentMethodMock() {
    String inputData = "value-component testNYC testValue\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "value-component executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("valueComponentCommand method is invoked!"));
  }

  /**
   * Test intensityComponentCommand.
   */
  @Test
  public void testControllerIntensityComponentMethodMock() {
    String inputData = "intensity-component testNYC testIntensity\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "intensity-component executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("intensityComponentCommand method is invoked!"));
  }

  /**
   * Test lumaComponentCommand.
   */
  @Test
  public void testControllerLumaComponentMethodMock() {
    String inputData = "luma-component testNYC testLuma\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "luma-component executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("lumaComponentCommand method is invoked!"));
  }


  /**
   * Test brightenComponentCommand.
   */
  @Test
  public void testControllerBrightenMethodMock() {
    String inputData = "brighten 30 testNYC testBrighten\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "brighten executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("brightenCommand method is invoked!"));
  }

  /**
   * Test brightenCommand Neg30.
   */
  @Test
  public void testControllerNegBrightenMethodMock() {
    String inputData = "brighten -30 testNYC testBrighten\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "brighten executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("brightenCommand method is invoked!"));
  }

  /**
   * Test blurCommand Neg30.
   */
  @Test
  public void testControllerBlurMethodMock() {
    String inputData = "blur testNYC testBlur\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "blur executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("blurCommand method is invoked!"));
  }


  /**
   * Test sepiaCommand
   */
  @Test
  public void testControllerSepiaMethodMock() {
    String inputData = "sepia testNYC testSepia\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "sepia executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("sepiaCommand method is invoked!"));
  }


  /**
   * Test combineCommand
   */
  @Test
  public void testControllerRGBCombineMethodMock() {
    String inputData = "rgb-combine testCombineNYC testRed testGreen testBlue\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "rgb-combine executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("combineCommand method is invoked!"));
  }


  /**
   * Test sharpenCommand
   */
  @Test
  public void testControllerSharpenMethodMock() {
    String inputData = "sharpen testSharpenNYC testBlue\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "sharpen executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("sharpenCommand method is invoked!"));
  }

  /**
   * Test verticalFlipCommand
   */
  @Test
  public void testControllerVerticalFlipMethodMock() {
    String inputData = "vertical-flip testSharpenNYC testBlue\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "vertical-flip executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("verticalFlipCommand method is invoked!"));
  }

  /**
   * Test horizontalFlipCommand
   */
  @Test
  public void testControllerHorizontalFlipMethodMock() {
    String inputData = "horizontal-flip testSharpenNYC testBlue\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "horizontal-flip executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("horizontalFlipCommand method is invoked!"));
  }

  /**
   * Test runCommand
   */
  @Test
  public void testControllerRunCommand() {
    String lineSeparator = System.lineSeparator();
    String inputData = "run F:\\PDP_Assignments\\Assignment4_MVC\\test\\input.txt\nq";

    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    ImageControllerInterface controller = new ImageController(view, model);
    String expectedResult = "load executed successfully" + lineSeparator +
            "save executed successfully" + lineSeparator +
            "blur executed successfully" + lineSeparator +
            "sharpen executed successfully" + lineSeparator +
            "sepia executed successfully" + lineSeparator +
            "red-component executed successfully" + lineSeparator +
            "green-component executed successfully" + lineSeparator +
            "blue-component executed successfully" + lineSeparator +
            "value-component executed successfully" + lineSeparator +
            "intensity-component executed successfully" + lineSeparator +
            "luma-component executed successfully" + lineSeparator +
            "brighten executed successfully" + lineSeparator +
            "brighten executed successfully" + lineSeparator +
            "brighten executed successfully" + lineSeparator +
            "brighten executed successfully" + lineSeparator +
            "rgb-split executed successfully" + lineSeparator +
            "rgb-combine executed successfully" + lineSeparator +
            "vertical-flip executed successfully" + lineSeparator +
            "horizontal-flip executed successfully" + lineSeparator +
            "run executed successfully";

    String mockModelLog =
            "blurCommand method is invoked!" +
            "sharpenCommand method is invoked!" +
            "sepiaCommand method is invoked!" +
            "redComponentCommand method is invoked!" +
            "greenComponentCommand method is invoked!" +
            "blueComponentCommand method is invoked!" +
            "valueComponentCommand method is invoked!" +
            "intensityComponentCommand method is invoked!" +
            "lumaComponentCommand method is invoked!" +
            "brightenCommand method is invoked!" +
            "brightenCommand method is invoked!" +
            "brightenCommand method is invoked!" +
            "brightenCommand method is invoked!" +
            "rgbSplitCommand method is invoked!" +
            "combineCommand method is invoked!" +
            "verticalFlipCommand method is invoked!" +
            "horizontalFlipCommand method is invoked!";
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }

    assertEquals(expectedResult.trim(), outResult.toString().trim());
    assertTrue(model.getLog().contains(mockModelLog));
  }


  /**
   * Test invalid command enter.
   */
  @Test
  public void testIncorrectCommand() {
    String inputData = "orange-component testNYC testOrange\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult = null;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
      expectedResult = "Please enter correct command format" + System.lineSeparator() +
              "error executing orange-component";
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
  }

  /**
   * Test when view = null passed as parameter.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testViewNull() {
    String inputData = "red-component testNYC testRed\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = null;
    MockModel model = new MockModel();
    new ImageController(view, model);
    fail("this test should have failed!");
  }

  /**
   * Test when model = null passed as parameter.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testModelNull() {
    String inputData = "red-component testNYC testRed\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = null;
    new ImageController(view, model);
    fail("this test should have failed!");
  }

  /**
   * Test runCommand
   */
  @Test
  public void testControllerIncorrectFilePathRunCommand() {
    String inputData = "run F:\\PDP_Assignments\\Assignment4_MVC\\test\\put.txt\nq";

    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    ImageControllerInterface controller = new ImageController(view, model);

    controller.process();
    String expectedResult = "Please enter correct command format" + System.lineSeparator() +
            "error executing run";

    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());

  }


  /**
   * Test loadCommand.
   */
  @Test
  public void testControllerLoadMethodMock() {
    String inputData = "load test\\nyc.png testNYC\nq";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);

    ImageViewInterface view = new ImageView();
    MockModel model = new MockModel();
    String expectedResult;
    ImageControllerInterface controller = new ImageController(view, model);
    try {
      controller.process();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
    expectedResult = "load executed successfully";
    assertEquals(expectedResult + System.lineSeparator(), outResult.toString());
    assertTrue(model.getLog().contains("AddImage method is invoked!"));
  }

}
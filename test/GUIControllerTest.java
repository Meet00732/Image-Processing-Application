import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import controller.GUIController;
import model.ImageModelInterface;
import model.MockModel;
import view.GUIInterface;
import view.GUIView;
import view.MockView;

import static org.junit.Assert.*;

public class GUIControllerTest {

  private GUIController controller;
  private GUIInterface mockView;
  private ImageModelInterface model;

  @Before
  public void setUp() {
    model = new MockModel();
    mockView = new MockView();
    controller = new GUIController(mockView, model);
    mockView.addFeatures(controller);
  }

  @After
  public void cleanUp() {
    MockView.clearLog();
  }

  /**
   * testing LoadButton.
   */
  @Test
  public void testLoadButton() {
    controller.loadButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n" +
            "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * testing LoadButton with confirmationPrompt.
   */
  @Test
  public void testLoadConfirmationButton() {
    controller.loadButton();
    controller.loadButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "confirmImageLoad method is invoked!\n"
            + "loadImagePath method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing SaveButton.
   */
  @Test
  public void testSaveButton() {
    controller.loadButton();
    controller.saveButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "saveImagePath method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing BlurButton.
   */
  @Test
  public void testBlurButton() {
    controller.loadButton();
    controller.blurButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "promptPercentage method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing BlurButton then LoadButton.
   */
  @Test
  public void testBlurThenLoadButton() {
    controller.loadButton();
    controller.blurButton();
    controller.loadButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "promptPercentage method is invoked!\n"
            + "display method is invoked!\n"
            + "confirmImageLoad method is invoked!\n"
            + "loadImagePath method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing sepiaButton.
   */
  @Test
  public void testSepiaButton() {
    controller.loadButton();
    controller.sepiaButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "promptPercentage method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing lumaButton.
   */
  @Test
  public void testLumaButton() {
    controller.loadButton();
    controller.lumaButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "promptPercentage method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing redButton.
   */
  @Test
  public void testRedButton() {
    controller.loadButton();
    controller.redButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing greenButton.
   */
  @Test
  public void testGreenButton() {
    controller.loadButton();
    controller.greenButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing blueButton.
   */
  @Test
  public void testBlueButton() {
    controller.loadButton();
    controller.greenButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing compressButton.
   */
  @Test
  public void testCompressButton() {
    controller.loadButton();
    controller.compressButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "promptPercentage method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing adjustLevelsButton.
   */
  @Test
  public void testAdjustLevelsButton() {
    controller.loadButton();
    controller.adjustLevelsButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "promptForAdjustLevels method is invoked!\n"
            + "promptPercentage method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing colorCorrectionButton.
   */
  @Test
  public void testColorCorrectedButton() {
    controller.loadButton();
    controller.colorCorrectedButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "promptPercentage method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing sharpenButton.
   */
  @Test
  public void testSharpenButton() {
    controller.loadButton();
    controller.sharpenButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "promptPercentage method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing horizontalFlipButton.
   */
  @Test
  public void testHorizontalFlipButton() {
    controller.loadButton();
    controller.horizontalFlipButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

  /**
   * Testing verticalFlipButton.
   */
  @Test
  public void testVerticalFlipButton() {
    controller.loadButton();
    controller.verticalFlipButton();
    String res = MockView.getLog();

    String expectedResult = "loadImagePath method is invoked!\n"
            + "display method is invoked!\n"
            + "display method is invoked!\n";

    assertEquals(expectedResult, res);
  }

}
import org.junit.Before;
import org.junit.Test;

import controller.commands.AbstractBaseCommand;
import controller.commands.BlueComponentCommand;
import controller.commands.BlurCommand;
import controller.commands.BrightenCommand;
import controller.commands.CombineCommand;
import controller.commands.GreenComponentCommand;
import controller.commands.HorizontalFlipCommand;
import controller.commands.IntensityComponentCommand;
import controller.commands.LumaComponentCommand;
import controller.commands.RGBSplit;
import controller.commands.RedComponentCommand;
import controller.commands.SepiaCommand;
import controller.commands.SharpenCommand;
import controller.commands.ValueComponentCommand;
import controller.commands.VerticalFlipCommand;

import model.MockModel;

import static org.junit.Assert.*;

public class ImageControllerTest {


  MockModel mockModel;

  @Before
  public void setup() {
    mockModel = new MockModel();
    mockModel.clearLog();
  }


  /**
   * Test redComponentCommand.
   */
  @Test
  public void testRedComponentCommand() {
    AbstractBaseCommand feature = new RedComponentCommand(mockModel,
            "imagePath", "imageName");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("redComponentCommand method is invoked!", result);
  }

  /**
   * Test greenComponentCommand.
   */
  @Test
  public void testGreenComponentCommand() {
    AbstractBaseCommand feature = new GreenComponentCommand(mockModel,
            "imagePath", "imageName");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("greenComponentCommand method is invoked!", result);
  }

  /**
   * Test blueComponentCommand.
   */
  @Test
  public void testBlueComponentCommand() {
    AbstractBaseCommand feature = new BlueComponentCommand(mockModel,
            "imagePath", "imageName");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("blueComponentCommand method is invoked!", result);
  }

  /**
   * Test valueComponentCommand.
   */
  @Test
  public void testValueComponentCommand() {
    AbstractBaseCommand feature = new ValueComponentCommand(mockModel,
            "imagePath", "imageName");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("valueComponentCommand method is invoked!", result);
  }


  /**
   * Test intensityComponentCommand.
   */
  @Test
  public void testIntensityComponentCommand() {
    AbstractBaseCommand feature = new IntensityComponentCommand(mockModel,
            "imagePath", "imageName");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("intensityComponentCommand method is invoked!", result);
  }

  /**
   * Test lumaComponentCommand.
   */
  @Test
  public void testLumaComponentCommand() {
    AbstractBaseCommand feature = new LumaComponentCommand(mockModel,
            "imagePath", "imageName");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("lumaComponentCommand method is invoked!", result);
  }

  /**
   * Test brightenCommand.
   */
  @Test
  public void testBrightenCommand() {
    AbstractBaseCommand feature = new BrightenCommand(mockModel, 50,
            "imagePath", "imageName");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("brightenCommand method is invoked!", result);
  }

  /**
   * Test combineCommand.
   */
  @Test
  public void testCombineCommand() {
    AbstractBaseCommand feature = new CombineCommand(mockModel, "redImage",
            "imageName", "greenImage", "blueImage");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("combineCommand method is invoked!", result);
  }

  /**
   * Test blurCommand.
   */
  @Test
  public void testBlurCommand() {
    AbstractBaseCommand feature = new BlurCommand(mockModel,
            "imageName", "destinationImage");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("blurCommand method is invoked!", result);
  }

  /**
   * Test sharpenCommand.
   */
  @Test
  public void testSharpenCommand() {
    AbstractBaseCommand feature = new SharpenCommand(mockModel,
            "imageName", "destinationImage");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("sharpenCommand method is invoked!", result);
  }

  /**
   * Test sepiaCommand.
   */
  @Test
  public void testSepiaCommand() {
    AbstractBaseCommand feature = new SepiaCommand(mockModel,
            "imageName", "destinationImage");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("sepiaCommand method is invoked!", result);
  }

  /**
   * Test verticalFlipCommand.
   */
  @Test
  public void testVerticalFlipCommand() {
    AbstractBaseCommand feature = new VerticalFlipCommand(mockModel,
            "imageName", "destinationImage");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("verticalFlipCommand method is invoked!", result);
  }

  /**
   * Test horizontalFlipCommand.
   */
  @Test
  public void testHorizontalFlipCommand() {
    AbstractBaseCommand feature = new HorizontalFlipCommand(mockModel,
            "imageName", "destinationImage");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("horizontalFlipCommand method is invoked!", result);
  }

  /**
   * Test rgbSplitCommand.
   */
  @Test
  public void testRGBSplitCommand() {
    AbstractBaseCommand feature = new RGBSplit(mockModel,
            "imageName", "redImageName",
            "greenImageName", "blueImageName");
    boolean status = feature.execute();

    assertTrue(status);

    String result = mockModel.getLog();
    assertEquals("rgbSplitCommand method is invoked!", result);
  }

}
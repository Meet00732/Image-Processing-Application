import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import controller.commands.AbstractImageFormat;
import controller.commands.ImageJPEG;
import controller.commands.ImagePNG;
import model.Image;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * The ImageJPEGTest class contains JUnit tests for the ImageJPEG class, which is used to load
 * and save JPEG image files.
 */
public class ImageJPEGTest {
  private final String testImagePath = "res\\nyc.jpeg";
  File savedFile;

  /**
   * Cleans up by deleting the tempFile after each test execution.
   */
  @After
  public void delete() {
    if (savedFile != null && savedFile.exists()) {
      savedFile.delete();
    }
  }

  /**
   * Test load method.
   */
  @Test
  public void testLoad() {
    try {
      AbstractImageFormat imageJPEG = new ImageJPEG(this.testImagePath);
      Image loadedImage = imageJPEG.load();
      assertNotNull(loadedImage);
    } catch (IOException e) {
      fail("this test should have passed!");
    }
  }

  /**
   * Test save method.
   */
  @Test
  public void testSave() {
    try {
      AbstractImageFormat imageJPEG = new ImageJPEG(this.testImagePath);
      Image loadedImage = imageJPEG.load();

      String path = "test\\res\\testSaveJPEG.jpeg";
      imageJPEG.save(path, loadedImage);

      savedFile = new File(path);
      assertTrue(savedFile.exists());

    } catch (Exception e) {
      fail("this test should have passed!");
    }
  }

  /**
   * Test save method.
   */
  @Test
  public void testSaveJPG() {
    try {
      AbstractImageFormat imageJPEG = new ImageJPEG(this.testImagePath);
      Image loadedImage = imageJPEG.load();

      String path = "test\\res\\testSaveJPG.jpg";
      imageJPEG.save(path, loadedImage);

      savedFile = new File(path);
      assertTrue(savedFile.exists());

    } catch (Exception e) {
      fail("this test should have passed!");
    }
  }

  /**
   * Test path empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullPath() {
    String path = "";
    new ImagePNG(path);
    fail("This test should have failed!");
  }
}
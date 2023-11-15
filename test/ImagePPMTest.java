import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import controller.commands.ImagePPM;
import model.Image;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * The ImagePPMTest class contains JUnit tests for the ImagePPM class, which is used to load
 * and save PPM (Portable Pixmap) image files.
 */
public class ImagePPMTest {
  private final String testImagePath = "res\\nyc.ppm";
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
      ImagePPM imagePPM = new ImagePPM(this.testImagePath);
      Image loadedImage = imagePPM.load();
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
      ImagePPM imagePPM = new ImagePPM(this.testImagePath);
      Image loadedImage = imagePPM.load();

      String path = "test\\res\\testSavePPM.ppm";
      imagePPM.save(path, loadedImage);

      File savedFile = new File(path);
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
    new ImagePPM(path);
    fail("This test should have failed!");
  }

}
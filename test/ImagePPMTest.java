import org.junit.Test;

import java.io.File;
import java.io.IOException;

import controller.commands.ImagePNG;
import controller.commands.ImagePPM;
import model.Image;

import static org.junit.Assert.*;

public class ImagePPMTest {

  private final String testImagePath = "res\\nyc.ppm";

  /**
   * test load method.
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
   * test save method.
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
   * test save method.
   */
  @Test
  public void testSavePNG() {
    try {
      ImagePPM imagePPM = new ImagePPM(this.testImagePath);
      Image loadedImage = imagePPM.load();

      String path = "test\\res\\testSavePNG.png";
      imagePPM.save(path, loadedImage);

      File savedFile = new File(path);
      assertTrue(savedFile.exists());

    } catch (Exception e) {
      fail("this test should have passed!");
    }
  }

  /**
   * test path empty.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNullPath() {
    String path = "";
    new ImagePPM(path);
    fail("This test should have failed!");
  }

}
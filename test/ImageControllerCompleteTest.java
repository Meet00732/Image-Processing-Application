import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.imageio.ImageIO;

import controller.ImageController;
import controller.ImageControllerInterface;
import model.ImageModel;
import model.ImageModelInterface;
import model.MockModel;
import model.Pixel;
import view.ImageView;
import view.ImageViewInterface;

import static org.junit.Assert.*;

public class ImageControllerCompleteTest {

  private final ByteArrayOutputStream outResult = new ByteArrayOutputStream();

  private final PrintStream out = System.out;
  private ByteArrayInputStream inResult;
  private final String imagePath = "test\\res\\controllerTest.png";

  @After
  public void reset() {
    System.setOut(out);
  }
  @Before
  public void setup() throws IOException {
    createImagePNG();
    System.setOut(new PrintStream(outResult));
  }

  private void createImagePNG() throws IOException {
    BufferedImage image = new BufferedImage(3, 3, BufferedImage.TYPE_INT_RGB);
    Pixel[][] pixelArray = new Pixel[3][3];

    pixelArray[0][0] = new Pixel(150, 100, 0);
    pixelArray[0][1] = new Pixel(0, 120, 180);
    pixelArray[0][2] = new Pixel(250, 0, 255);

    pixelArray[1][0] = new Pixel(0, 0, 0);
    pixelArray[1][1] = new Pixel(255, 255, 255);
    pixelArray[1][2] = new Pixel(10, 100, 200);

    pixelArray[2][0] = new Pixel(230, 130, 100);
    pixelArray[2][1] = new Pixel(125, 190, 0);
    pixelArray[2][2] = new Pixel(75, 20, 210);

    for (int x = 0; x < pixelArray.length; x++) {
      for (int y = 0; y < pixelArray[x].length; y++) {
        int rgb = (pixelArray[x][y].getRed() << 16) | (pixelArray[x][y].getGreen() << 8) | pixelArray[x][y].getBlue();
        image.setRGB(x, y, rgb);
      }
    }

    File outputFile = new File("test\\res\\controllerTest.png");
    ImageIO.write(image, "png", outputFile);
  }

  /**
   * test load and save.
   */
  @Test
  public void testLoadSaveCommand() {
    String inputData = "load " + this.imagePath + " testImage\nq";
    inResult = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inResult);

    ImageViewInterface view = new ImageView();
    ImageModelInterface model = new ImageModel();
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
  }


}
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Pixel;

import static org.junit.Assert.*;

public class ImageControllerCompleteTest {

  @Before
  public void setup() throws IOException {
    createImagePNG();
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

    File outputFile = new File("res\\controllerTest.png");
    ImageIO.write(image, "png", outputFile);
  }



}
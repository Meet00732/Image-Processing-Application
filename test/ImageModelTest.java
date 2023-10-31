import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;
import model.Pixel;

import static org.junit.Assert.*;

public class ImageModelTest {


  private ImageModel model;
  private Image image;

  @Before
  public void setup() {

    Pixel[][] pixelArray = new Pixel[3][3];

    // Define specific constant values for each pixel
    pixelArray[0][0] = new Pixel(150, 100, 0);
    pixelArray[0][1] = new Pixel(0, 120, 180);
    pixelArray[0][2] = new Pixel(250, 0, 255);

    pixelArray[1][0] = new Pixel(0, 0, 0);
    pixelArray[1][1] = new Pixel(255, 255, 255);
    pixelArray[1][2] = new Pixel(10, 100, 200);

    pixelArray[2][0] = new Pixel(230, 130, 100);
    pixelArray[2][1] = new Pixel(125, 190, 0);
    pixelArray[2][2] = new Pixel(75, 20, 210);

    this.image = new Image(pixelArray);
    this.model = new ImageModel();
  }

  /**
   * Constructor works correctly.
   */
  @Test
  public void testConstructor() {
    try {
      new ImageModel();
    }
    catch (Exception e) {
      fail("This test should have passed!");
    }
  }

  /**
   * Adding an Image.
   */
  @Test
  public void testAddImage() {
    String imageName = "testImage";
    this.model.addImage(imageName, this.image);

    Image testImage = this.model.getImageMap().get(imageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(this.image.getPixels()[i][j], testImage.getPixels()[i][j]);
      }
    }
  }


  /**
   * Test redComponent.
   */
  @Test
  public void testRedComponent() {
    String imageName = "testImage";
    String destinationImageName = "redImage";
    this.model.addImage(imageName, this.image);

    this.model.redComponentCommand(imageName, destinationImageName);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(this.image.getPixels()[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(0, testImage.getPixels()[i][j].getGreen());
        assertEquals(0, testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test greenComponent.
   */
  @Test
  public void testGreenComponent() {
    String imageName = "testImage";
    String destinationImageName = "greenImage";
    this.model.addImage(imageName, this.image);

    this.model.greenComponentCommand(imageName, destinationImageName);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(0, testImage.getPixels()[i][j].getRed());
        assertEquals(this.image.getPixels()[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(0, testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test blueComponent.
   */
  @Test
  public void testBlueComponent() {
    String imageName = "testImage";
    String destinationImageName = "blueImage";
    this.model.addImage(imageName, this.image);

    this.model.blueComponentCommand(imageName, destinationImageName);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(0, testImage.getPixels()[i][j].getRed());
        assertEquals(0, testImage.getPixels()[i][j].getGreen());
        assertEquals(this.image.getPixels()[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test valueComponent.
   */
  @Test
  public void testValueComponent() {
    String imageName = "testImage";
    String destinationImageName = "valueImage";
    this.model.addImage(imageName, this.image);

    this.model.valueComponentCommand(imageName, destinationImageName);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        Pixel imagePixel = this.image.getPixels()[i][j];

        int maxRed = imagePixel.getRed();
        int maxBlue = imagePixel.getBlue();
        int maxGreen = imagePixel.getGreen();

        int maxVal = Math.max(maxRed, Math.max(maxBlue, maxGreen));

        assertEquals(maxVal, testImage.getPixels()[i][j].getRed());
        assertEquals(maxVal, testImage.getPixels()[i][j].getGreen());
        assertEquals(maxVal, testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test intensityComponent.
   */
  @Test
  public void testIntensityComponent() {
    String imageName = "testImage";
    String destinationImageName = "valueImage";
    this.model.addImage(imageName, this.image);

    this.model.intensityComponentCommand(imageName, destinationImageName);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        Pixel imagePixel = this.image.getPixels()[i][j];

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int avgVal = (red + green + blue) / 3;

        assertEquals(avgVal, testImage.getPixels()[i][j].getRed());
        assertEquals(avgVal, testImage.getPixels()[i][j].getGreen());
        assertEquals(avgVal, testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test lumaComponent.
   */
  @Test
  public void testLumaComponent() {
    String imageName = "testImage";
    String destinationImageName = "valueImage";
    this.model.addImage(imageName, this.image);

    this.model.lumaComponentCommand(imageName, destinationImageName);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        Pixel imagePixel = this.image.getPixels()[i][j];

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int newRed = (int) Math.round(0.2126 * red);
        int newBlue = (int) Math.round(0.0722 * blue);
        int newGreen = (int) Math.round(0.7152 * green);

        int newVal = newRed + newBlue + newGreen;

        assertEquals(newVal, testImage.getPixels()[i][j].getRed());
        assertEquals(newVal, testImage.getPixels()[i][j].getGreen());
        assertEquals(newVal, testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test brightenComponent +50.
   */
  @Test
  public void testBrightenComponentPos50() {
    String imageName = "testImage";
    String destinationImageName = "valueImage";
    int increment = 50;
    this.model.addImage(imageName, this.image);

    this.model.brightenCommand(imageName, destinationImageName, increment);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        Pixel imagePixel = this.image.getPixels()[i][j];


        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int newRed = red + increment;
        int newBlue = blue + increment;
        int newGreen = green + increment;

        Pixel destPixel = new Pixel(newRed, newGreen, newBlue);

        assertEquals(destPixel.getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(destPixel.getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(destPixel.getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test brightenComponent -50.
   */
  @Test
  public void testBrightenComponentNeg50() {
    String imageName = "testImage";
    String destinationImageName = "valueImage";
    int increment = -50;
    this.model.addImage(imageName, this.image);

    this.model.brightenCommand(imageName, destinationImageName, increment);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        Pixel imagePixel = this.image.getPixels()[i][j];


        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int newRed = red + increment;
        int newBlue = blue + increment;
        int newGreen = green + increment;

        Pixel destPixel = new Pixel(newRed, newGreen, newBlue);

        assertEquals(destPixel.getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(destPixel.getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(destPixel.getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test brightenComponent -500.
   */
  @Test
  public void testBrightenComponentNeg500() {
    String imageName = "testImage";
    String destinationImageName = "valueImage";
    int increment = -500;
    this.model.addImage(imageName, this.image);

    this.model.brightenCommand(imageName, destinationImageName, increment);

    Image testImage = this.model.getImageMap().get(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        Pixel imagePixel = this.image.getPixels()[i][j];


        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int newRed = red + increment;
        int newBlue = blue + increment;
        int newGreen = green + increment;

        Pixel destPixel = new Pixel(newRed, newGreen, newBlue);

        assertEquals(destPixel.getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(destPixel.getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(destPixel.getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

}
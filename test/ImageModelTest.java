import org.junit.Before;
import org.junit.Test;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;
import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ImageModelTest {


  private ImageModelInterface model;
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

    Image testImage = this.model.getImage(imageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(this.image.getPixels()[i][j], testImage.getPixels()[i][j]);
      }
    }
  }


  /**
   * Test redComponent invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageRedComponent() {
    String imageName = "testImage";
    String destinationImageName = "redImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.redComponentCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
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

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;


    Pixel[][] expectedArray = new Pixel[3][3];
    expectedArray[0][0] = new Pixel(150, 0,0);
    expectedArray[0][1] = new Pixel(0, 0,0);
    expectedArray[0][2] = new Pixel(250, 0,0);

    expectedArray[1][0] = new Pixel(0, 0, 0);
    expectedArray[1][1] = new Pixel(255, 0,0);
    expectedArray[1][2] = new Pixel(10, 0,0);

    expectedArray[2][0] = new Pixel(230, 0,0);
    expectedArray[2][1] = new Pixel(125, 0,0);
    expectedArray[2][2] = new Pixel(75, 0,0);


    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
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

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    Pixel[][] expectedArray = new Pixel[3][3];
    expectedArray[0][0] = new Pixel(0, 100,0);
    expectedArray[0][1] = new Pixel(0, 120,0);
    expectedArray[0][2] = new Pixel(0, 0,0);

    expectedArray[1][0] = new Pixel(0, 0, 0);
    expectedArray[1][1] = new Pixel(0, 255,0);
    expectedArray[1][2] = new Pixel(0, 100,0);

    expectedArray[2][0] = new Pixel(0, 130,0);
    expectedArray[2][1] = new Pixel(0, 190,0);
    expectedArray[2][2] = new Pixel(0, 20,0);


    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test greenComponent invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageGreenComponent() {
    String imageName = "testImage";
    String destinationImageName = "greenImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.greenComponentCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
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

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    Pixel[][] expectedArray = new Pixel[3][3];
    expectedArray[0][0] = new Pixel(0, 0,0);
    expectedArray[0][1] = new Pixel(0, 0,180);
    expectedArray[0][2] = new Pixel(0, 0,255);

    expectedArray[1][0] = new Pixel(0, 0, 0);
    expectedArray[1][1] = new Pixel(0, 0,255);
    expectedArray[1][2] = new Pixel(0, 0,200);

    expectedArray[2][0] = new Pixel(0, 0,100);
    expectedArray[2][1] = new Pixel(0, 0,0);
    expectedArray[2][2] = new Pixel(0, 0,210);

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test blueComponent invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageBlueComponent() {
    String imageName = "testImage";
    String destinationImageName = "blueImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.blueComponentCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
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

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(150, 150, 150);
        expectedArray[0][1] = new Pixel(180, 180, 180);
        expectedArray[0][2] = new Pixel(255, 255, 255);

        expectedArray[1][0] = new Pixel(0, 0, 0);
        expectedArray[1][1] = new Pixel(255, 255, 255);
        expectedArray[1][2] = new Pixel(200, 200, 200);

        expectedArray[2][0] = new Pixel(230, 230, 230);
        expectedArray[2][1] = new Pixel(190, 190, 190);
        expectedArray[2][2] = new Pixel(210, 210, 210);

        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test valueComponent invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageValueComponent() {
    String imageName = "testImage";
    String destinationImageName = "valueImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.valueComponentCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test intensityComponent.
   */
  @Test
  public void testIntensityComponent() {
    String imageName = "testImage";
    String destinationImageName = "intensityImage";
    this.model.addImage(imageName, this.image);

    this.model.intensityComponentCommand(imageName, destinationImageName);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(83, 83, 83);
        expectedArray[0][1] = new Pixel(100, 100, 100);
        expectedArray[0][2] = new Pixel(168, 168, 168);

        expectedArray[1][0] = new Pixel(0, 0, 0);
        expectedArray[1][1] = new Pixel(255, 255, 255);
        expectedArray[1][2] = new Pixel(103, 103, 103);

        expectedArray[2][0] = new Pixel(153, 153, 153);
        expectedArray[2][1] = new Pixel(105, 105, 105);
        expectedArray[2][2] = new Pixel(101, 101, 101);

        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test intensityComponent invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageIntensityComponent() {
    String imageName = "testImage";
    String destinationImageName = "intensityImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.intensityComponentCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test lumaComponent.
   */
  @Test
  public void testLumaComponent() {
    String imageName = "testImage";
    String destinationImageName = "lumaImage";
    this.model.addImage(imageName, this.image);

    this.model.lumaComponentCommand(imageName, destinationImageName);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(104, 104, 104);
        expectedArray[0][1] = new Pixel(99, 99, 99);
        expectedArray[0][2] = new Pixel(71, 71, 71);

        expectedArray[1][0] = new Pixel(0, 0, 0);
        expectedArray[1][1] = new Pixel(254, 254, 254);
        expectedArray[1][2] = new Pixel(88, 88, 88);

        expectedArray[2][0] = new Pixel(149, 149, 149);
        expectedArray[2][1] = new Pixel(163, 163, 163);
        expectedArray[2][2] = new Pixel(45, 45, 45);

        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test lumaComponent invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageLumaComponent() {
    String imageName = "testImage";
    String destinationImageName = "lumaImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.lumaComponentCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test brightenComponent +50.
   */
  @Test
  public void testBrightenComponentPos50() {
    String imageName = "testImage";
    String destinationImageName = "brightenImage";
    int increment = 50;
    this.model.addImage(imageName, this.image);

    this.model.brightenCommand(imageName, destinationImageName, increment);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(200, 150, 50);
        expectedArray[0][1] = new Pixel(50, 170, 230);
        expectedArray[0][2] = new Pixel(255, 50, 255);

        expectedArray[1][0] = new Pixel(50, 50, 50);
        expectedArray[1][1] = new Pixel(255, 255, 255);
        expectedArray[1][2] = new Pixel(60, 150, 250);

        expectedArray[2][0] = new Pixel(255, 180, 150);
        expectedArray[2][1] = new Pixel(175, 240, 50);
        expectedArray[2][2] = new Pixel(125, 70, 260);

        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test lumaComponent invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageBrightenComponent() {
    String imageName = "testImage";
    String destinationImageName = "brightenImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.brightenCommand(imageNotExist, destinationImageName, 50);
    fail("This test should have failed!");
  }


  /**
   * Test brightenComponent -50.
   */
  @Test
  public void testBrightenComponentNeg50() {
    String imageName = "testImage";
    String destinationImageName = "brightenImage";
    int increment = -50;
    this.model.addImage(imageName, this.image);

    this.model.brightenCommand(imageName, destinationImageName, increment);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(100, 50, 0);
        expectedArray[0][1] = new Pixel(0, 70, 130);
        expectedArray[0][2] = new Pixel(200, 0, 205);

        expectedArray[1][0] = new Pixel(0, 0, 0);
        expectedArray[1][1] = new Pixel(205, 205, 205);
        expectedArray[1][2] = new Pixel(0, 50, 150);

        expectedArray[2][0] = new Pixel(180, 80, 50);
        expectedArray[2][1] = new Pixel(75, 140, 0);
        expectedArray[2][2] = new Pixel(25, 0, 160);

        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test brightenComponent 500.
   */
  @Test
  public void testBrightenComponentPos500() {
    String imageName = "testImage";
    String destinationImageName = "brightenImage";
    int increment = 500;
    this.model.addImage(imageName, this.image);

    this.model.brightenCommand(imageName, destinationImageName, increment);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {

        assertEquals(255, testImage.getPixels()[i][j].getRed());
        assertEquals(255, testImage.getPixels()[i][j].getGreen());
        assertEquals(255, testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test brightenComponent -500.
   */
  @Test
  public void testBrightenComponentNeg500() {
    String imageName = "testImage";
    String destinationImageName = "brightenImage";
    int increment = -500;
    this.model.addImage(imageName, this.image);

    this.model.brightenCommand(imageName, destinationImageName, increment);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(0, testImage.getPixels()[i][j].getRed());
        assertEquals(0, testImage.getPixels()[i][j].getGreen());
        assertEquals(0, testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test combinedCommand
   */
  @Test
  public void testCombineCommand() {
    String imageName = "testImage";
    String redImageName = "redImage";
    String greenImageName = "greenImage";
    String blueImageName = "blueImage";
    String destinationImageName = "combineImage";

    this.model.addImage(imageName, this.image);
    this.model.redComponentCommand(imageName, redImageName);
    this.model.greenComponentCommand(imageName, greenImageName);
    this.model.blueComponentCommand(imageName, blueImageName);

    this.model.combineCommand(redImageName, greenImageName,
            blueImageName, destinationImageName);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(150, 100, 0);
        expectedArray[0][1] = new Pixel(0, 120, 180);
        expectedArray[0][2] = new Pixel(250, 0, 255);

        expectedArray[1][0] = new Pixel(0, 0, 0);
        expectedArray[1][1] = new Pixel(255, 255, 255);
        expectedArray[1][2] = new Pixel(10, 100, 200);

        expectedArray[2][0] = new Pixel(230, 130, 100);
        expectedArray[2][1] = new Pixel(125, 190, 0);
        expectedArray[2][2] = new Pixel(75, 20, 210);

        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test combinedCommand. Image does not exist.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testImageDoesNotExistCombineCommand() {
    String imageName = "testImage";
    String redImageName = "redImage";
    String greenImageName = "greenImage";
    String blueImageName = "blueImage";
    String destinationImageName = "combineImage";

    this.model.addImage(imageName, this.image);
    this.model.redComponentCommand(imageName, redImageName);
    this.model.greenComponentCommand(imageName, greenImageName);
    this.model.blueComponentCommand(imageName, blueImageName);

    redImageName = "redImage2";
    blueImageName = "blueImage2";
    this.model.combineCommand(redImageName, greenImageName,
            blueImageName, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test combinedCommand. Image does not exist.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testDifferentImageDimensionsCombineCommand() {
    Pixel[][] pixelArray = new Pixel[1][3];

    pixelArray[0][0] = new Pixel(150, 100, 0);
    pixelArray[0][1] = new Pixel(0, 120, 180);
    pixelArray[0][2] = new Pixel(250, 0, 255);

    Image newImage = new Image(pixelArray);
    String newImageName = "newImage";

    String imageName = "testImage";
    String redImageName = "redImage";
    String greenImageName = "greenImage";
    String blueImageName = "blueImage";
    String destinationImageName = "combineImage";

    this.model.addImage(imageName, this.image);
    this.model.addImage(newImageName, newImage);

    this.model.redComponentCommand(imageName, redImageName);
    this.model.greenComponentCommand(newImageName, greenImageName);
    this.model.blueComponentCommand(imageName, blueImageName);

    this.model.combineCommand(redImageName, greenImageName,
            blueImageName, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test blurCommand.
   */
  @Test
  public void testBlurCommand() {
    String imageName = "testImage";
    String destinationImageName = "blurImage";

    this.model.addImage(imageName, this.image);
    this.model.blurCommand(imageName, destinationImageName);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;


    for (int x = 0; x < width; x++) {
      for(int y = 0; y < height; y++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(53, 56, 38);
        expectedArray[0][1] = new Pixel(83, 81, 121);
        expectedArray[0][2] = new Pixel(80, 43, 127);

        expectedArray[1][0] = new Pixel(87, 80, 56);
        expectedArray[1][1] = new Pixel(125, 131, 147);
        expectedArray[1][2] = new Pixel(83, 79, 151);

        expectedArray[2][0] = new Pixel(89, 72, 41);
        expectedArray[2][1] = new Pixel(102, 104, 83);
        expectedArray[2][2] = new Pixel(52, 57, 93);

        assertEquals(expectedArray[x][y].getRed(), testImage.getPixels()[x][y].getRed());
        assertEquals(expectedArray[x][y].getGreen(), testImage.getPixels()[x][y].getGreen());
        assertEquals(expectedArray[x][y].getBlue(), testImage.getPixels()[x][y].getBlue());
      }
    }
  }

  /**
   * Test blur invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageBlurComponent() {
    String imageName = "testImage";
    String destinationImageName = "blurImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.blurCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test sharpenCommand.
   */
  @Test
  public void testSharpenCommand() {
    String imageName = "testImage";
    String destinationImageName = "sharpenImage";

    this.model.addImage(imageName, this.image);
    this.model.sharpenCommand(imageName, destinationImageName);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for (int x = 0; x < width; x++) {
      for(int y = 0; y < height; y++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(165, 163, 0);
        expectedArray[0][1] = new Pixel(174, 186, 255);
        expectedArray[0][2] = new Pixel(219, 9, 255);

        expectedArray[1][0] = new Pixel(15, 64, 13);
        expectedArray[1][1] = new Pixel(255, 255, 255);
        expectedArray[1][2] = new Pixel(64, 139, 255);

        expectedArray[2][0] = new Pixel(255, 199, 58);
        expectedArray[2][1] = new Pixel(218, 255, 137);
        expectedArray[2][2] = new Pixel(94, 113, 255);

        assertEquals(expectedArray[x][y].getRed(), testImage.getPixels()[x][y].getRed());
        assertEquals(expectedArray[x][y].getGreen(), testImage.getPixels()[x][y].getGreen());
        assertEquals(expectedArray[x][y].getBlue(), testImage.getPixels()[x][y].getBlue());
      }
    }
  }


  /**
   * Test sharpen invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageSharpenComponent() {
    String imageName = "testImage";
    String destinationImageName = "sharpenImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.sharpenCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test sepiaCommand.
   */
  @Test
  public void testSepiaCommand() {
    String imageName = "testImage";
    String destinationImageName = "sepiaImage";

    this.model.addImage(imageName, this.image);
    this.model.sepiaCommand(imageName, destinationImageName);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(135, 120, 94);
        expectedArray[0][1] = new Pixel(126, 112, 87);
        expectedArray[0][2] = new Pixel(146, 130, 101);

        expectedArray[1][0] = new Pixel(0,0,0);
        expectedArray[1][1] = new Pixel(255, 255, 238);
        expectedArray[1][2] = new Pixel(118, 105, 82);

        expectedArray[2][0] = new Pixel(209, 186, 145);
        expectedArray[2][1] = new Pixel(195, 173, 135);
        expectedArray[2][2] = new Pixel(84, 75, 58);

        assertEquals(expectedArray[x][y].getRed(), testImage.getPixels()[x][y].getRed());
        assertEquals(expectedArray[x][y].getGreen(), testImage.getPixels()[x][y].getGreen());
        assertEquals(expectedArray[x][y].getBlue(), testImage.getPixels()[x][y].getBlue());
      }
    }
  }

  /**
   * Test sepia invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageSepiaComponent() {
    String imageName = "testImage";
    String destinationImageName = "sepiaImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.sepiaCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test verticalFlipCommand.
   */
  @Test
  public void testVerticalFlipCommand() {
    String imageName = "testImage";
    String destinationImageName = "verticalFlipImage";

    this.model.addImage(imageName, this.image);
    this.model.verticalFlipCommand(imageName, destinationImageName);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(250, 0, 255);
        expectedArray[0][1] = new Pixel(0, 120, 180);
        expectedArray[0][2] = new Pixel(150, 100, 0);


        expectedArray[1][0] = new Pixel(10, 100, 200);
        expectedArray[1][1] = new Pixel(255, 255, 255);
        expectedArray[1][2] = new Pixel(0,0,0);


        expectedArray[2][0] = new Pixel(75, 20, 210);
        expectedArray[2][1] = new Pixel(125, 190, 0);
        expectedArray[2][2] = new Pixel(230, 130, 100);

        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test VerticalFlip invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageVerticalFlipComponent() {
    String imageName = "testImage";
    String destinationImageName = "verticalFlipImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.verticalFlipCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
  }


  /**
   * Test horizontalFlipCommand.
   */
  @Test
  public void testHorizontalFlipCommand() {
    String imageName = "testImage";
    String destinationImageName = "horizontalFlipImage";

    this.model.addImage(imageName, this.image);
    this.model.horizontalFlipCommand(imageName, destinationImageName);

    Image testImage = this.model.getImage(destinationImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(230, 130, 100);
        expectedArray[0][1] = new Pixel(125, 190, 0);
        expectedArray[0][2] = new Pixel(75, 20, 210);

        expectedArray[1][0] = new Pixel(0,0,0);
        expectedArray[1][1] = new Pixel(255, 255, 255);
        expectedArray[1][2] = new Pixel(10, 100, 200);

        expectedArray[2][0] = new Pixel(150, 100, 0);
        expectedArray[2][1] = new Pixel(0, 120, 180);
        expectedArray[2][2] = new Pixel(250, 0, 255);


        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test horizontalFlip invalid image.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNoImageHorizontalFlipComponent() {
    String imageName = "testImage";
    String destinationImageName = "horizontalFlipImage";
    this.model.addImage(imageName, this.image);

    String imageNotExist = "testImage2";
    this.model.horizontalFlipCommand(imageNotExist, destinationImageName);
    fail("This test should have failed!");
  }

  /**
   * Test RGB-Split.
   */
  @Test
  public void testRGBSplit() {
    String imageName = "testImage";
    String redImageName = "redImage";
    String greenImageName = "greenImage";
    String blueImageName = "blueImage";

    this.model.addImage(imageName, this.image);
    this.model.rgbSplitCommand(redImageName, greenImageName, blueImageName, imageName);

    Image testRedImage = this.model.getImage(redImageName);
    Image testGreenImage = this.model.getImage(greenImageName);
    Image testBlueImage = this.model.getImage(blueImageName);

    int widthRed = testRedImage.getPixels().length;
    int heightRed = testRedImage.getPixels()[0].length;

    for(int i=0; i<widthRed; i++) {
      for(int j=0; j<heightRed; j++) {

        Pixel[][] expectedArray = new Pixel[3][3];
        expectedArray[0][0] = new Pixel(150, 100, 0);
        expectedArray[0][1] = new Pixel(0, 120, 180);
        expectedArray[0][2] = new Pixel(250, 0, 255);

        expectedArray[1][0] = new Pixel(0, 0, 0);
        expectedArray[1][1] = new Pixel(255, 255, 255);
        expectedArray[1][2] = new Pixel(10, 100, 200);

        expectedArray[2][0] = new Pixel(230, 130, 100);
        expectedArray[2][1] = new Pixel(125, 190, 0);
        expectedArray[2][2] = new Pixel(75, 20, 210);

        assertEquals(expectedArray[i][j].getRed(), testRedImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testGreenImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testBlueImage.getPixels()[i][j].getBlue());
      }
    }
  }

  /**
   * Test for multiple commands. (redComponent + valueComponent).
   */
  @Test
  public void testRedComponentThenValueComponent() {
    String originalImageName = "testImage";
    String redImageName = "redComponentImage";
    String finalImageName = "valueOfRedComponentImage";

    this.model.addImage(originalImageName, this.image);
    this.model.redComponentCommand(originalImageName, redImageName);
    this.model.valueComponentCommand(redImageName, finalImageName);

    Image testImage = this.model.getImage(finalImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    Pixel[][] expectedArray = new Pixel[3][3];

    expectedArray[0][0] = new Pixel(150, 150, 150);
    expectedArray[0][1] = new Pixel(0, 0, 0);
    expectedArray[0][2] = new Pixel(250, 250, 250);

    expectedArray[1][0] = new Pixel(0, 0, 0);
    expectedArray[1][1] = new Pixel(255, 255, 255);
    expectedArray[1][2] = new Pixel(10, 10, 10);

    expectedArray[2][0] = new Pixel(230, 230, 230);
    expectedArray[2][1] = new Pixel(125, 125, 125);
    expectedArray[2][2] = new Pixel(75, 75, 75);

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test for multiple commands. (blueComponent + brightenComponent).
   */
  @Test
  public void testBlueComponentThenBrighten() {
    String imageName = "testImage";
    String blueImageName = "blueComponentImage";
    String brightenedImageName = "brightenedBlueImage";
    int increment = 35;

    this.model.addImage(imageName, this.image);
    this.model.blueComponentCommand(imageName, blueImageName);
    this.model.brightenCommand(blueImageName, brightenedImageName, increment);

    Image testImage = this.model.getImage(brightenedImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    Pixel[][] expectedArray = new Pixel[3][3];

    expectedArray[0][0] = new Pixel(35, 35, 35);
    expectedArray[0][1] = new Pixel(35, 35, 215);
    expectedArray[0][2] = new Pixel(35, 35, 255);

    expectedArray[1][0] = new Pixel(35, 35, 35);
    expectedArray[1][1] = new Pixel(35, 35, 255);
    expectedArray[1][2] = new Pixel(35, 35, 235);

    expectedArray[2][0] = new Pixel(35, 35, 135);
    expectedArray[2][1] = new Pixel(35, 35, 35);
    expectedArray[2][2] = new Pixel(35, 35, 245);

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test for multiple commands. (horizontalFlip + verticalFlip).
   */
  @Test
  public void testHorizontalThenVerticalFlip() {
    String imageName = "testImage";
    String horizontalFlipImageName = "horizontalFlipImage";
    String finalFlippedImageName = "finalFlippedImage";

    this.model.addImage(imageName, this.image);
    this.model.horizontalFlipCommand(imageName, horizontalFlipImageName);
    this.model.verticalFlipCommand(horizontalFlipImageName, finalFlippedImageName);

    Image testImage = this.model.getImage(finalFlippedImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    Pixel[][] expectedArray = new Pixel[3][3];
    expectedArray[0][0] = new Pixel(75, 20, 210);
    expectedArray[0][1] = new Pixel(125, 190, 0);
    expectedArray[0][2] = new Pixel(230, 130, 100);

    expectedArray[1][0] = new Pixel(10, 100, 200);
    expectedArray[1][1] = new Pixel(255, 255, 255);
    expectedArray[1][2] = new Pixel(0,0,0);

    expectedArray[2][0] = new Pixel(250, 0, 255);
    expectedArray[2][1] = new Pixel(0, 120, 180);
    expectedArray[2][2] = new Pixel(150, 100, 0);

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        assertEquals(expectedArray[i][j].getRed(), testImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), testImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), testImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test for multiple commands. (rgb-split + combine)
   */
  @Test
  public void testRGBSplitAndCombine() {
    String imageName = "testImage";
    String redImageName = "redImage";
    String greenImageName = "greenImage";
    String blueImageName = "blueImage";
    String combinedImageName = "combinedImage";


    this.model.addImage(imageName, this.image);
    this.model.rgbSplitCommand(redImageName, greenImageName, blueImageName, imageName);
    this.model.combineCommand(redImageName, greenImageName, blueImageName, combinedImageName);


    Image combinedImage = this.model.getImage(combinedImageName);
    int width = combinedImage.getPixels().length;
    int height = combinedImage.getPixels()[0].length;

    Pixel[][] expectedArray = new Pixel[3][3];
    expectedArray[0][0] = new Pixel(150, 100, 0);
    expectedArray[0][1] = new Pixel(0, 120, 180);
    expectedArray[0][2] = new Pixel(250, 0, 255);

    expectedArray[1][0] = new Pixel(0, 0, 0);
    expectedArray[1][1] = new Pixel(255, 255, 255);
    expectedArray[1][2] = new Pixel(10, 100, 200);

    expectedArray[2][0] = new Pixel(230, 130, 100);
    expectedArray[2][1] = new Pixel(125, 190, 0);
    expectedArray[2][2] = new Pixel(75, 20, 210);

    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        assertEquals(expectedArray[i][j].getRed(), combinedImage.getPixels()[i][j].getRed());
        assertEquals(expectedArray[i][j].getGreen(), combinedImage.getPixels()[i][j].getGreen());
        assertEquals(expectedArray[i][j].getBlue(), combinedImage.getPixels()[i][j].getBlue());
      }
    }
  }


  /**
   * Test for multiple commands. (luma + sepia)
   */
  @Test
  public void testLumaThenSepia() {
    String imageName = "testImage";
    String lumaImageName = "lumaImage";
    String sepiaImageName = "sepiaFromLumaImage";

    this.model.addImage(imageName, this.image);
    this.model.lumaComponentCommand(imageName, lumaImageName);
    this.model.sepiaCommand(lumaImageName, sepiaImageName);

    Image testImage = this.model.getImage(sepiaImageName);
    int width = testImage.getPixels().length;
    int height = testImage.getPixels()[0].length;

    Pixel[][] expectedArray = new Pixel[3][3];
    expectedArray[0][0] = new Pixel(140, 125, 97);
    expectedArray[0][1] = new Pixel(133, 119, 92);
    expectedArray[0][2] = new Pixel(95, 85, 66);

    expectedArray[1][0] = new Pixel(0, 0, 0);
    expectedArray[1][1] = new Pixel(255, 255, 237);
    expectedArray[1][2] = new Pixel(118, 105, 82);

    expectedArray[2][0] = new Pixel(201, 179, 139);
    expectedArray[2][1] = new Pixel(220, 196, 152);
    expectedArray[2][2] = new Pixel(60, 54, 42);



    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {

        assertEquals(expectedArray[x][y].getRed(), testImage.getPixels()[x][y].getRed());
        assertEquals(expectedArray[x][y].getGreen(), testImage.getPixels()[x][y].getGreen());
        assertEquals(expectedArray[x][y].getBlue(), testImage.getPixels()[x][y].getBlue());
      }
    }
  }


//  System.out.println("Red: " + testImage.getPixels()[x][y].getRed() +
//                          " Green: " + testImage.getPixels()[x][y].getGreen() +
//                          " Blue: " + testImage.getPixels()[x][y].getBlue());

}
import org.junit.Test;

import model.Image;
import model.Pixel;

import static org.junit.Assert.*;

public class ImageTest {

  @Test
  public void testCreateImage() {
    Pixel[][] pixels = new Pixel[3][3];
    Pixel pixel = new Pixel(1,1,1);
    Image image;
    for (int i=0;i<3;i++) {
      for (int j=0;j<3;j++) {
        pixels[i][j] = pixel;
      }
    }

    image = new Image(pixels);

    for (int i=0;i<3;i++) {
      for (int j=0;j<3;j++) {
        assertEquals(pixel.getRed(),image.getPixels()[i][j].getRed());
        assertEquals(pixel.getGreen(),image.getPixels()[i][j].getGreen());
        assertEquals(pixel.getBlue(),image.getPixels()[i][j].getBlue());
      }
    }
  }

  @Test
  public void testGetPixels() {
    Pixel[][] pixels = new Pixel[3][3];
    Pixel pixel = new Pixel(1,1,1);
    Image image;
    for (int i=0;i<3;i++) {
      for (int j=0;j<3;j++) {
        pixels[i][j] = pixel;
      }
    }

    image = new Image(pixels);

    assertEquals(pixels,image.getPixels());
  }

}
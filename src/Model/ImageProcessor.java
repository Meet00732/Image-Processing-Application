package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageProcessor {

  public void flip() {
  }

  public Image load(String path) throws IOException {
    if (path == null || path.trim().isEmpty()) {
      throw new IllegalArgumentException("Path cannot be null or empty");
    }

    BufferedImage bufferedImage;
    try {
      bufferedImage = ImageIO.read(new File(path));
    } catch (IOException e) {
      throw new IOException("Error reading image from path: " + path, e);
    }

    if (bufferedImage == null) {
      throw new IOException("Unsupported image format or invalid file: " + path);
    }

    int width = bufferedImage.getWidth();
    int height = bufferedImage.getHeight();
    Pixel[][] pixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int rgb = bufferedImage.getRGB(x, y);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        Pixel pixel = new Pixel();
        pixel.setRed(red);
        pixel.setGreen(green);
        pixel.setBlue(blue);

        pixels[y][x] = pixel;
      }
    }
    return new Image(pixels, width, height);
  }


  public void save(String path, Image image) throws Exception {
    if (path == null || path.trim().isEmpty()) {
      throw new IllegalArgumentException("Path cannot be null or empty");
    }

    int width = image.width;
    int height = image.height;

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel pixel = image.pixels[y][x];
        int rgb = (pixel.getRed() << 16) | (pixel.getGreen() << 8) | pixel.getBlue();
        bufferedImage.setRGB(x, y, rgb);
      }
    }

    String fileExtension = path.substring(path.lastIndexOf('.') + 1);

    try {
      ImageIO.write(bufferedImage, fileExtension, new File(path));
    }
    catch (FileNotFoundException e) {
      throw new Exception("Invalid Path!");
    }
    catch (Exception e) {
      throw new Exception("Error saving image to path: " + path);
    }
  }

  public Image redComponent(Image image) {
    int width = image.width;
    int height = image.height;

    Pixel[][] destinationPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel imagePixel = image.pixels[y][x];
        Pixel destPixel = new Pixel();

        destPixel.setRed(imagePixel.getRed());
        destPixel.setBlue(0);
        destPixel.setGreen(0);

        destinationPixels[y][x] = destPixel;
      }
    }
    return new Image(destinationPixels, width, height);
  }
}

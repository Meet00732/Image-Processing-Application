package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageProcessor {


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
    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        int rgb = bufferedImage.getRGB(x, y);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        Pixel pixel = new Pixel();
        pixel.setRed(red);
        pixel.setGreen(green);
        pixel.setBlue(blue);

        pixels[x][y] = pixel;
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

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel pixel = image.pixels[x][y];
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

    Pixel[][] destinationPixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.pixels[x][y];
        Pixel destPixel = new Pixel();

        destPixel.setRed(imagePixel.getRed());
        destPixel.setBlue(0);
        destPixel.setGreen(0);

        destinationPixels[x][y] = destPixel;
      }
    }
    return new Image(destinationPixels, width, height);
  }


  public Image greenComponent(Image image) {
    int width = image.width;
    int height = image.height;

    Pixel[][] destinationPixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.pixels[x][y];
        Pixel destPixel = new Pixel();

        destPixel.setGreen(imagePixel.getGreen());
        destPixel.setBlue(0);
        destPixel.setRed(0);

        destinationPixels[x][y] = destPixel;
      }
    }
    return new Image(destinationPixels, width, height);
  }


  public Image blueComponent(Image image) {
    int width = image.width;
    int height = image.height;

    Pixel[][] destinationPixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.pixels[x][y];
        Pixel destPixel = new Pixel();

        destPixel.setBlue(imagePixel.getBlue());
        destPixel.setGreen(0);
        destPixel.setRed(0);

        destinationPixels[x][y] = destPixel;
      }
    }
    return new Image(destinationPixels, width, height);
  }

  public Image valueComponent(Image image) {
    int width = image.width;
    int height = image.height;

    Pixel[][] destinationPixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.pixels[x][y];
        Pixel destPixel = new Pixel();

        int maxRed = imagePixel.getRed();
        int maxBlue = imagePixel.getBlue();
        int maxGreen = imagePixel.getGreen();

        int maxVal = Math.max(maxRed, Math.max(maxBlue, maxGreen));

        destPixel.setBlue(maxVal);
        destPixel.setGreen(maxVal);
        destPixel.setRed(maxVal);

        destinationPixels[x][y] = destPixel;
      }
    }
    return new Image(destinationPixels, width, height);
  }


  public Image intensityComponent(Image image) {
    int width = image.width;
    int height = image.height;

    Pixel[][] destinationPixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.pixels[x][y];
        Pixel destPixel = new Pixel();

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int avgVal = (red + green + blue) / 3;

        destPixel.setBlue(avgVal);
        destPixel.setGreen(avgVal);
        destPixel.setRed(avgVal);

        destinationPixels[x][y] = destPixel;
      }
    }
    return new Image(destinationPixels, width, height);
  }

  public Image lumaComponent(Image image) {
    int width = image.width;
    int height = image.height;

    Pixel[][] destinationPixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.pixels[x][y];
        Pixel destPixel = new Pixel();

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int newRed = (int) (0.2126 * red);
        int newBlue = (int) (0.0722 * blue);
        int newGreen = (int) (0.7152 * green);

        int newVal = newRed + newBlue + newGreen;

        destPixel.setBlue(newVal);
        destPixel.setGreen(newVal);
        destPixel.setRed(newVal);

        destinationPixels[x][y] = destPixel;
      }
    }
    return new Image(destinationPixels, width, height);
  }

  public Image brightFeature(Image image, int increment) {
    int width = image.width;
    int height = image.height;

    Pixel[][] destinationPixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.pixels[x][y];
        Pixel destPixel = new Pixel();

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();


        int newRed = clampPixels(red + increment);
        int newBlue = clampPixels(blue + increment);
        int newGreen = clampPixels(green + increment);


        destPixel.setRed(newRed);
        destPixel.setGreen(newGreen);
        destPixel.setBlue(newBlue);

        destinationPixels[x][y] = destPixel;
      }
    }
    return new Image(destinationPixels, width, height);
  }


  private int clampPixels (int channel) {
    if (channel <= 0) {
      channel = 0;
    }
    else if (channel >= 255) {
      channel = 255;
    }
    return channel;
  }
}

package model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the model for managing and manipulating images.
 * It stores images in a map and provides various image processing methods.
 */
public class ImageModel implements ImageModelInterface {

  private final Map<String, Image> imageMap;

  /**
   * Constructs an ImageModel object, initializing an empty map to store images.
   */
  public ImageModel() {
    this.imageMap = new HashMap<>();
  }


  /**
   * Adds an image to the model with the given name.
   *
   * @param name  The name or identifier for the image.
   * @param image The Image object to be added to the model.
   */
  @Override
  public void addImage(String name, Image image) {
    this.imageMap.put(name, image);
  }


  /**
   * Extracts the red component of the specified image and
   * creates a new image with only the red component.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image where
   *                             the red component will be stored.
   */
  @Override
  public void redComponentCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.getPixels()[x][y];
        Pixel destPixel = new Pixel(imagePixel.getRed(), 0, 0);
        pixels[x][y] = destPixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }

  /**
   * Extracts the green component of the specified image and
   * creates a new image with only the green component.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image where
   *                             the green component will be stored.
   */
  @Override
  public void greenComponentCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.getPixels()[x][y];
        Pixel destPixel = new Pixel(0, imagePixel.getGreen(), 0);
        pixels[x][y] = destPixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }

  /**
   * Extracts the blue component of the specified image and
   * creates a new image with only the blue component.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image where
   *                             the blue component will be stored.
   */
  @Override
  public void blueComponentCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    Pixel[][] pixels = new Pixel[width][height];


    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.getPixels()[x][y];
        Pixel destPixel = new Pixel(0, 0, imagePixel.getBlue());
        pixels[x][y] = destPixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }


  /**
   * Creates a new image where all color components (red, green, and blue)
   * have the same value which is the maximum pixel of all (rgb).
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void valueComponentCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.getPixels()[x][y];

        int maxRed = imagePixel.getRed();
        int maxBlue = imagePixel.getBlue();
        int maxGreen = imagePixel.getGreen();

        int maxVal = Math.max(maxRed, Math.max(maxBlue, maxGreen));

        Pixel destPixel = new Pixel(maxVal, maxVal, maxVal);
        pixels[x][y] = destPixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }

  /**
   * Creates a new image where each pixel's color components have the
   * same average value, representing the grayscale intensity.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image where the
   *                             grayscale intensity image will be stored.
   */
  @Override
  public void intensityComponentCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.getPixels()[x][y];

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int avgVal = (red + green + blue) / 3;

        Pixel destPixel = new Pixel(avgVal, avgVal, avgVal);
        pixels[x][y] = destPixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }

  /**
   * Creates a new image where each pixel's color components are
   * transformed to represent the luma (brightness) of the image.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image where
   *                             the luma image will be stored.
   */
  @Override
  public void lumaComponentCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.getPixels()[x][y];

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int newRed = (int) Math.round(0.2126 * red);
        int newBlue = (int) Math.round(0.0722 * blue);
        int newGreen = (int) Math.round(0.7152 * green);

        int newVal = newRed + newBlue + newGreen;

        Pixel destPixel = new Pixel(newVal, newVal, newVal);
        pixels[x][y] = destPixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }

  /**
   * Brightens the image by adding a specified increment to the
   * red, green, and blue components of each pixel.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image
   *                             where the brightened image will be stored.
   * @param increment            The increment to be added to the red, green,
   *                             and blue components.
   */
  @Override
  public void brightenCommand(String imageName, String destinationImageName, int increment) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel imagePixel = image.getPixels()[x][y];

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int newRed = red + increment;
        int newBlue = blue + increment;
        int newGreen = green + increment;

        Pixel destPixel = new Pixel(newRed, newGreen, newBlue);
        pixels[x][y] = destPixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }

  /**
   * Combines three images (red, green, and blue channels) into a single color image.
   *
   * @param imageRedName    The name of the source image for the red channel.
   * @param imageGreenName  The name of the source image for the green channel.
   * @param imageBlueName   The name of the source image for the blue channel.
   * @param destinationImageName   The name of the destination image where the combined
   *                               image will be stored.
   */
  @Override
  public void combineCommand(String imageRedName,
                             String imageGreenName,
                             String imageBlueName,
                             String destinationImageName) {

    if (!imageExists(imageRedName) || !imageExists(imageGreenName)
            || !imageExists(imageBlueName)) {
      throw new IllegalArgumentException("One or More Images does not exist!");
    }

    Image imageRed = this.imageMap.get(imageRedName);
    Image imageGreen = this.imageMap.get(imageGreenName);
    Image imageBlue = this.imageMap.get(imageBlueName);

    int widthRed = imageRed.getPixels().length;
    int heightRed = imageRed.getPixels()[0].length;

    int widthGreen = imageGreen.getPixels().length;
    int heightGreen = imageGreen.getPixels()[0].length;

    int widthBlue = imageBlue.getPixels().length;
    int heightBlue = imageBlue.getPixels()[0].length;

    if ((widthRed != widthGreen) || (widthGreen != widthBlue)
            || (heightRed != heightGreen) || (heightGreen != heightBlue)) {
      throw new IllegalArgumentException("All images must have same dimensions!");
    }
    Pixel[][] pixels = new Pixel[widthRed][heightRed];

    for (int x = 0; x < widthRed; x++) {
      for (int y = 0; y < heightRed; y++) {

        Pixel imageRedPixel = imageRed.getPixels()[x][y];
        Pixel imageGreenPixel = imageGreen.getPixels()[x][y];
        Pixel imageBluePixel = imageBlue.getPixels()[x][y];


        int red = imageRedPixel.getRed();
        int green = imageGreenPixel.getGreen();
        int blue = imageBluePixel.getBlue();

        Pixel destPixel = new Pixel(red, green, blue);
        pixels[x][y] = destPixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }

  /**
   * Applies a blur filter to the image, creating a new image with a blurred appearance.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image where
   *                             the blurred image will be stored.
   */
  @Override
  public void blurCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;
    Pixel[][] pixels = new Pixel[width][height];

    double[][] kernel = {
            {1.0 / 16, 1.0 / 8, 1.0 / 16},
            {1.0 / 8, 1.0 / 4, 1.0 / 8},
            {1.0 / 16, 1.0 / 8, 1.0 / 16}
    };

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        double red = 0;
        double green = 0;
        double blue = 0;

        for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {
            if (x + i < 0 || x + i >= width
                    || y + j < 0 || y + j >= height) {
              continue;
            }

            Pixel tempPixel = image.getPixels()[x + i][y + j];
            red += tempPixel.getRed() * kernel[i + 1][j + 1];
            green += tempPixel.getGreen() * kernel[i + 1][j + 1];
            blue += tempPixel.getBlue() * kernel[i + 1][j + 1];

          }
        }

        int newRed = (int) Math.round(red);
        int newGreen = (int) Math.round(green);
        int newBlue = (int) Math.round(blue);

        Pixel pixel = new Pixel(newRed, newGreen, newBlue);
        pixels[x][y] = pixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }


  /**
   * Applies a sharpening filter to the image, creating a new image with enhanced sharpness.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image where
   *                             the sharpened image will be stored.
   */
  @Override
  public void sharpenCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;
    Pixel[][] pixels = new Pixel[width][height];

    double[][] kernel = {
            {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1, 1.0 / 4, -1.0 / 8},
            {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8}
    };

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        double red = 0;
        double green = 0;
        double blue = 0;

        for (int i = -2; i <= 2; i++) {
          for (int j = -2; j <= 2; j++) {
            if (x + i < 0 || x + i >= width
                    || y + j < 0 || y + j >= height) {
              continue;
            }

            Pixel tempPixel = image.getPixels()[x + i][y + j];
            red += tempPixel.getRed() * kernel[i + 2][j + 2];
            green += tempPixel.getGreen() * kernel[i + 2][j + 2];
            blue += tempPixel.getBlue() * kernel[i + 2][j + 2];
          }
        }

        int newRed = Math.min(255, Math.max(0, (int) Math.round(red)));
        int newGreen = Math.min(255, Math.max(0, (int) Math.round(green)));
        int newBlue = Math.min(255, Math.max(0, (int) Math.round(blue)));

        Pixel pixel = new Pixel(newRed, newGreen, newBlue);
        pixels[x][y] = pixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }

  /**
   * Applies a sepia tone filter to the image, giving it a warm, brownish tint.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image where the
   *                             sepia-toned image will be stored.
   */
  @Override
  public void sepiaCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;
    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel tempPixel = image.getPixels()[x][y];

        int red = tempPixel.getRed();
        int green = tempPixel.getGreen();
        int blue = tempPixel.getBlue();

        int newRed = (int) ((0.393 * red) + (0.769 * green) + (0.189 * blue));
        int newGreen = (int) ((0.349 * red) + (0.686 * green) + (0.168 * blue));
        int newBlue = (int) ((0.272 * red) + (0.534 * green) + (0.131 * blue));

        newRed = Math.min(255, newRed);
        newGreen = Math.min(255, newGreen);
        newBlue = Math.min(255, newBlue);

        Pixel pixel = new Pixel(newRed, newGreen, newBlue);
        pixels[x][y] = pixel;
      }
    }
    this.addImage(destinationImageName, new Image(pixels));
  }


  /**
   * Flips the specified image vertically and stores the result in the destination image.
   *
   * @param imageName            The name of the source image to be vertically flipped.
   * @param destinationImageName The name of the destination image where the flipped
   *                             image will be stored.
   */
  @Override
  public void verticalFlipCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;
    Pixel[][] flippedPixels = new Pixel[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        flippedPixels[i][j] = image.getPixels()[i][height - j - 1];
      }
    }
    this.addImage(destinationImageName, new Image(flippedPixels));
  }

  /**
   * Flips the specified image horizontally and stores the result in the destination image.
   *
   * @param imageName            The name of the source image to be horizontally flipped.
   * @param destinationImageName The name of the destination image where the flipped
   *                             image will be stored.
   */
  @Override
  public void horizontalFlipCommand(String imageName, String destinationImageName) {
    if (!imageExists(imageName)) {
      throw new IllegalArgumentException("Image does not exist!");
    }
    Image image = this.imageMap.get(imageName);
    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;
    Pixel[][] flippedPixels = new Pixel[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        flippedPixels[i][j] = image.getPixels()[width - i - 1][j];
      }
    }
    this.addImage(destinationImageName, new Image(flippedPixels));
  }

  /**
   * Splits an image into its RGB components and stores them as separate images in the model.
   *
   * @param redImageName   The name for the red component image.
   * @param greenImageName The name for the green component image.
   * @param blueImageName  The name for the blue component image.
   * @param imageName      The name of the source image to be split.
   */
  @Override
  public void rgbSplitCommand(String redImageName, String greenImageName,
                       String blueImageName, String imageName) {
    this.redComponentCommand(imageName, redImageName);
    this.greenComponentCommand(imageName, greenImageName);
    this.blueComponentCommand(imageName, blueImageName);
  }


  /**
   * Checks whether an image with the specified name exists in the image map.
   *
   * @param imageName The name of the image to check for existence.
   * @return true if an image with the given name exists in the image map, false otherwise.
   */
  @Override
  public boolean imageExists(String imageName) {
    return this.imageMap.containsKey(imageName);
  }

  /**
   * Retrieves the image with the specified image name from the image map.
   *
   * @param imageName The name of the image to retrieve.
   * @return The Image object associated with the given image name.
   */
  @Override
  public Image getImage(String imageName) {
    return this.imageMap.get(imageName);
  }
}

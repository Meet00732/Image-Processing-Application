package model;

/**
 * This class represents a two-dimensional array of `Pixel`
 * objects, forming an image. It provides methods to access and
 * manipulate the individual pixels that make up the image.
 */
public class Image {

  private final Pixel[][] pixels;

  /**
   * Constructs an `Image` object with the specified array of pixels.
   *
   * @param pixels The two-dimensional array of
   *               `Pixel` objects that compose the image.
   */
  public Image(Pixel[][] pixels) {
    this.pixels = pixels;
  }

  /**
   * Gets the array of `Pixel` objects that make up the image.
   *
   * @return The two-dimensional array of `Pixel` objects representing the image.
   */
  public Pixel[][] getPixels() {
    return pixels;
  }


  private Image extractComponent(ColorComponent component) {
    int width = pixels.length;
    int height = pixels[0].length;
    Pixel[][] componentPixels = new Pixel[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Pixel imagePixel = this.pixels[i][j];
        int red = 0;
        int green = 0;
        int blue = 0;

        switch (component) {
          case RED:
            red = imagePixel.getRed();
            componentPixels[i][j] = new Pixel(red, 0, 0);
            break;
          case GREEN:
            green = imagePixel.getGreen();
            componentPixels[i][j] = new Pixel(0, green, 0);
            break;
          case BLUE:
            blue = imagePixel.getBlue();
            componentPixels[i][j] = new Pixel(0, 0, blue);
            break;
          case VALUE:
            red = imagePixel.getRed();
            green = imagePixel.getGreen();
            blue = imagePixel.getBlue();

            int maxVal = Math.max(red, Math.max(green, blue));
            componentPixels[i][j] = new Pixel(maxVal, maxVal, maxVal);
            break;
          case INTENSITY:
            red = imagePixel.getRed();
            green = imagePixel.getGreen();
            blue = imagePixel.getBlue();

            int avgVal = (red + green + blue) / 3;
            componentPixels[i][j] = new Pixel(avgVal, avgVal, avgVal);
            break;
          case LUMA:
            red = imagePixel.getRed();
            green = imagePixel.getGreen();
            blue = imagePixel.getBlue();

            red = (int) Math.round(0.2126 * red);
            blue = (int) Math.round(0.0722 * blue);
            green = (int) Math.round(0.7152 * green);

            int newVal = red + green + blue;
            componentPixels[i][j] = new Pixel(newVal, newVal, newVal);
            break;
          case SEPIA:
            red = imagePixel.getRed();
            green = imagePixel.getGreen();
            blue = imagePixel.getBlue();

            int newRed = (int) ((0.393 * red) + (0.769 * green) + (0.189 * blue));
            int newGreen = (int) ((0.349 * red) + (0.686 * green) + (0.168 * blue));
            int newBlue = (int) ((0.272 * red) + (0.534 * green) + (0.131 * blue));

            newRed = Math.min(255, newRed);
            newGreen = Math.min(255, newGreen);
            newBlue = Math.min(255, newBlue);
            componentPixels[i][j] = new Pixel(newRed, newGreen, newBlue);
            break;
          case VERTICALFLIP:
            componentPixels[i][j] = this.getPixels()[i][height - j - 1];
            break;
          case HORIZONTALFLIP:
            componentPixels[i][j] = this.getPixels()[width - i - 1][j];
        }
      }
    }
    return new Image(componentPixels);
  }

  /**
   * Extracts the red component of the specified image and
   * creates a new image with only the red component.
   *
   */
  public Image redComponent() {
    return extractComponent(ColorComponent.RED);
  }

  /**
   * Extracts the green component of the specified image and
   * creates a new image with only the green component.
   */
  public Image greenComponent() {
    return extractComponent(ColorComponent.GREEN);
  }

  /**
   * Extracts the blue component of the specified image and
   * creates a new image with only the blue component.
   */
  public Image blueComponent() {
    return extractComponent(ColorComponent.BLUE);
  }


  /**
   * Creates a new image where all color components (red, green, and blue)
   * have the same value which is the maximum pixel of all (rgb).
   */
  public Image valueComponent() {
    return extractComponent(ColorComponent.VALUE);
  }

  /**
   * Creates a new image where each pixel's color components have the
   * same average value, representing the grayscale intensity.
   */
  public Image intensityComponent() {
    return extractComponent(ColorComponent.INTENSITY);
  }

  /**
   * Creates a new image where each pixel's color components are
   * transformed to represent the luma (brightness) of the image.
   */
  public Image lumaComponent() {
    return extractComponent(ColorComponent.LUMA);
  }

  /**
   * Applies a sepia tone filter to the image, giving it a warm, brownish tint.
   */
  public Image sepia() {
    return extractComponent(ColorComponent.SEPIA);
  }

  /**
   * Flips the specified image vertically and stores the result in the destination image.
   */
  public Image verticalFlip() {
    return extractComponent(ColorComponent.VERTICALFLIP);
  }

  /**
   * Flips the specified image horizontally and stores the result in the destination image.
   */
  public Image horizontalFlip() {
    return extractComponent(ColorComponent.HORIZONTALFLIP);
  }

  /**
   * Brightens the image by adding a specified increment to the
   * red, green, and blue components of each pixel.
   *
   * @param increment            The increment to be added to the red, green,
   *                             and blue components.
   */
  public Image brighten(int increment) {
    int width = this.getPixels().length;
    int height = this.getPixels()[0].length;

    Pixel[][] pixels = new Pixel[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Pixel imagePixel = this.getPixels()[i][j];

        int red = imagePixel.getRed();
        int blue = imagePixel.getBlue();
        int green = imagePixel.getGreen();

        int newRed = red + increment;
        int newBlue = blue + increment;
        int newGreen = green + increment;

        Pixel destPixel = new Pixel(newRed, newGreen, newBlue);
        pixels[i][j] = destPixel;
      }
    }
    return new Image(pixels);
  }

  /**
   * Applies a convolution kernel to the image, creating a new image as a result.
   *
   * @param kernel The convolution kernel matrix.
   * @return The new image after applying the kernel.
   */
  private Image applyKernel(double[][] kernel) {
    int width = pixels.length;
    int height = pixels[0].length;
    Pixel[][] newPixels = new Pixel[width][height];

    int kernelWidth = kernel.length;
    int kernelHeight = kernel[0].length;
    int kernelWidthOffset = kernelWidth / 2;
    int kernelHeightOffset = kernelHeight / 2;

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        double redSum = 0, greenSum = 0, blueSum = 0;

        for (int x = 0; x < kernelWidth; x++) {
          for (int y = 0; y < kernelHeight; y++) {
            int pixelX = i + x - kernelWidthOffset;
            int pixelY = j + y - kernelHeightOffset;

            if (pixelX >= 0 && pixelX < width && pixelY >= 0 && pixelY < height) {
              Pixel pixel = pixels[pixelX][pixelY];
              redSum += pixel.getRed() * kernel[x][y];
              greenSum += pixel.getGreen() * kernel[x][y];
              blueSum += pixel.getBlue() * kernel[x][y];
            }
          }
        }

        newPixels[i][j] = new Pixel(
                (int) Math.round(redSum),
                (int) Math.round(greenSum),
                (int) Math.round(blueSum)
        );
      }
    }
    return new Image(newPixels);
  }

  /**
   * Applies a blur filter to the image, creating a new image with a blurred appearance.
   */
  public Image blur() {
    double[][] kernel = {
            {1.0 / 16, 1.0 / 8, 1.0 / 16},
            {1.0 / 8, 1.0 / 4, 1.0 / 8},
            {1.0 / 16, 1.0 / 8, 1.0 / 16}
    };
    return applyKernel(kernel);
  }


  /**
   * Applies a sharpening filter to the image, creating a new image with enhanced sharpness.
   */
  public Image sharpen() {
    double[][] kernel = {
            {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1, 1.0 / 4, -1.0 / 8},
            {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8}
    };
    return applyKernel(kernel);
  }

}

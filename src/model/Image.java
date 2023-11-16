package model;

import model.strategy.SplitStrategy;
import java.awt.image.BufferedImage;

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

  public Image applyFilter(SplitStrategy strategy) {
    return strategy.apply(this);
  }

  public int[][] histogram() {
    int[] redFrequency = new int[256];
    int[] greenFrequency = new int[256];
    int[] blueFrequency = new int[256];
    int[][] channels = new int[3][256];

    Pixel[][] pixels = this.getPixels();
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j++) {
        Pixel pixel = pixels[i][j];
        redFrequency[pixel.getRed()]++;
        greenFrequency[pixel.getGreen()]++;
        blueFrequency[pixel.getBlue()]++;
      }
    }
    channels[0] = redFrequency;
    channels[1] = greenFrequency;
    channels[2] = blueFrequency;

    return channels;
  }


  public Image correctImage() {
    return correctColors();
  }

  private BufferedImage convertToBufferedImage(Image image) {
    Pixel[][] pixels = image.getPixels();
    int height = pixels.length;
    int width = pixels[0].length;
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel pixel = pixels[y][x];
        int rgb = (pixel.getRed() << 16) | (pixel.getGreen() << 8) | pixel.getBlue();
        bufferedImage.setRGB(x, y, rgb);
      }
    }

    return bufferedImage;
  }

  private Image correctColors() {
    BufferedImage image = convertToBufferedImage(this);
    int width = image.getWidth();
    int height = image.getHeight();
    Pixel[][] pixels = new Pixel[height][width];

    int[] redHistogram = new int[256];
    int[] greenHistogram = new int[256];
    int[] blueHistogram = new int[256];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int rgb = image.getRGB(x, y);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        redHistogram[red]++;
        greenHistogram[green]++;
        blueHistogram[blue]++;
      }
    }

    int redPeak = findMeaningfulPeak(redHistogram);
    int greenPeak = findMeaningfulPeak(greenHistogram);
    int bluePeak = findMeaningfulPeak(blueHistogram);

    int averagePeak = (redPeak + greenPeak + bluePeak) / 3;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int rgb = image.getRGB(x, y);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        int correctedRed = offsetValue(red, redPeak, averagePeak);
        int correctedGreen = offsetValue(green, greenPeak, averagePeak);
        int correctedBlue = offsetValue(blue, bluePeak, averagePeak);

        pixels[y][x] = new Pixel(correctedRed, correctedGreen, correctedBlue);
      }
    }

    return new Image(pixels);
  }

  private int findMeaningfulPeak(int[] histogram) {
    int peakValue = -1;
    int peakFrequency = 0;

    for (int i = 11; i < 245; i++) {
      if (histogram[i] > peakFrequency) {
        peakFrequency = histogram[i];
        peakValue = i;
      }
    }

    return peakValue;
  }

  private int offsetValue(int value, int currentPeak, int averagePeak) {
    int offset = averagePeak - currentPeak;
    int newValue = value + offset;

    if (newValue < 0) {
      newValue = 0;
    } else if (newValue > 255) {
      newValue = 255;
    }

    return newValue;
  }

  public Image levelsAdjust(int b, int m, int w) {
    return adjustLevels(convertToBufferedImage(this),b,m,w);
  }

  private Image adjustLevels(BufferedImage image, int b, int m, int w) {
    int width = image.getWidth();
    int height = image.getHeight();
    Pixel[][] pixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int rgb = image.getRGB(x, y);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        pixels[y][x] = new Pixel(
                applyLevelAdjustment(red, b, m, w),
                applyLevelAdjustment(green, b, m, w),
                applyLevelAdjustment(blue, b, m, w)
        );
      }
    }

    return new Image(pixels);
  }

  private int applyLevelAdjustment(int value, int shadow, int mid, int highlight) {
    if (value <= shadow) {
      return 0;
    } else if (value >= highlight) {
      return 255;
    } else if (value <= mid) {
      return (int) (1.7 * (value - shadow));
    } else {
      double a = calculateQuadraticCoefficient(shadow, mid, highlight);
      double b = calculateLinearCoefficient(shadow, mid, highlight);
      double c = calculateConstantCoefficient(shadow, mid, highlight);
      return (int) (a * value * value + b * value + c);
    }
  }

  private double calculateQuadraticCoefficient(int shadow, int mid, int highlight) {
    double A = shadow * shadow * (mid - highlight) - shadow
            * (mid * mid - highlight * highlight)
            + mid * mid * highlight - mid * highlight * highlight;
    double Aa = -shadow * (128 - 255) + 128 * highlight - 255 * mid;

    return Aa / A;
  }

  private double calculateLinearCoefficient(int shadow, int mid, int highlight) {
    double A = shadow * shadow * (mid - highlight) - shadow
            * (mid * mid - highlight * highlight)
            + mid * mid * highlight - mid * highlight * highlight;
    double Ab = shadow * shadow * (128 - 255)
            + 255 * mid * mid - 128 * highlight * highlight;

    return Ab / A;
  }

  private double calculateConstantCoefficient(int shadow, int mid, int highlight) {
    double A = shadow * shadow * (mid - highlight)
            - shadow * (mid * mid - highlight * highlight)
            + mid * mid * highlight - mid * highlight * highlight;
    double Ac = shadow * shadow * (255 * mid - 128 * highlight)
            - shadow * (255 * mid * mid - 128 * highlight * highlight);

    return Ac / A;
  }

  public Image compress(double percentage) {
    Pixel[][] pixels = this.getPixels();
    int width = this.getPixels().length;
    int height = this.getPixels()[0].length;

    double[][][] channels = extractColorChannels(pixels);
    HaarWaveletTransform haarWaveletTransform = new HaarWaveletTransform();

    for (int i = 0; i < channels.length; i++) {
      channels[i] = haarWaveletTransform.haar(channels[i]);
    }
    double threshold = haarWaveletTransform.calculateThreshold(channels, percentage);
    for (int i = 0; i < channels.length; i++) {
      channels[i] = this.filter(channels[i], threshold);
      channels[i] = haarWaveletTransform.inverseHaar(channels[i], width, height);
    }
    return imageFromChannels(channels);
  }

  private double[][][] extractColorChannels(Pixel[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    double[][] redChannel = new double[width][height];
    double[][] greenChannel = new double[width][height];
    double[][] blueChannel = new double[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Pixel pixel = pixels[i][j];
        redChannel[i][j] = pixel.getRed();
        greenChannel[i][j] = pixel.getGreen();
        blueChannel[i][j] = pixel.getBlue();
      }
    }
    return new double[][][]{redChannel, greenChannel, blueChannel};
  }

  private Image imageFromChannels(double[][][] channels) {
    int width = channels[0].length;
    int height = channels[0][0].length;
    Pixel[][] compressedPixels = new Pixel[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int red = (int) channels[0][i][j];
        int green = (int) channels[1][i][j];
        int blue = (int) channels[2][i][j];
        compressedPixels[i][j] = new Pixel(red, green, blue);
      }
    }
    return new Image(compressedPixels);
  }

  private double[][] filter(double[][] channel, double threshold) {
    int width = channel.length;
    int height = channel[0].length;

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (Math.abs(channel[i][j]) < threshold) {
          channel[i][j] = 0.0;
        }
      }
    }
    return channel;
  }

}

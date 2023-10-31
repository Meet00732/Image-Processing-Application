package model;

import java.util.HashMap;
import java.util.Map;

public class ImageModel implements ImageModelInterface{

  private final Map<String, Image> imageMap;

  public ImageModel() {
    this.imageMap = new HashMap<>();
  }

  public Map<String, Image> getImageMap() {
    return imageMap;
  }

  @Override
  public void addImage(String name, Image image) {
    this.imageMap.put(name, image);
  }


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
            {1.0/16, 1.0/8, 1.0/16},
            {1.0/8, 1.0/4, 1.0/8},
            {1.0/16, 1.0/8, 1.0/16}
    };

    for (int x = 0; x < width; x++) {
      for(int y = 0; y < height; y++) {
        double red = 0;
        double green = 0;
        double blue = 0;

        for(int i=-1; i<=1; i++) {
          for(int j=-1; j<=1; j++) {
            if (x + i < 0 || x + i >= width
              || y + j < 0 || y + j >= height) {
              continue;
            }

            Pixel tempPixel = image.getPixels()[x+i][y+j];
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
            {-1.0/8, -1.0/8, -1.0/8, -1.0/8, -1.0/8},
            {-1.0/8, 1.0/4, 1.0/4, 1.0/4, -1.0/8},
            {-1.0/8, 1.0/4, 1, 1.0/4, -1.0/8},
            {-1.0/8, -1.0/8, -1.0/8, -1.0/8, -1.0/8},
            {-1.0/8, 1.0/4, 1.0/4, 1.0/4, -1.0/8}
    };

    for (int x = 0; x < width; x++) {
      for(int y = 0; y < height; y++) {
        double red = 0;
        double green = 0;
        double blue = 0;

        for(int i=-2; i<=2; i++) {
          for(int j=-2; j<=2; j++) {
            if (x + i < 0 || x + i >= width
                    || y + j < 0 || y + j >= height) {
              continue;
            }

            Pixel tempPixel = image.getPixels()[x+i][y+j];
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

  private boolean imageExists(String imageName) {
    return this.imageMap.containsKey(imageName);
  }
}

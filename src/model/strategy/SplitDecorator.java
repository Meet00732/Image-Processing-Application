package model.strategy;

import model.Image;
import model.Pixel;

public class SplitDecorator implements SplitStrategy {
  private final SplitStrategy strategy;
  private final double splitPercentage;

  public SplitDecorator(SplitStrategy strategy, double splitPercentage) {
    this.strategy = strategy;
    this.splitPercentage = splitPercentage;
  }

  @Override
  public Image apply(Image image) {
    Image filteredImage = this.strategy.apply(image);
    int split = (int) (image.getPixels().length * (this.splitPercentage / 100.0));

    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    Pixel[][] splitPixels = new Pixel[width][height];

    for(int i=0; i < width; i++) {
      for(int j=0; j < height; j++) {
        if (i < split) {
          splitPixels[i][j] = filteredImage.getPixels()[i][j];
        }
        else {
          splitPixels[i][j] = image.getPixels()[i][j];
        }
      }
    }
    return new Image(splitPixels);
  }
}

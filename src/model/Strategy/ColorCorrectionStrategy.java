package model.Strategy;

import model.Image;

public class ColorCorrectionStrategy implements SplitStrategy {
  @Override
  public Image apply(Image image) {
    return image.correctImage();
  }
}

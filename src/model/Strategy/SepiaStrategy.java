package model.Strategy;

import model.Image;

public class SepiaStrategy implements SplitStrategy {
  @Override
  public Image apply(Image image) {
    return image.sepia();
  }
}

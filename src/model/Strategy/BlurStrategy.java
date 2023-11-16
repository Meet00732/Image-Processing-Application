package model.Strategy;

import model.Image;

public class BlurStrategy implements SplitStrategy {
  @Override
  public Image apply(Image image) {
    return image.blur();
  }
}

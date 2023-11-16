package model.strategy;

import model.Image;

public class SharpenStrategy implements SplitStrategy {
  @Override
  public Image apply(Image image) {
    return image.sharpen();
  }
}

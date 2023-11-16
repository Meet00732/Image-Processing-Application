package model.strategy;

import model.Image;

public class LumaStrategy implements SplitStrategy {
  @Override
  public Image apply(Image image) {
    return image.lumaComponent();
  }
}

package model.strategy;

import model.Image;

public class ValueStrategy implements SplitStrategy {
  @Override
  public Image apply(Image image) {
    return image.valueComponent();
  }
}

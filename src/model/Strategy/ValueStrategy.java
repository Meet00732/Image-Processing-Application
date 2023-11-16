package model.Strategy;

import model.Image;

public class ValueStrategy implements SplitStrategy {
  @Override
  public Image apply(Image image) {
    return image.valueComponent();
  }
}

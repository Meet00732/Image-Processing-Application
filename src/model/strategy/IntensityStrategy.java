package model.strategy;

import model.Image;

public class IntensityStrategy implements SplitStrategy {
  @Override
  public Image apply(Image image) {
    return image.intensityComponent();
  }
}

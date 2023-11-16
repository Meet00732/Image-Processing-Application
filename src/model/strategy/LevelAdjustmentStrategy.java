package model.strategy;

import model.Image;

public class LevelAdjustmentStrategy implements SplitStrategy {
  private final int b;
  private final int m;
  private final int w;
  public LevelAdjustmentStrategy(int b, int m, int w) {
    this.b = b;
    this.m = m;
    this.w = w;
  }

  @Override
  public Image apply(Image image) {
    return image.levelsAdjust(b, m ,w);
  }
}

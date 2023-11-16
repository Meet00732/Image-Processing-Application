package model.strategy;

import model.Image;

public interface SplitStrategy {

  Image apply(Image image);
}

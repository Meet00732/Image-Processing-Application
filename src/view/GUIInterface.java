package view;

import java.awt.image.BufferedImage;
import java.util.Optional;

import controller.Features;

public interface GUIInterface extends ImageViewInterface {
  void addFeatures(Features features);

  void setImage(BufferedImage image);

  void setHistogram(BufferedImage histogram);

  String loadImagePath();

  String saveImagePath();

  void showOperationControls(boolean show);

  boolean confirmLoadButton();

  Optional<Double> promptPercentage();

  Optional<int[]> promptForAdjustLevels();
}

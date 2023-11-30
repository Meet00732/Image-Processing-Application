package view;

import java.awt.image.BufferedImage;
import java.util.Optional;

import controller.Features;

public class MockView implements GUIInterface {
  private static final StringBuilder log = new StringBuilder();
  private Features features;

  @Override
  public void addFeatures(Features features) {
    this.features = features;
  }

  @Override
  public void setImage(BufferedImage image) {
    log.append("setImage method is invoked!\n");
  }

  @Override
  public void setHistogram(BufferedImage histogram) {
    log.append("setHistogram method is invoked!\n");
  }

  @Override
  public String loadImagePath() {
    log.append("loadImagePath method is invoked!\n");
    return "res\\nyc.jpg";
  }

  @Override
  public String saveImagePath() {
    log.append("saveImagePath method is invoked!\n");
    return "temp";
  }

  @Override
  public void showOperationControls(boolean show) {
    log.append("showOperationControls method is invoked!\n");
  }

  @Override
  public boolean confirmLoadButton() {
    log.append("confirmLoadButton method is invoked!\n");
    return true;
  }

  @Override
  public Optional<Double> promptPercentage() {
    log.append("promptPercentage method is invoked!\n");
    return Optional.of(20.5);
  }

  @Override
  public Optional<int[]> promptForAdjustLevels() {
    log.append("promptForAdjustLevels method is invoked!\n");
    return Optional.of(new int[]{10, 20, 30});
  }

  @Override
  public String getCommand() {
    log.append("getCommand method is invoked!\n");
    return null;
  }

  @Override
  public void display(String message) {
    log.append("display method is invoked!\n");
  }

  public static String getLog() {
    return log.toString();
  }

  public static void clearLog() {
    log.setLength(0);
  }
}

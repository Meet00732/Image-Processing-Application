package model;

public class MockModel implements ImageModelInterface {

  private static StringBuilder log = new StringBuilder();

  public MockModel() {
  }

  @Override
  public void addImage(String name, Image image) {
    log.append("AddImage method is invoked!");
  }

  @Override
  public void redComponentCommand(String imageName, String destinationImageName) {
    log.append("redComponentCommand method is invoked!");
  }

  @Override
  public void greenComponentCommand(String imageName, String destinationImageName) {
    log.append("greenComponentCommand method is invoked!");

  }

  @Override
  public void blueComponentCommand(String imageName, String destinationImageName) {
    log.append("blueComponentCommand method is invoked!");
  }

  @Override
  public void valueComponentCommand(String imageName, String destinationImageName) {
    log.append("valueComponentCommand method is invoked!");
  }

  @Override
  public void intensityComponentCommand(String imageName, String destinationImageName) {
    log.append("intensityComponentCommand method is invoked!");
  }

  @Override
  public void lumaComponentCommand(String imageName, String destinationImageName) {
    log.append("lumaComponentCommand method is invoked!");
  }

  @Override
  public void brightenCommand(String imageName, String destinationImageName, int increment) {
    log.append("brightenCommand method is invoked!");
  }

  @Override
  public void combineCommand(String imageRed, String imageGreen, String imageBlue, String imageName) {
    log.append("combineCommand method is invoked!");
  }

  @Override
  public void blurCommand(String imageName, String destinationImageName) {
    log.append("blurCommand method is invoked!");
  }

  @Override
  public void sharpenCommand(String imageName, String destinationImageName) {
    log.append("sharpenCommand method is invoked!");
  }

  @Override
  public void sepiaCommand(String imageName, String destinationImageName) {
    log.append("sepiaCommand method is invoked!");
  }

  @Override
  public void verticalFlipCommand(String imageName, String destinationImageName) {
    log.append("verticalFlipCommand method is invoked!");
  }

  @Override
  public void horizontalFlipCommand(String imageName, String destinationImageName) {
    log.append("horizontalFlipCommand method is invoked!");
  }


  @Override
  public boolean imageExists(String imageName) {
    log.append("imageExists method is invoked!");
    return false;
  }

  @Override
  public Image getImage(String imageName) {
    log.append("getImage method is invoked!");
    return null;
  }

  @Override
  public void rgbSplitCommand(String redImageName, String greenImageName, String blueImageName, String imageName) {
    log.append("rgbSplitCommand method is invoked!");
  }

  @Override
  public void compressImage(String imageName, String destinationImageName, int percentage) {
    log.append("compress method is invoked!");
  }

  public String getLog() {
    return log.toString();
  }

}

package model;

/**
 * The MockModel class is an implementation of the ImageModelInterface that serves as a
 * mock or testing model for the image processing application. It logs method invocations
 * for testing and debugging purposes and provides a log of the method calls.
 */
public class MockModel implements ImageModelInterface {

  private static final StringBuilder log = new StringBuilder();


  /**
   * Logs the invocation of the "addImage" method.
   *
   * @param name  The name of the image to be added.
   * @param image The image to be added to the model.
   */
  @Override
  public void addImage(String name, Image image) {
    log.append("AddImage method is invoked!");
  }

  /**
   * Logs the invocation of the "redComponentCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void redComponentCommand(String imageName, String destinationImageName) {
    log.append("redComponentCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "greenComponentCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void greenComponentCommand(String imageName, String destinationImageName) {
    log.append("greenComponentCommand method is invoked!");

  }

  /**
   * Logs the invocation of the "blueComponentCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void blueComponentCommand(String imageName, String destinationImageName) {
    log.append("blueComponentCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "valueComponentCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void valueComponentCommand(String imageName, String destinationImageName) {
    log.append("valueComponentCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "intensityComponentCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void intensityComponentCommand(String imageName, String destinationImageName) {
    log.append("intensityComponentCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "lumaComponentCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void lumaComponentCommand(String imageName, String destinationImageName) {
    log.append("lumaComponentCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "brightenCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   * @param increment            The amount by which to brighten the image.
   */
  @Override
  public void brightenCommand(String imageName, String destinationImageName, int increment) {
    log.append("brightenCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "combineCommand" method.
   *
   * @param imageRed   The name of the red component image.
   * @param imageGreen The name of the green component image.
   * @param imageBlue  The name of the blue component image.
   * @param imageName  The name of the combined image.
   */
  @Override
  public void combineCommand(String imageRed, String imageGreen,
                             String imageBlue, String imageName) {
    log.append("combineCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "blurCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void blurCommand(String imageName, String destinationImageName) {
    log.append("blurCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "sharpenCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void sharpenCommand(String imageName, String destinationImageName) {
    log.append("sharpenCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "sepiaCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void sepiaCommand(String imageName, String destinationImageName) {
    log.append("sepiaCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "verticalFlipCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void verticalFlipCommand(String imageName, String destinationImageName) {
    log.append("verticalFlipCommand method is invoked!");
  }

  /**
   * Logs the invocation of the "horizontalFlipCommand" method.
   *
   * @param imageName            The name of the source image.
   * @param destinationImageName The name of the destination image.
   */
  @Override
  public void horizontalFlipCommand(String imageName, String destinationImageName) {
    log.append("horizontalFlipCommand method is invoked!");
  }


  /**
   * Logs the invocation of the "imageExists" method.
   *
   * @param imageName The name of the image to check for existence.
   * @return A boolean indicating whether the image exists.
   */
  @Override
  public boolean imageExists(String imageName) {
    log.append("imageExists method is invoked!");
    return false;
  }

  /**
   * Logs the invocation of the "getImage" method.
   *
   * @param imageName The name of the image to retrieve.
   * @return The Image object associated with the provided image name.
   */
  @Override
  public Image getImage(String imageName) {
    log.append("getImage method is invoked!");
    return null;
  }

  /**
   * Logs the invocation of the "rgbSplitCommand" method.
   *
   * @param redImageName   The name of the red component image.
   * @param greenImageName The name of the green component image.
   * @param blueImageName  The name of the blue component image.
   * @param imageName      The name of the combined image.
   */
  @Override
  public void rgbSplitCommand(String redImageName, String greenImageName,
                              String blueImageName, String imageName) {
    log.append("rgbSplitCommand method is invoked!");
  }

  /**
   * Retrieves the log of method invocations.
   *
   * @return A String containing the log of method invocations.
   */
  public String getLog() {
    return log.toString();
  }

}
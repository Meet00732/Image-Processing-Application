package model;

public interface ImageModelInterface {
  void addImage(String name, Image image);

  void redComponentCommand(String imageName, String destinationImageName);

  void greenComponentCommand(String imageName, String destinationImageName);

  void blueComponentCommand(String imageName, String destinationImageName);

  void valueComponentCommand(String imageName, String destinationImageName);

  void intensityComponentCommand(String imageName, String destinationImageName);

  void lumaComponentCommand(String imageName, String destinationImageName);

  void brightenCommand(String imageName, String destinationImageName, int increment);

  void combineCommand(String imageRed, String imageGreen, String imageBlue, String imageName);

  void blurCommand(String imageName, String destinationImageName);

  void sharpenCommand(String imageName, String destinationImageName);

  void sepiaCommand(String imageName, String destinationImageName);

  void verticalFlipCommand(String imageName, String destinationImageName);

  void horizontalFlipCommand(String imageName, String destinationImageName);
}

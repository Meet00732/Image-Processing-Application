package controller.commands;

import model.Image;
import model.ImageModel;

public class IntensityComponentCommand extends AbstractBaseCommand {

  public IntensityComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.intensityComponentCommand(image);
  }
}

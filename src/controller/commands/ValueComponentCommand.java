package controller.commands;

import model.Image;
import model.ImageModel;

public class ValueComponentCommand extends AbstractBaseCommand {
  public ValueComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.valueComponentCommand(image);
  }
}

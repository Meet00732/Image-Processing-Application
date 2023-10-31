package controller.commands;

import model.Image;
import model.ImageModel;

public class RedComponentCommand extends AbstractBaseCommand {
  public RedComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.redComponentCommand(image);
  }
}

package controller.commands;

import model.Image;
import model.ImageModel;

public class GreenComponentCommand extends AbstractBaseCommand {

  public GreenComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.greenComponentCommand(image);
  }
}

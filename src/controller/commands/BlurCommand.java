package controller.commands;

import model.Image;
import model.ImageModel;

public class BlurCommand extends AbstractBaseCommand {
  public BlurCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.blurCommand(image);
  }
}

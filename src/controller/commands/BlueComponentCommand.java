package controller.commands;

import model.Image;
import model.ImageModel;

public class BlueComponentCommand extends AbstractBaseCommand {

  public BlueComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.blueComponentCommand(image);
  }

}
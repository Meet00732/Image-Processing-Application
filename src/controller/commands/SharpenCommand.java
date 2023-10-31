package controller.commands;

import model.Image;
import model.ImageModel;

public class SharpenCommand extends AbstractBaseCommand {

  public SharpenCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.sharpenCommand(image);
  }
}

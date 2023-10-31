package controller.commands;

import model.Image;
import model.ImageModel;

public class SepiaCommand extends AbstractBaseCommand {

  public SepiaCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.sepiaCommand(image);
  }
}

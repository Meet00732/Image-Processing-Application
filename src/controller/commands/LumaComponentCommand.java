package controller.commands;

import model.Image;
import model.ImageModel;

public class LumaComponentCommand extends AbstractBaseCommand{
  public LumaComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.lumaComponentCommand(image);
  }
}
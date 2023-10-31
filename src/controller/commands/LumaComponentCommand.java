package controller.commands;

import model.Image;
import model.ImageModel;

public class LumaComponentCommand extends AbstractBaseCommand{
  private String destinationImageName;
  public LumaComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.lumaComponentCommand(this.imageName, this.destinationImageName);
  }
}

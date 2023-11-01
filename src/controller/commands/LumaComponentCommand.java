package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class LumaComponentCommand extends AbstractBaseCommand{
  private String destinationImageName;
  public LumaComponentCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.lumaComponentCommand(this.imageName, this.destinationImageName);
  }
}

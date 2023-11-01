package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class BlurCommand extends AbstractBaseCommand {
  private String destinationImageName;

  public BlurCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.blurCommand(this.imageName, this.destinationImageName);
  }
}

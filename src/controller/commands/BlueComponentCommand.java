package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class BlueComponentCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public BlueComponentCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.blueComponentCommand(this.imageName, this.destinationImageName);
  }
}

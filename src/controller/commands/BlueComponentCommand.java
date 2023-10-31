package controller.commands;

import model.Image;
import model.ImageModel;

public class BlueComponentCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public BlueComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.blueComponentCommand(this.imageName, this.destinationImageName);
  }
}

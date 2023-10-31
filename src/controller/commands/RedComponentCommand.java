package controller.commands;

import model.Image;
import model.ImageModel;

public class RedComponentCommand extends AbstractBaseCommand {
  private String destinationImageName;
  public RedComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.redComponentCommand(this.imageName, this.destinationImageName);
  }
}

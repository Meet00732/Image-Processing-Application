package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class RedComponentCommand extends AbstractBaseCommand {
  private String destinationImageName;
  public RedComponentCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.redComponentCommand(this.imageName, this.destinationImageName);
  }
}

package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class ValueComponentCommand extends AbstractBaseCommand {
  private String destinationImageName;
  public ValueComponentCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.valueComponentCommand(this.imageName, this.destinationImageName);
  }
}

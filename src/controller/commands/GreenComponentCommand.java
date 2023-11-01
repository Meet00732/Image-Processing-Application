package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class GreenComponentCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public GreenComponentCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.greenComponentCommand(this.imageName, this.destinationImageName);
  }
}

package controller.commands;

import model.ImageModel;
import model.ImageModelInterface;

public class VerticalFlipCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public VerticalFlipCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() throws Exception {
    this.model.verticalFlipCommand(this.imageName, this.destinationImageName);
  }
}

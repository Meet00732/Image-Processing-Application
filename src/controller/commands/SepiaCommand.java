package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class SepiaCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public SepiaCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.sepiaCommand(this.imageName, this.destinationImageName);
  }
}

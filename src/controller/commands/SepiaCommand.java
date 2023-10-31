package controller.commands;

import model.Image;
import model.ImageModel;

public class SepiaCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public SepiaCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.sepiaCommand(this.imageName, this.destinationImageName);
  }
}

package controller.commands;

import model.Image;
import model.ImageModel;

public class IntensityComponentCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public IntensityComponentCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.intensityComponentCommand(this.imageName, this.destinationImageName);
  }
}

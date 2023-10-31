package controller.commands;

import model.Image;
import model.ImageModel;

public class SharpenCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public SharpenCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.sharpenCommand(this.imageName, this.destinationImageName);
  }
}

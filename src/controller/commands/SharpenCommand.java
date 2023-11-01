package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class SharpenCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public SharpenCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.sharpenCommand(this.imageName, this.destinationImageName);
  }
}

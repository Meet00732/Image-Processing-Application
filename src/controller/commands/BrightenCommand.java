package controller.commands;

import model.Image;
import model.ImageModel;

public class BrightenCommand extends AbstractBaseCommand {
  private int increment;
  public BrightenCommand(ImageModel model, int increment,
                         String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
    this.increment = increment;
  }

  @Override
  protected Image processImage(Image image) {
    return this.model.brightenCommand(image, this.increment);
  }
}

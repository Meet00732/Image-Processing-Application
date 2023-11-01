package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class BrightenCommand extends AbstractBaseCommand {
  private int increment;
  private String destinationImageName;
  public BrightenCommand(ImageModelInterface model, int increment,
                         String imageName, String destinationImageName) {
    super(model, imageName);
    this.increment = increment;
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() {
    this.model.brightenCommand(imageName, destinationImageName, this.increment);
  }
}

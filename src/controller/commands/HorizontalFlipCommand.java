package controller.commands;

import model.ImageModel;

public class HorizontalFlipCommand extends AbstractBaseCommand {

  private String destinationImageName;
  public HorizontalFlipCommand(ImageModel model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  @Override
  protected void processImage() throws Exception {
    this.model.horizontalFlipCommand(this.imageName, this.destinationImageName);
  }
}

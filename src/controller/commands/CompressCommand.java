package controller.commands;

import model.ImageModelInterface;

public class CompressCommand extends AbstractBaseCommand {
  int percentage;
  public CompressCommand(ImageModelInterface model, int percentage,
                         String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
    this.percentage = percentage;

  }
  @Override
  protected void processImage() throws Exception {
    this.model.compressImage(imageName, destinationImageName, this.percentage);
  }
}

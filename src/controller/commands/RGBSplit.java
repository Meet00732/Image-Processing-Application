package controller.commands;

import model.ImageModelInterface;

public class RGBSplit extends AbstractBaseCommand {

  private String redImageName;
  private String greenImageName;
  private String blueImageName;

  public RGBSplit(ImageModelInterface model,
                  String imageName,
                  String redImageName,
                  String greenImageName,
                  String blueImageName) {

    super(model, imageName);
    this.redImageName = redImageName;
    this.greenImageName = greenImageName;
    this.blueImageName = blueImageName;
  }

  @Override
  protected void processImage() throws Exception {
    this.model.rgbSplitCommand(this.redImageName, this.greenImageName, this.blueImageName, this.imageName);
  }
}

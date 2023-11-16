package controller.commands;

import model.ImageModelInterface;

public class LevelsAdjustmentCommand extends AbstractBaseCommand {

  private int b;
  private int m;
  private int w;

  public LevelsAdjustmentCommand(ImageModelInterface model, int b, int m, int w, String imageName, String destinationImageName) {
    super(model, imageName, destinationImageName);
    this.b = b;
    this.m = m;
    this.w = w;
  }

  /**
   * This method must be implemented by subclasses to define the specific image
   * manipulation logic. It may throw an Exception to indicate an error.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.levelsAdjustmentCommand(this.b,this.m,this.w,this.imageName,this.destinationImageName);
  }
}

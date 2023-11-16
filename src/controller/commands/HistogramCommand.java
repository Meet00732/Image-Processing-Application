package controller.commands;

import model.ImageModelInterface;

public class HistogramCommand extends AbstractBaseCommand {

  public HistogramCommand(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model,imageName,destinationImageName);
  }

  /**
   * This method must be implemented by subclasses to define the specific image
   * manipulation logic. It may throw an Exception to indicate an error.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.histogramCommand(this.imageName,this.destinationImageName);
  }

}

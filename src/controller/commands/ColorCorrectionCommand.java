package controller.commands;

import java.util.Optional;

import model.ImageModelInterface;

public class ColorCorrectionCommand extends AbstractSplitCommand {

  public ColorCorrectionCommand(ImageModelInterface model, String imageName,
                                String destinationImageName,
                                Optional<Double> splitPercentage) {
    super(model, imageName, destinationImageName, splitPercentage);
  }

  /**
   * This method must be implemented by subclasses to define the specific image
   * manipulation logic. It may throw an Exception to indicate an error.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.colorCorrectionCommand(this.imageName,this.destinationImageName, this.splitPercentage);
  }
}

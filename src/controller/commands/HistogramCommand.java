package controller.commands;

import model.HistogramCreator;
import model.Image;
import model.ImageModelInterface;
import model.Pixel;

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
    this.histogramCommand(this.imageName,this.destinationImageName);
  }

  public void histogramCommand(String imageName, String destinationImageName) throws Exception {
    int[][] channels = this.model.histogramCommand(imageName, destinationImageName);
    if (channels != null) {
      Pixel[][] histogram = HistogramCreator.createHistogramImage(channels);
      Image histImage = new Image(histogram);
      this.model.addImage(destinationImageName,histImage);
    }
  }
}

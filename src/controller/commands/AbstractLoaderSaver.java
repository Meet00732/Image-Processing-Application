package controller.commands;

import model.ImageModel;
import model.ImageModelInterface;

public abstract class AbstractLoaderSaver extends AbstractBaseCommand {

  public AbstractLoaderSaver(ImageModelInterface model, String imageName, String destinationImageName) {
    super(model, imageName);
    this.destinationImageName = destinationImageName;
  }

  protected String getImageFormat(String path) {
    String[] tokens = path.split("\\.");
    return tokens[tokens.length-1];
  }

  protected ImageParserInterface getFormattedImage(String path) {
    String format = this.getImageFormat(path);
    switch (format) {
      case "png":
        return new ImagePNG(path);
      case "jpg":
        return new ImageJPG(path);
      case "ppm":
        return new ImagePPM(path);
      case "jpeg":
        return new ImageJPEG(path);
      default:
        throw new UnsupportedOperationException("Invalid File Format");
    }
  }

}

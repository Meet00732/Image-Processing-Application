package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class SaveCommand extends AbstractLoaderSaver {

  public SaveCommand(ImageModelInterface model, String path, String name) {
    super(model, name, path);
  }

  @Override
  protected void processImage() throws Exception {
    if (this.model.imageExists(this.imageName)) {
      ImageParserInterface parser = this.getFormattedImage(this.destinationImageName);
      Image image = this.model.getImage(this.imageName);
      parser.save(this.destinationImageName, image);
    }
  }
}

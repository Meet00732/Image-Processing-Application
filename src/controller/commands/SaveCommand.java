package controller.commands;

import model.Image;
import model.ImageModel;

public class SaveCommand extends AbstractLoaderSaver {

  public SaveCommand(ImageModel model, String path, String name) {
    super(model, name, path);
  }

  @Override
  public void processImage() throws Exception {
    if (this.model.getImageMap().containsKey(this.imageName)) {
      ImageParserInterface parser = this.getFormattedImage(this.destinationImageName);
      Image image = this.model.getImageMap().get(this.imageName);
      parser.save(this.destinationImageName, image);
    }
  }
}

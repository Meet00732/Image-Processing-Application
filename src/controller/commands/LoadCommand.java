package controller.commands;

import java.io.IOException;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class LoadCommand extends AbstractLoaderSaver {

  public LoadCommand(ImageModelInterface model, String path, String name) {
    super(model, name, path);
  }
  @Override
  protected void processImage() throws IOException {
    ImageParserInterface parser = this.getFormattedImage(this.destinationImageName);
    Image image = parser.load();
    model.addImage(this.imageName,image);
  }
}

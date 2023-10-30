package controller.features;

import model.Image;
import model.ImageModel;

public class LoadFeature extends AbstractImageFormat {
  private final String path;
  private final String name;
  private ImageModel model;

  public LoadFeature(ImageModel model, String path,String name) {
    this.model = model;
    this.path = path;
    this.name = name;
  }
  @Override
  public boolean execute() {
    boolean status;
    try {
      ImageParserInterface parser = this.getFormattedImage(path);
      Image image = parser.load();
      model.addImage(name,image);
      status = true;
    } catch (Exception e) {
      status = false;
    }
    return status;
  }
}

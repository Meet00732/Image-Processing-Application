package Features;

import java.io.IOException;

import Model.ImageModel;

public class SaveFeature implements FeatureInterface {

  private String path;
  private ImageModel model;
  private String name;

  public SaveFeature (ImageModel model, String path, String name) {
    this.path = path;
    this.model = model;
    this.name = name;
  }
  @Override
  public String execute() throws Exception {
    this.model.saveImage(this.path, this.name);
    return ("Image Saved to " + this.path);
  }
}

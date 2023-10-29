package Features;

import java.io.IOException;

import Model.ImageModel;

public class LoadFeature implements FeatureInterface {
  private String path;
  private ImageModel model;
  private String name;

  public LoadFeature(ImageModel model, String path, String name) {
    this.path = path;
    this.model = model;
    this.name = name;
  }

  @Override
  public String execute() throws IOException {
    this.model.loadImage(this.path, this.name);
    return ("Image loaded from " + this.path);
  }
}

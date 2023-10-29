package Features;

import Model.ImageModel;

public class RedComponentFeature implements FeatureInterface {

  private String destinationImageName;
  private String imageName;
  private ImageModel model;

  public RedComponentFeature(ImageModel model, String imageName, String destinationImageName) {
    this.destinationImageName = destinationImageName;
    this.imageName = imageName;
    this.model = model;
  }
  @Override
  public String execute() throws Exception {
    this.model.redComponent(this.imageName, this.destinationImageName);
    return ("red-component created successfully!");
  }
}

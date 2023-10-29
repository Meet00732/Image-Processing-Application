package Features;

import Model.ImageModel;

public class BlueComponentFeature implements FeatureInterface{
  private String destinationImageName;
  private String imageName;
  private ImageModel model;

  public BlueComponentFeature(ImageModel model, String imageName, String destinationImageName) {
    this.destinationImageName = destinationImageName;
    this.imageName = imageName;
    this.model = model;
  }
  @Override
  public String execute() throws Exception {
    this.model.blueComponent(this.imageName, this.destinationImageName);
    return ("blue-component created successfully!");
  }
}

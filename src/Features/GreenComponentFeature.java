package Features;

import Model.ImageModel;

public class GreenComponentFeature implements FeatureInterface {

  private String destinationImageName;
  private String imageName;
  private ImageModel model;

  public GreenComponentFeature(ImageModel model, String imageName, String destinationImageName) {
    this.destinationImageName = destinationImageName;
    this.imageName = imageName;
    this.model = model;
  }
  @Override
  public String execute() throws Exception {
    this.model.greenComponent(this.imageName, this.destinationImageName);
    return ("green-component created successfully!");
  }
}

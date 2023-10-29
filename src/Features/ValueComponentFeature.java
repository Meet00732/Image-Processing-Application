package Features;

import Model.ImageModel;

public class ValueComponentFeature implements FeatureInterface{
  private String destinationImageName;
  private String imageName;
  private ImageModel model;

  public ValueComponentFeature(ImageModel model, String imageName, String destinationImageName) {
    this.destinationImageName = destinationImageName;
    this.imageName = imageName;
    this.model = model;
  }
  @Override
  public String execute() throws Exception {
    this.model.valueComponent(this.imageName, this.destinationImageName);
    return ("value-component created successfully!");
  }
}

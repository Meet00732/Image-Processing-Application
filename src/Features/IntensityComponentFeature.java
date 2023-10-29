package Features;

import Model.ImageModel;

public class IntensityComponentFeature implements FeatureInterface{
  private String destinationImageName;
  private String imageName;
  private ImageModel model;

  public IntensityComponentFeature(ImageModel model, String imageName, String destinationImageName) {
    this.destinationImageName = destinationImageName;
    this.imageName = imageName;
    this.model = model;
  }

  @Override
  public String execute() throws Exception {
    this.model.intensityComponent(this.imageName, this.destinationImageName);
    return ("intensity-component created successfully!");
  }
}

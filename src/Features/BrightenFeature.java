package Features;

import Model.ImageModel;

public class BrightenFeature implements FeatureInterface{

  private String destinationImageName;
  private String imageName;
  private ImageModel model;
  private int increment;

  public BrightenFeature(ImageModel model, int increment, String imageName, String destinationImageName) {
    this.destinationImageName = destinationImageName;
    this.imageName = imageName;
    this.model = model;
    this.increment = increment;
  }
  @Override
  public String execute() throws Exception {
    this.model.brightenComponent(this.increment, this.imageName, this.destinationImageName);
    return ("red-component created successfully!");
  }
}

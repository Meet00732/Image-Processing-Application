package Features;

import Model.ImageModel;

public class RBGSplitFeature implements FeatureInterface {
  private String destinationImageNameRed;
  private String destinationImageNameGreen;
  private String destinationImageNameBlue;
  private String imageName;
  private ImageModel model;

  public RBGSplitFeature(ImageModel model, String imageName,
                         String destinationImageNameRed,
                         String destinationImageNameGreen,
                         String destinationImageNameBlue) {

    this.model = model;
    this.imageName = imageName;
    this.destinationImageNameRed = destinationImageNameRed;
    this.destinationImageNameGreen = destinationImageNameGreen;
    this.destinationImageNameBlue = destinationImageNameBlue;
  }
  @Override
  public String execute() throws Exception {
    this.model.rgbSplitFeature(this.imageName, this.destinationImageNameRed,
            this.destinationImageNameGreen, this.destinationImageNameBlue);
    return ("red-component created successfully!");
  }
}

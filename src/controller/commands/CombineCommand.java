package controller.commands;

import model.Image;
import model.ImageModel;

public class CombineCommand extends AbstractBaseCommand {

  private String destinationImageGreenName;
  private String destinationImageBlueName;

  public CombineCommand(ImageModel model,
                        String destinationImageRedName,
                        String imageName,
                        String destinationImageGreenName,
                        String destinationImageBlueName) {

    super(model, destinationImageRedName, imageName);
    this.destinationImageGreenName = destinationImageGreenName;
    this.destinationImageBlueName = destinationImageBlueName;
  }

  @Override
  protected Image processImage(Image image) {
    if (imageExist(this.destinationImageGreenName)
    && imageExist(this.destinationImageBlueName)) {
      Image imageGreen = this.model.getImageMap().get(this.destinationImageGreenName);
      Image imageBlue = this.model.getImageMap().get(this.destinationImageBlueName);
      return this.model.combineCommand(image, imageGreen, imageBlue);
    }
    else {
      throw new IllegalArgumentException("One or more images does not exist!");
    }
  }
}

package controller.commands;

import model.Image;
import model.ImageModel;

public abstract class AbstractBaseCommand implements CommandInterface {

  protected String destinationImageName;
  protected String imageName;
  protected ImageModel model;

  public AbstractBaseCommand(ImageModel model, String imageName, String destinationImageName) {
    this.destinationImageName = destinationImageName;
    this.imageName = imageName;
    this.model = model;
  }

  public boolean imageExist(String imageName) {
    if (this.model.getImageMap().containsKey(imageName)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean execute() {
    boolean status;
    try {
      if (imageExist(this.imageName)) {
        Image image = this.model.getImageMap().get(this.imageName);
        Image desinationImage = this.processImage(image);
        this.model.addImage(this.destinationImageName, desinationImage);
        status = true;
      }
      else {
        status = false;
      }
    } catch (Exception e) {
      status = false;
    }
    return status;
  }

  protected abstract Image processImage(Image image);
}

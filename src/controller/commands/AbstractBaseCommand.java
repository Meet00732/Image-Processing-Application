package controller.commands;

import java.io.IOException;

import model.ImageModel;
import model.ImageModelInterface;

public abstract class
AbstractBaseCommand implements CommandInterface {

  protected String destinationImageName;
  protected String imageName;
  protected ImageModelInterface model;

  public AbstractBaseCommand(ImageModelInterface model, String imageName) {
    this.imageName = imageName;
    this.model = model;
  }

  @Override
  public boolean execute() {
    boolean status;
    try {
      this.processImage();
      status = true;
    }
    catch (Exception e) {
      status = false;
    }
    return status;
  }

  protected abstract void processImage() throws Exception;
}

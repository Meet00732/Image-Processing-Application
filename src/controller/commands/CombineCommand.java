package controller.commands;

import model.Image;
import model.ImageModel;
import model.ImageModelInterface;

public class CombineCommand extends AbstractBaseCommand {

  private String destinationImageRedName;
  private String destinationImageGreenName;
  private String destinationImageBlueName;

  public CombineCommand(ImageModelInterface model,
                        String destinationImageRedName,
                        String imageName,
                        String destinationImageGreenName,
                        String destinationImageBlueName) {

    super(model, imageName);
    this.destinationImageRedName = destinationImageRedName;
    this.destinationImageGreenName = destinationImageGreenName;
    this.destinationImageBlueName = destinationImageBlueName;
  }

  @Override
  protected void processImage() {
    this.model.combineCommand(this.destinationImageRedName, this.destinationImageGreenName,
            this.destinationImageBlueName, this.imageName);
  }
}

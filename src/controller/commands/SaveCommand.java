package controller.commands;

import model.Image;
import model.ImageModel;

public class SaveCommand extends AbstractImageFormat {

  private String path;
  private ImageModel model;
  private String name;

  public SaveCommand(ImageModel model, String path, String name) {
    this.path = path;
    this.model = model;
    this.name = name;
  }


  @Override
  public boolean execute() {
    boolean status;
    try {
      if (this.model.getImageMap().containsKey(this.name)) {
        ImageParserInterface parser = this.getFormattedImage(path);
        Image image = this.model.getImageMap().get(this.name);
        parser.save(this.path, image);
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
}

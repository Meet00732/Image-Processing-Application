package controller.commands;

import model.Image;

public class ImageJPEG implements ImageParserInterface {

  private String path;

  public ImageJPEG(String path) {
    this.path = path;
  }

  @Override
  public Image load() {
    return null;
  }

  @Override
  public void save(String path, Image image) {

  }

}

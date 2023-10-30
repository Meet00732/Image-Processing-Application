package model;

import java.util.HashMap;
import java.util.Map;

public class ImageModel implements ImageModelInterface{

  private final Map<String, Image> imageMap;

  public ImageModel() {
    this.imageMap = new HashMap<>();
  }

  @Override
  public void addImage(String name, Image image) {
    this.imageMap.put(name, image);
  }

  public Map<String, Image> getImageMap() {
    return imageMap;
  }
}

package Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageModel {
  private Map<String, Image> imageMap;
  private ImageProcessor processor;
  public ImageModel() {
    this.imageMap = new HashMap<>();
    this.processor = new ImageProcessor();
  }


  public void loadImage(String path, String name) throws IOException {
    Image image = this.processor.load(path);
    this.imageMap.put(name, image);
  }

  public void saveImage(String path, String name) throws Exception {
    if (!this.imageMap.containsKey(name)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(name);
    this.processor.save(path, image);
  }

  public void redComponent(String imageName, String destinationImageName) throws Exception {
    if (!this.imageMap.containsKey(imageName)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(imageName);
    Image destinationImage = this.processor.redComponent(image);
    this.imageMap.put(destinationImageName, destinationImage);
  }
}

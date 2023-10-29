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

  public void greenComponent(String imageName, String destinationImageName) throws Exception {
    if (!this.imageMap.containsKey(imageName)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(imageName);
    Image destinationImage = this.processor.greenComponent(image);
    this.imageMap.put(destinationImageName, destinationImage);
  }

  public void blueComponent(String imageName, String destinationImageName) throws Exception {
    if (!this.imageMap.containsKey(imageName)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(imageName);
    Image destinationImage = this.processor.blueComponent(image);
    this.imageMap.put(destinationImageName, destinationImage);
  }

  public void valueComponent(String imageName, String destinationImageName) throws Exception {
    if (!this.imageMap.containsKey(imageName)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(imageName);
    Image destinationImage = this.processor.valueComponent(image);
    this.imageMap.put(destinationImageName, destinationImage);
  }

  public void intensityComponent(String imageName, String destinationImageName) throws Exception {
    if (!this.imageMap.containsKey(imageName)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(imageName);
    Image destinationImage = this.processor.intensityComponent(image);
    this.imageMap.put(destinationImageName, destinationImage);
  }


  public void lumaComponent(String imageName, String destinationImageName) throws Exception {
    if (!this.imageMap.containsKey(imageName)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(imageName);
    Image destinationImage = this.processor.lumaComponent(image);
    this.imageMap.put(destinationImageName, destinationImage);
  }

  public void brightenComponent(int increment, String imageName,
                                String destinationImageName) throws Exception {
    if (!this.imageMap.containsKey(imageName)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(imageName);
    Image destinationImage = this.processor.brightFeature(image, increment);
    this.imageMap.put(destinationImageName, destinationImage);
  }

  public void rgbSplitFeature(String imageName,
                              String destinationImageNameRed,
                              String destinationImageNameGreen,
                              String destinationImageNameBlue) throws Exception {
    if (!this.imageMap.containsKey(imageName)) {
      throw new IllegalArgumentException("Invalid image name entered!");
    }
    Image image = this.imageMap.get(imageName);
    Image destinationImageRed = this.processor.redComponent(image);
    Image destinationImageGreen = this.processor.greenComponent(image);
    Image destinationImageBlue = this.processor.blueComponent(image);

    this.imageMap.put(destinationImageNameRed, destinationImageRed);
    this.imageMap.put(destinationImageNameGreen, destinationImageGreen);
    this.imageMap.put(destinationImageNameBlue, destinationImageBlue);
  }


}

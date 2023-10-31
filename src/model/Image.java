package model;

public class Image {

  private Pixel[][] pixels;

  public Image(Pixel[][] pixels) {
    this.pixels = pixels;
  }

  public Pixel[][] getPixels() {
    return pixels;
  }
}

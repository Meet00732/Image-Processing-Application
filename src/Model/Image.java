package Model;

public class Image {

  Pixel[][] pixels;
  int width;
  int height;

  public Image(Pixel[][] pixels, int width, int height) {
    this.pixels = pixels;
    this.width = width;
    this.height = height;
  }

  public Pixel[][] getPixels() {
    return pixels;
  }

  public void setPixels(Pixel[][] pixels) {
    this.pixels = pixels;
  }
}

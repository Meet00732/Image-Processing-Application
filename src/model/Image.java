package model;

/**
 * This class represents a two-dimensional array of `Pixel`
 * objects, forming an image. It provides methods to access and
 * manipulate the individual pixels that make up the image.
 */
public class Image {

  private final Pixel[][] pixels;

  /**
   * Constructs an `Image` object with the specified array of pixels.
   *
   * @param pixels The two-dimensional array of
   *               `Pixel` objects that compose the image.
   */
  public Image(Pixel[][] pixels) {
    this.pixels = pixels;
  }

  /**
   * Gets the array of `Pixel` objects that make up the image.
   *
   * @return The two-dimensional array of `Pixel` objects representing the image.
   */
  public Pixel[][] getPixels() {
    return pixels;
  }
}

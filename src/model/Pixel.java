package model;

public class Pixel {
  private int red;
  private int green;
  private int blue;

  public Pixel(int red, int green, int blue) {
    this.red = clamp(red);
    this.green = clamp(green);
    this.blue = clamp(blue);
  }

  private int clamp(int value) {
    if (value < 0) {
      value = 0;
    }
    else if (value > 255) {
      value = 255;
    }
    return value;
  }

  public int getRed() {
    return red;
  }


  public int getGreen() {
    return green;
  }


  public int getBlue() {
    return blue;
  }

}

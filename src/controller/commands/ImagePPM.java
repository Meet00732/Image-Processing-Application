package controller.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.Image;
import model.Pixel;

public class ImagePPM implements ImageParserInterface{

  private String path;

  public ImagePPM(String path) throws IllegalArgumentException {
    if (path == null || path == "") {
      throw new IllegalArgumentException("path cannot be empty or null");
    }
    this.path = path;
  }

  @Override
  public Image load() throws IOException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(path));
    } catch (IOException e) {
      throw new IOException("Error reading image from path: " + path, e);
    }

    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0)!='#') {
        builder.append(s+System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());


    if (!sc.hasNext() || !sc.next().equals("P3")) {
      throw new IOException("Invalid PPM file: plain RAW file should begin with P3");
    }

    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    if (maxValue > 255) {
      throw new IOException("Unsupported color depth. Maximum value should be 255.");
    }

    Pixel[][] pixels = new Pixel[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {

        int red = sc.nextInt();
        int green = sc.nextInt();
        int blue = sc.nextInt();

        Pixel pixel = new Pixel(red, green, blue);
        pixels[x][y] = pixel;
      }
    }
    return new Image(pixels);
  }

  @Override
  public void save(String path, Image image) throws IOException {
    if (image.getPixels() == null) {
      throw new IOException("No image data to save.");
    }

    int width = image.getPixels().length;
    int height = image.getPixels()[0].length;

    try (FileWriter writer = new FileWriter(new File(path))) {
      writer.write("P3\n");
      writer.write(width + " " + height + "\n");
      writer.write("255\n");

      for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
          Pixel pixel = image.getPixels()[x][y];
          writer.write(pixel.getRed() + " " + pixel.getGreen() + " " + pixel.getBlue() + " ");
        }
        writer.write("\n");
      }
    }
  }
}

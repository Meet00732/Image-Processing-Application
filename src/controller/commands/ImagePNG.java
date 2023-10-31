package controller.commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Image;
import model.Pixel;

public class ImagePNG extends ImageFormat{

  public ImagePNG(String path) {
    super(path);
  }
}

package controller.commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Image;
import model.Pixel;

public class ImageJPG extends ImageFormat {

  public ImageJPG(String path) {
    super(path);
  }
}

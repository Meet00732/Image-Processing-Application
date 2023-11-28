package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.commands.CommandFactory;
import controller.commands.CommandInterface;
import controller.commands.CommandPair;
import controller.commands.HistogramCommand;
import model.Image;
import model.ImageModelInterface;
import model.Pixel;
import view.GUIView;

public class GUIController implements ImageControllerInterface, ActionListener {
  private final GUIView view;
  private final ImageModelInterface model;

  private CommandFactory commandFactory;
  private CommandPair commandPair;

  private String previewImageName = "previewImage";
  private String displayImageName = "image";

  public GUIController(GUIView view,
                         ImageModelInterface model) throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("View Object is missing!");
    }
    if (model == null) {
      throw new IllegalArgumentException("Model Object is missing!");
    }
    this.view = view;
    this.model = model;
    commandFactory = new CommandFactory(model, view);
    initializeButtonsActions();
  }

  private void initializeButtonsActions() {
    view.setLoadButtonActionListener(this);
    view.setSaveButtonActionListener(this);
    view.setBlurButtonActionListener(this);
  }


  private void updateViewWithImage(String imageName) throws Exception {
    BufferedImage image = convertToBufferedImage(model.getImage(imageName));
    view.setImage(image);
    createHistogram(imageName);
    view.setHistogram(convertToBufferedImage(model.getImage(imageName + "Hist"))); // Assuming "Hist" suffix for histogram images
  }

  private void createHistogram(String imageName) throws Exception {
    CommandInterface histogram = new HistogramCommand(model,imageName,"imageHist");
    try {
      histogram.execute();
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  /**
   * Converts an Image to a BufferedImage.
   *
   * @param image The Image to convert.
   * @return The converted BufferedImage.
   */
  private BufferedImage convertToBufferedImage(Image image) {
    Pixel[][] pixels = image.getPixels();
    int width = pixels.length;
    int height = pixels[0].length;
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel pixel = pixels[x][y];
        int rgb = (pixel.getRed() << 16) | (pixel.getGreen() << 8) | pixel.getBlue();
        bufferedImage.setRGB(x, y, rgb);
      }
    }
    return bufferedImage;
  }

  @Override
  public void process() {

  }

  @Override
  public boolean processor(String command) {
    return false;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();

    System.out.println("Action");
    try {
      if ("confirm".equals(action)) {
        if (commandPair != null && commandPair.getApplyCommand() != null) {
          commandPair.getApplyCommand().execute();
          updateViewWithImage(displayImageName);
          view.showOperationControls(false);
        }
        return;
      } else if ("cancel".equals(action)) {
        updateViewWithImage(displayImageName);
        view.showOperationControls(false);
        return;
      }
      else {
        commandPair = commandFactory.invokeCommand(action, displayImageName);
        if (commandPair != null && commandPair.getPreviewCommand() != null) {
          boolean previewSuccess = commandPair.getPreviewCommand().execute();
          if (previewSuccess) {
            updateViewWithImage(displayImageName);
            view.showOperationControls(true);
          }
        }
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}

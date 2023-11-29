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
  private String displayImageName = "testImage";

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
    view.setConfirmButtonActionListener(this);
    view.setCancelButtonActionListener(this);
    view.setSepiaButtonActionListener(this);
    view.setRedButtonActionListener(this);
    view.setGreenButtonActionListener(this);
    view.setBlueButtonActionListener(this);
    view.setHorizontalFlipButtonActionListener(this);
    view.setVerticalFlipButtonActionListener(this);
    view.setLumaButtonActionListener(this);
    view.setSharpenButtonActionListener(this);
    view.setCompressButtonActionListener(this);
    view.setColorCorrectedButtonActionListener(this);
    view.setAdjustLevelsButtonActionListener(this);
  }


  private void updateViewWithImage(String imageName) throws Exception {
    BufferedImage image = convertToBufferedImage(model.getImage(imageName));
    view.setImage(image);
    createHistogram("testImage");
    view.setHistogram(convertToBufferedImage(model.getImage("testImageHist"))); // Assuming "Hist" suffix for histogram images
  }

  private void createHistogram(String imageName) throws Exception {
    CommandInterface histogram = new HistogramCommand(model,imageName,"testImageHist");
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
      } else if ("cancel".equals(action)) {
        updateViewWithImage(displayImageName);
        view.showOperationControls(false);
      }
      else {
        commandPair = commandFactory.invokeCommand(action);
        if (commandPair != null)
          if (commandPair.hasPreview()) {
            boolean previewSuccess = commandPair.getPreviewCommand().execute();
            if (previewSuccess) {
              updateViewWithImage(previewImageName);
              view.showOperationControls(true);
          }
        }
        else if (commandPair.hasApply()) {
          commandPair.getApplyCommand().execute();
          updateViewWithImage(displayImageName);
        }
      }
    } catch (Exception err) {
      view.display(err.getMessage());
    }
  }
}

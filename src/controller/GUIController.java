package controller;

import java.awt.image.BufferedImage;

import controller.commands.CommandFactory;
import controller.commands.CommandInterface;
import controller.commands.CommandGroup;
import controller.commands.HistogramCommand;
import model.Image;
import model.ImageModelInterface;
import model.Pixel;
import view.GUIInterface;


public class GUIController implements ImageControllerInterface, Features {
  private final GUIInterface view;
  private final ImageModelInterface model;
  private String previewImageName;
  private String displayImageName;
  private CommandFactory commandFactory;
  private CommandGroup commandGroup;

  public GUIController(GUIInterface view,
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
    previewImageName = "previewImage";
    displayImageName = "testImage";
    view.addFeatures(this);
  }

  private boolean processor(String action) {
    try {
      commandGroup = commandFactory.invokeCommand(action);
      if (commandGroup != null)
        if (commandGroup.hasPreview()) {
          boolean previewSuccess = commandGroup.getPreviewCommand().execute();
          if (previewSuccess) {
            updateViewWithImage(previewImageName);
            view.showOperationControls(true);
          }
        } else if (commandGroup.hasApply()) {
          commandGroup.getApplyCommand().execute();
          updateViewWithImage(displayImageName);
        }
    } catch (Exception err) {
      return false;
    }
    return true;
  }

  @Override
  public void loadButton() {
    boolean status = processor("load");
    if (!status) {
      view.display("Error executing Load!");
    }
  }

  @Override
  public void blurButton() {
    boolean status = processor("blur");
    if (!status) {
      view.display("Error executing Blur!");
    }
  }

  @Override
  public void sepiaButton() {
    boolean status = processor("sepia");
    if (!status) {
      view.display("Error executing Sepia!");
    }
  }

  @Override
  public void lumaButton() {
    boolean status = processor("luma");
    if (!status) {
      view.display("Error executing Luma!");
    }
  }

  @Override
  public void redButton() {
    boolean status = processor("red");
    if (!status) {
      view.display("Error executing Red-Component!");
    }
  }

  @Override
  public void greenButton() {
    boolean status = processor("green");
    if (!status) {
      view.display("Error executing Green-Component!");
    }
  }

  @Override
  public void blueButton() {
    boolean status = processor("blue");
    if (!status) {
      view.display("Error executing Blue-Component!");
    }
  }

  @Override
  public void compressButton() {
    boolean status = processor("compress");
    if (!status) {
      view.display("Error executing Compress!");
    }
  }

  @Override
  public void adjustLevelsButton() {
    boolean status = processor("adjust-levels");
    if (!status) {
      view.display("Error executing Adjust-Levels!");
    }
  }

  @Override
  public void colorCorrectedButton() {
    boolean status = processor("color-corrected");
    if (!status) {
      view.display("Error executing Color-Corrected!");
    }
  }

  @Override
  public void sharpenButton() {
    boolean status = processor("sharpen");
    if (!status) {
      view.display("Error executing Sharpen!");
    }
  }

  @Override
  public void horizontalFlipButton() {
    boolean status = processor("horizontal-flip");
    if (!status) {
      view.display("Error executing Horizontal-Flip!");
    }
  }

  @Override
  public void verticalFlipButton() {
    boolean status = processor("vertical-flip");
    if (!status) {
      view.display("Error executing Vertical-Flip!");
    }
  }

  @Override
  public void saveButton() {
    boolean status = processor("save");
    if (!status) {
      view.display("Error executing Save!");
    }
  }

  @Override
  public void cancelButton() {
    try {
      updateViewWithImage(displayImageName);
    } catch (Exception e) {
      view.display("Error Executing Cancel!");
    }
    view.showOperationControls(false);
  }

  @Override
  public void confirmButton() {
    try {
      if (commandGroup != null && commandGroup.getApplyCommand() != null) {
        commandGroup.getApplyCommand().execute();
        updateViewWithImage(displayImageName);
        view.showOperationControls(false);
      }
    }
    catch (Exception e) {
      view.display("Error Executing Confirm!");
    }
  }
}

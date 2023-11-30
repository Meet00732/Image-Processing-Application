package Controller;

import controller.Features;
import model.ImageModelInterface;
import view.GUIView;
import view.ImageViewInterface;

public class MockController implements Features {

  GUIView view;
  ImageModelInterface model;

  public MockController(ImageModelInterface model, GUIView view)
          throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("View Object is missing!");
    }
    if (model == null) {
      throw new IllegalArgumentException("Model Object is missing!");
    }
    this.view = view;
    this.model = model;
  }

  private static final StringBuilder log = new StringBuilder();
  @Override
  public void loadButton() {
    log.append("LoadButton Pressed!");
  }

  @Override
  public void blurButton() {
    log.append("BlurButton Pressed!");
  }

  @Override
  public void sepiaButton() {
    log.append("SepiaButton Pressed!");
  }

  @Override
  public void lumaButton() {
    log.append("LumaButton Pressed!");
  }

  @Override
  public void redButton() {
    log.append("RedButton Pressed!");
  }

  @Override
  public void greenButton() {
    log.append("GreenButton Pressed!");
  }

  @Override
  public void blueButton() {
    log.append("BlueButton Pressed!");
  }

  @Override
  public void compressButton() {
    log.append("CompressButton Pressed!");
  }

  @Override
  public void adjustLevelsButton() {
    log.append("AdjustLevelsButton Pressed!");
  }

  @Override
  public void colorCorrectedButton() {
    log.append("ColorCorrectedButton Pressed!");
  }

  @Override
  public void sharpenButton() {
    log.append("SharpenButton Pressed!");
  }

  @Override
  public void horizontalFlipButton() {
    log.append("HorizontalFlipButton Pressed!");
  }

  @Override
  public void verticalFlipButton() {
    log.append("VerticalFlipButton Pressed!");
  }

  @Override
  public void saveButton() {
    log.append("SaveButton Pressed!");
  }

  @Override
  public void cancelButton() {
    log.append("CancelButton Pressed!");
  }

  @Override
  public void confirmButton() {
    log.append("ConfirmButton Pressed!");
  }

  public static void clearLog() {
    log.setLength(0);
  }

  public String getLog() {
    return log.toString();
  }
}

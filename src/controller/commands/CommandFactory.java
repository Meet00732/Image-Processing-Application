package controller.commands;

import java.util.Optional;

import model.ImageModelInterface;
import view.GUIInterface;

public class CommandFactory {

  private final ImageModelInterface model;
  private final GUIInterface view;
  private AppState state;

  public CommandFactory(ImageModelInterface model, GUIInterface view) {
    this.model = model;
    this.view = view;
    this.state = AppState.NO_IMAGE_LOADED;
  }

  private boolean checkStatus() {
    return (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED);
  }

  private CommandPair handleLoadButton() {
    if (state == AppState.IMAGE_LOADED) {
      boolean shouldProceed = view.confirmLoadButton();
      if (!shouldProceed) {
        return null;
      }
      state = AppState.NO_IMAGE_LOADED;
    }
    if (state == AppState.NO_IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
      String path = view.loadImagePath();
      if (path != null) {
        CommandInterface loadCommand = new LoadCommand(model, path, "testImage");
        state = AppState.IMAGE_LOADED;
        return new CommandPair(null, loadCommand);
      }
    } else {
      view.display("Cannot load another image without saving the image first!");
    }
    return null;
  }

  private CommandPair handleSaveButton() {
    if (checkStatus()) {
      String path = view.saveImagePath();
      if (path != null) {
        CommandInterface saveCommand = new SaveCommand(model, path, "testImage");
        state = AppState.IMAGE_SAVED;
        return new CommandPair(null, saveCommand);
      }
    }
    else {
      view.display("Cannot save the image without loading the image first!");
    }
    return null;
  }

  private CommandPair handleCompressButton() {
    if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
      Optional<Double> splitPercentage = view.promptPercentage();
      if (splitPercentage.isPresent()) {
        CommandInterface verticalFlipPrevCommand = new CompressCommand(model, splitPercentage.get(),
                "testImage", "previewImage");
        CommandInterface verticalFlipCompleteCommand = new CompressCommand(model, splitPercentage.get(),
                "testImage", "testImage");
        state = AppState.IMAGE_LOADED;
        return new CommandPair(verticalFlipPrevCommand, verticalFlipCompleteCommand);
      }
    }
    else {
      view.display("Cannot apply compress without loading an image first!");
    }
    return null;
  }

  private CommandPair handleAdjustLevels() {
    if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
      Optional<int[]> adjustLevels = view.promptForAdjustLevels();
      if (adjustLevels.isPresent()) {
        Optional<Double> splitPercentage = view.promptPercentage();
        if (splitPercentage.isPresent()) {
          CommandInterface colorCorrectedPrevCommand = new LevelsAdjustmentCommand(model,
                  adjustLevels.get()[0], adjustLevels.get()[1], adjustLevels.get()[2],
                  "testImage", "previewImage", splitPercentage);
          CommandInterface colorCorrectedCompleteCommand = new LevelsAdjustmentCommand(model,
                  adjustLevels.get()[0], adjustLevels.get()[1], adjustLevels.get()[2],
                  "testImage", "testImage", Optional.of(100.0));
          state = AppState.IMAGE_LOADED;
          return new CommandPair(colorCorrectedPrevCommand, colorCorrectedCompleteCommand);
        }
      }
    } else {
      view.display("Cannot apply adjust-levels without loading an image first!");
    }
    return null;
  }


  private CommandInterface createSplitPercentageCommand(String commandType, String targetImageName,
                                                        Optional<Double> splitPercentage) {
    switch (commandType) {
      case "blur":
        return new BlurCommand(model, "testImage", targetImageName, splitPercentage);
      case "sepia":
        return new SepiaCommand(model, "testImage", targetImageName, splitPercentage);
      case "luma":
        return new LumaComponentCommand(model, "testImage", targetImageName, splitPercentage);
      case "sharpen":
        return new SharpenCommand(model, "testImage", targetImageName, splitPercentage);
      case "color-corrected":
        return new ColorCorrectionCommand(model, "testImage", targetImageName, splitPercentage);
      default:
        throw new IllegalArgumentException("Unsupported command type: " + commandType);
    }
  }

  private CommandInterface createCommand(String commandType, String targetImageName) {
    switch (commandType) {
      case "red":
        return new RedComponentCommand(model, "testImage", targetImageName);
      case "green":
        return new GreenComponentCommand(model, "testImage", targetImageName);
      case "blue":
        return new BlueComponentCommand(model, "testImage", targetImageName);
      case "horizontal-flip":
        return new HorizontalFlipCommand(model, "testImage", targetImageName);
      case "vertical-flip":
        return new VerticalFlipCommand(model, "testImage", targetImageName);
      default:
        throw new IllegalArgumentException("Unsupported command type: " + commandType);
    }
  }

  private CommandPair createSplitFilterCommand(String commandType) {
    if (!checkStatus()) {
      view.display("Cannot apply " + commandType + " without loading an image first!");
      return null;
    }

    Optional<Double> splitPercentage = view.promptPercentage();
    if (!splitPercentage.isPresent()) {
      return null;
    }

    CommandInterface previewCommand = createSplitPercentageCommand(commandType, "previewImage",
                                      splitPercentage);
    CommandInterface completeCommand = createSplitPercentageCommand(commandType, "testImage",
                                      Optional.of(100.0));

    return new CommandPair(previewCommand, completeCommand);
  }

  private CommandPair createFilterCommand(String commandType) {
    if (!checkStatus()) {
      view.display("Cannot apply " + commandType + " without loading an image first!");
      return null;
    }

    CommandInterface previewCommand = createCommand(commandType, "previewImage");
    CommandInterface completeCommand = createCommand(commandType, "testImage");
    return new CommandPair(previewCommand, completeCommand);
  }

  public CommandPair invokeCommand(String actionCommand) throws IllegalArgumentException {
    switch (actionCommand) {
      case "load":
        return handleLoadButton();
      case "save":
        return handleSaveButton();
      case "blur":
      case "sepia":
      case "luma":
      case "sharpen":
      case "color-corrected":
        return createSplitFilterCommand(actionCommand);
      case "compress":
        return handleCompressButton();
      case "red":
      case "green":
      case "blue":
      case "horizontal-flip":
      case "vertical-flip":
        return createFilterCommand(actionCommand);
      case "adjust-levels":
        return handleAdjustLevels();
      default:
        throw new IllegalArgumentException("Unknown command " + actionCommand);
    }
  }
}
package controller.commands;

import java.util.Optional;

import model.ImageModelInterface;
import view.GUIView;
import view.ImageViewInterface;

public class CommandFactory {

  private final ImageModelInterface model;
  private final GUIView view;
  private AppState state;

  public CommandFactory(ImageModelInterface model, GUIView view) {
    this.model = model;
    this.view = view;
    this.state = AppState.NO_IMAGE_LOADED;
  }


  public CommandPair invokeCommand(String actionCommand) throws IllegalArgumentException {
    String path;
    switch (actionCommand) {
      case "load":
        if (state == AppState.IMAGE_LOADED) {
          boolean shouldProceed = view.confirmImageLoad();
          if (!shouldProceed) {
            return null;
          }
          state = AppState.NO_IMAGE_LOADED;
        }
        if (state == AppState.NO_IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          path = view.loadImage();
          System.out.println(path);
          if (path != null) {
            CommandInterface loadCommand = new LoadCommand(model, path, "testImage");
            state = AppState.IMAGE_LOADED;
            return new CommandPair(null, loadCommand);
          }
        } else {
          view.display("Cannot load another image without saving the image first!");
        }
      return null;
      case "save":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          path = view.saveImage();
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
      case "blur":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          Optional<Double> splitPercentage = view.promptSplitPercentage();
          if (splitPercentage.isPresent()) {
            CommandInterface blurPrevCommand = new BlurCommand(model, "testImage",
                    "previewImage", splitPercentage);
            CommandInterface blurCompleteCommand = new BlurCommand(model, "testImage",
                    "testImage", Optional.of(100.0));
            state = AppState.IMAGE_LOADED;
            return new CommandPair(blurPrevCommand, blurCompleteCommand);
          }
        }
        else {
          view.display("Cannot apply blur without loading an image first!");
        }
        return null;

      case "sepia":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          Optional<Double> splitPercentage = view.promptSplitPercentage();
          if (splitPercentage.isPresent()) {
            CommandInterface sepiaPrevCommand = new SepiaCommand(model, "testImage",
                    "previewImage", splitPercentage);
            CommandInterface sepiaCompleteCommand = new SepiaCommand(model, "testImage",
                    "testImage", Optional.of(100.0));
            state = AppState.IMAGE_LOADED;
            return new CommandPair(sepiaPrevCommand, sepiaCompleteCommand);
          }
        }
        else {
          view.display("Cannot apply sepia without loading an image first!");
        }
        return null;

      case "luma":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          Optional<Double> splitPercentage = view.promptSplitPercentage();
          if (splitPercentage.isPresent()) {
            CommandInterface lumaPrevCommand = new LumaComponentCommand(model, "testImage",
                    "previewImage", splitPercentage);
            CommandInterface lumaCompleteCommand = new LumaComponentCommand(model, "testImage",
                    "testImage", Optional.of(100.0));
            state = AppState.IMAGE_LOADED;
            return new CommandPair(lumaPrevCommand, lumaCompleteCommand);
          }
        }
        else {
          view.display("Cannot apply luma without loading an image first!");
        }
        return null;

      case "sharpen":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          Optional<Double> splitPercentage = view.promptSplitPercentage();
          if (splitPercentage.isPresent()) {
            CommandInterface sharpenPrevCommand = new SharpenCommand(model, "testImage",
                    "previewImage", splitPercentage);
            CommandInterface sharpenCompleteCommand = new SharpenCommand(model, "testImage",
                    "testImage", Optional.of(100.0));
            state = AppState.IMAGE_LOADED;
            return new CommandPair(sharpenPrevCommand, sharpenCompleteCommand);
          }
        }
        else {
          view.display("Cannot apply sharpen without loading an image first!");
        }
        return null;

      case "red":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          CommandInterface redCompleteCommand = new RedComponentCommand(model, "testImage",
                  "testImage");
          state = AppState.IMAGE_LOADED;
          return new CommandPair(null, redCompleteCommand);
          }
        else {
          view.display("Cannot apply red-component without loading an image first!");
        }
        return null;

      case "green":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          CommandInterface greenCompleteCommand = new GreenComponentCommand(model, "testImage",
                  "testImage");
          state = AppState.IMAGE_LOADED;
          return new CommandPair(null, greenCompleteCommand);
        }
        else {
          view.display("Cannot apply green-component without loading an image first!");
        }
        return null;

      case "blue":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          CommandInterface blueCompleteCommand = new BlueComponentCommand(model, "testImage",
                  "testImage");
          state = AppState.IMAGE_LOADED;
          return new CommandPair(null, blueCompleteCommand);
        }
        else {
          view.display("Cannot apply blue-component without loading an image first!");
        }
        return null;

      case "horizontal-flip":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          CommandInterface horizontalFlipCompleteCommand = new HorizontalFlipCommand(model, "testImage",
                  "testImage");
          state = AppState.IMAGE_LOADED;
          return new CommandPair(null, horizontalFlipCompleteCommand);
        }
        else {
          view.display("Cannot apply horizontal-flip without loading an image first!");
        }
        return null;

      case "vertical-flip":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          CommandInterface verticalFlipCompleteCommand = new VerticalFlipCommand(model, "testImage",
                  "testImage");
          state = AppState.IMAGE_LOADED;
          return new CommandPair(null, verticalFlipCompleteCommand);
        }
        else {
          view.display("Cannot apply vertical-flip without loading an image first!");
        }
        return null;

      case "compress":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          Optional<Double> splitPercentage = view.promptSplitPercentage();
          if (splitPercentage.isPresent()) {
            CommandInterface verticalFlipCompleteCommand = new CompressCommand(model, splitPercentage.get(),
                    "testImage", "testImage");
            state = AppState.IMAGE_LOADED;
            return new CommandPair(null, verticalFlipCompleteCommand);
          }
        }
        else {
          view.display("Cannot apply compress without loading an image first!");
        }
        return null;

      case "color-corrected":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          Optional<Double> splitPercentage = view.promptSplitPercentage();
          if (splitPercentage.isPresent()) {
            CommandInterface colorCorrectedPrevCommand = new ColorCorrectionCommand(model, "testImage",
                    "previewImage", splitPercentage);
            CommandInterface colorCorrectedCompleteCommand = new ColorCorrectionCommand(model, "testImage",
                    "testImage", Optional.of(100.0));
            state = AppState.IMAGE_LOADED;
            return new CommandPair(colorCorrectedPrevCommand, colorCorrectedCompleteCommand);
          }
        }
        else {
          view.display("Cannot apply color-corrected without loading an image first!");
        }
        return null;

      case "adjust-levels":
        if (state == AppState.IMAGE_LOADED || state == AppState.IMAGE_SAVED) {
          Optional<int[]> adjustLevels = view.promptForAdjustLevels();
          if (adjustLevels.isPresent()) {
            Optional<Double> splitPercentage = view.promptSplitPercentage();
            if (splitPercentage.isPresent()) {
              CommandInterface colorCorrectedPrevCommand = new LevelsAdjustmentCommand(model,
                      adjustLevels.get()[0], adjustLevels.get()[1], adjustLevels.get()[2],
                      "testImage","previewImage", splitPercentage);
              CommandInterface colorCorrectedCompleteCommand = new LevelsAdjustmentCommand(model,
                      adjustLevels.get()[0], adjustLevels.get()[1], adjustLevels.get()[2],
                      "testImage","testImage", Optional.of(100.0));
              state = AppState.IMAGE_LOADED;
              return new CommandPair(colorCorrectedPrevCommand, colorCorrectedCompleteCommand);
            }
          }
        }
        else {
          view.display("Cannot apply adjust-levels without loading an image first!");
        }
        return null;

      default:
        throw new IllegalArgumentException("Unknown command " + actionCommand);
    }
  }
}

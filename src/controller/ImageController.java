package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import controller.commands.BlueComponentCommand;
import controller.commands.BlurCommand;
import controller.commands.BrightenCommand;
import controller.commands.ColorCorrectionCommand;
import controller.commands.CombineCommand;
import controller.commands.CommandInterface;
import controller.commands.CompressCommand;
import controller.commands.GreenComponentCommand;
import controller.commands.HistogramCommand;
import controller.commands.HorizontalFlipCommand;
import controller.commands.IntensityComponentCommand;
import controller.commands.LevelsAdjustmentCommand;
import controller.commands.LoadCommand;
import controller.commands.LumaComponentCommand;
import controller.commands.RGBSplit;
import controller.commands.RedComponentCommand;
import controller.commands.SaveCommand;
import controller.commands.SepiaCommand;
import controller.commands.SharpenCommand;
import controller.commands.ValueComponentCommand;
import controller.commands.VerticalFlipCommand;
import model.ImageModelInterface;
import view.ImageViewInterface;

/**
 * The ImageController class is responsible for controlling image processing commands
 * and interactions between the user interface (ImageView) and the image processing model
 * (ImageModel). It processes user commands, executes image processing operations, and
 * handles the execution of script files.
 * The controller supports a variety of image processing commands, such as loading, saving,
 * blurring, sharpening, applying filters, and more. It parses user commands and delegates
 * the execution to the appropriate command classes.
 */
public class ImageController implements ImageControllerInterface {

  private final ImageViewInterface view;
  private final ImageModelInterface model;

  /**
   * Constructs a new ImageController with the specified ImageView and ImageModel.
   *
   * @param view  The ImageView for displaying user interactions and results.
   * @param model The ImageModel for image processing operations.
   * @throws IllegalArgumentException when model or view is null.
   */
  public ImageController(ImageViewInterface view,
                         ImageModelInterface model) throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("View Object is missing!");
    }
    if (model == null) {
      throw new IllegalArgumentException("Model Object is missing!");
    }
    this.view = view;
    this.model = model;
  }

  /**
   * Starts processing user commands by continuously
   * reading and executing commands from the view.
   * It also handles and displays error messages for commands that fail.
   */
  @Override
  public void process() {
    boolean status;
    while (true) {
      String command = view.getCommand();
      String[] tokens = command.split(" ");

      if (tokens[0].equals("q")) {
        break;
      }
      status = this.processor(command);

      if (!status) {
        view.display("error executing " + tokens[0]);
      }
    }
  }

  /**
   * Processes the given command by delegating the execution
   * to the appropriate command classes.
   *
   * @param command The user command to process.
   * @return True if the command was executed
   *         successfully, false otherwise.
   */
  @Override
  public boolean processor(String command) {
    boolean status = false;
    CommandInterface feature;
    Optional<Double> splitPercentage;
    try {

      String[] tokens = command.split(" ");

      switch (tokens[0]) {
        case "load":
          feature = new LoadCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;
        case "save":
          feature = new SaveCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "blur":
          splitPercentage = Optional.empty();
          if (tokens.length > 3) {
            splitPercentage = Optional.of(Double.parseDouble(tokens[4]));
          }
          feature = new BlurCommand(model, tokens[1], tokens[2], splitPercentage);
          status = feature.execute();
          break;

        case "sharpen":
          splitPercentage = Optional.empty();
          if (tokens.length > 3) {
            splitPercentage = Optional.of(Double.parseDouble(tokens[4]));
          }
          feature = new SharpenCommand(model, tokens[1], tokens[2], splitPercentage);
          status = feature.execute();
          break;

        case "sepia":
          splitPercentage = Optional.empty();
          if (tokens.length > 3) {
            splitPercentage = Optional.of(Double.parseDouble(tokens[4]));
          }
          feature = new SepiaCommand(model, tokens[1], tokens[2], splitPercentage);
          status = feature.execute();
          break;

        case "red-component":
          feature = new RedComponentCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "green-component":
          feature = new GreenComponentCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "blue-component":
          feature = new BlueComponentCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "value-component":
          splitPercentage = Optional.empty();
          if (tokens.length > 3) {
            splitPercentage = Optional.of(Double.parseDouble(tokens[4]));
          }
          feature = new ValueComponentCommand(model, tokens[1], tokens[2], splitPercentage);
          status = feature.execute();
          break;

        case "intensity-component":
          splitPercentage = Optional.empty();
          if (tokens.length > 3) {
            splitPercentage = Optional.of(Double.parseDouble(tokens[4]));
          }
          feature = new IntensityComponentCommand(model, tokens[1], tokens[2], splitPercentage);
          status = feature.execute();
          break;

        case "luma-component":
          splitPercentage = Optional.empty();
          if (tokens.length > 3) {
            splitPercentage = Optional.of(Double.parseDouble(tokens[4]));
          }
          feature = new LumaComponentCommand(model, tokens[1], tokens[2], splitPercentage);
          status = feature.execute();
          break;

        case "brighten":
          int increment = Integer.parseInt(tokens[1]);
          feature = new BrightenCommand(model, increment, tokens[2], tokens[3]);
          status = feature.execute();
          break;

        case "vertical-flip":
          feature = new VerticalFlipCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "horizontal-flip":
          feature = new HorizontalFlipCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "rgb-split":
          feature = new RGBSplit(model, tokens[1], tokens[2], tokens[3], tokens[4]);
          status = feature.execute();
          break;

        case "rgb-combine":
          feature = new CombineCommand(model, tokens[2], tokens[1], tokens[3], tokens[4]);
          status = feature.execute();
          break;

        case "run":
          status = runScript(tokens[1]);
          break;

        case "compress":
          double percentage = Double.parseDouble(tokens[1]);
          feature = new CompressCommand(model, percentage, tokens[2], tokens[3]);
          status = feature.execute();
          break;

        case "histogram":
          feature = new HistogramCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "color-correct":
          splitPercentage = Optional.empty();
          if (tokens.length > 3) {
            splitPercentage = Optional.of(Double.parseDouble(tokens[4]));
          }
          feature = new ColorCorrectionCommand(model, tokens[1], tokens[2], splitPercentage);
          status = feature.execute();
          break;

        case "levels-adjust":
          splitPercentage = Optional.empty();
          if (tokens.length > 6) {
            splitPercentage = Optional.of(Double.parseDouble(tokens[7]));
          }
          feature = new LevelsAdjustmentCommand(model, Integer.parseInt(tokens[1]),
                  Integer.parseInt(tokens[2]),
                  Integer.parseInt(tokens[3]), tokens[4], tokens[5], splitPercentage);
          status = feature.execute();
          break;

        default:
          throw new IllegalArgumentException("Invalid Input: " + tokens[0]);
      }
      if (status) {
        view.display(tokens[0] + " executed successfully");
      }
    } catch (Exception e) {
      view.display(e.getMessage());
    }
    return status;
  }

  /**
   * Executes a script file containing a sequence of
   * image processing commands.
   *
   * @param path The path to the script file.
   * @return True if all commands in the script were executed
   *         successfully, false otherwise.
   * @throws FileNotFoundException when an invalid path is given.
   */
  @Override
  public boolean runScript(String path) throws FileNotFoundException {
    boolean status = false;
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.trim().isEmpty()) {
          continue;
        }
        status = this.processor(line);
      }
    } catch (IOException e) {
      throw new FileNotFoundException("File not Found!");
    }
    return status;
  }
}


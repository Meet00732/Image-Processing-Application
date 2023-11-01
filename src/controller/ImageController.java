package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import controller.commands.BlueComponentCommand;
import controller.commands.BlurCommand;
import controller.commands.BrightenCommand;
import controller.commands.CombineCommand;
import controller.commands.CommandInterface;
import controller.commands.GreenComponentCommand;
import controller.commands.HorizontalFlipCommand;
import controller.commands.IntensityComponentCommand;
import controller.commands.LoadCommand;
import controller.commands.LumaComponentCommand;
import controller.commands.RGBSplit;
import controller.commands.RedComponentCommand;
import controller.commands.SaveCommand;
import controller.commands.SepiaCommand;
import controller.commands.SharpenCommand;
import controller.commands.ValueComponentCommand;
import controller.commands.VerticalFlipCommand;
import model.ImageModel;
import model.ImageModelInterface;
import view.ImageView;
import view.ImageViewInterface;

public class ImageController implements ImageControllerInterface {

  private final ImageViewInterface view;
  private final ImageModelInterface model;

  public ImageController(ImageViewInterface view, ImageModelInterface model) throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("View Object is missing!");
    }

    if (model == null) {
      throw new IllegalArgumentException("Model Object is missing!");
    }
    this.view = view;
    this.model = model;
  }

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

  @Override
  public boolean processor(String command) {
    boolean status = false;
    CommandInterface feature;

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
          feature = new BlurCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "sharpen":
          feature = new SharpenCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "sepia":
          feature = new SepiaCommand(model, tokens[1], tokens[2]);
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
          feature = new ValueComponentCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "intensity-component":
          feature = new IntensityComponentCommand(model, tokens[1], tokens[2]);
          status = feature.execute();
          break;

        case "luma-component":
          feature = new LumaComponentCommand(model, tokens[1], tokens[2]);
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

        default:
          throw new IllegalArgumentException("Invalid Input: " + tokens[0]);
      }
      if (status) {
        view.display(tokens[0] + " executed successfully");
      }
    }
    catch (Exception e) {
      view.display("Please enter correct command format");
    }
    return status;
  }

  private boolean runScript(String path) throws FileNotFoundException {
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


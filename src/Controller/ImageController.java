package Controller;

import Features.CommandParser;
import Features.FeatureInterface;
import Model.ImageModel;
import View.CLIView;

public class ImageController {
  private final CLIView view;
  private final ImageModel model;

  public ImageController(CLIView view, ImageModel model) {
    this.view = view;
    this.model = model;
  }

  public void process() {
    while (true) {  // Infinite loop for simplicity, can add exit logic
      String commandLine = view.getCommand();
      try {
        FeatureInterface cmd = CommandParser.parse(commandLine, model);
        String message = cmd.execute();
        this.view.displayMessage(message);

      } catch (Exception e) {
        view.displayMessage("Exception!!!");
      }
    }
  }
}

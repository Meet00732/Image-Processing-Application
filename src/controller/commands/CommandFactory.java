package controller.commands;

import model.ImageModelInterface;
import view.GUIView;

public class CommandFactory {

  private final ImageModelInterface model;
  private final GUIView view;

  public CommandFactory(ImageModelInterface model, GUIView view) {
    this.model = model;
    this.view = view;
  }


  public CommandPair invokeCommand(String actionCommand, String displayImageName) throws IllegalArgumentException {
    switch (actionCommand) {
      case "load":
        String path = view.loadImage();
        CommandInterface loadCommand = new LoadCommand(model, path, displayImageName);
        return new CommandPair(loadCommand, loadCommand);
      default:
        throw new IllegalArgumentException("Unknown command " + actionCommand);
    }
  }
}

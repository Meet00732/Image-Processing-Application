package Features;

import java.io.IOException;

import Model.ImageModel;
public class CommandParser {

  public static FeatureInterface parse(String commandLine,
                                       ImageModel model)
          throws IOException {
    String[] tokens = commandLine.split(" ");

    switch (tokens[0]) {
      case "load":
        return new LoadFeature(model, tokens[1], tokens[2]);

      case "save":
        return new SaveFeature(model, tokens[1], tokens[2]);

      case "red-component":
        return new RedComponentFeature(model, tokens[1], tokens[2]);

      default:
        throw new IllegalArgumentException("Invalid command");
    }
  }
}

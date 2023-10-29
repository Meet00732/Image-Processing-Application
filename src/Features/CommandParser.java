package Features;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

      case "green-component":
        return new GreenComponentFeature(model, tokens[1], tokens[2]);

      case "blue-component":
        return new BlueComponentFeature(model, tokens[1], tokens[2]);

      case "value-component":
        return new ValueComponentFeature(model, tokens[1], tokens[2]);

      case "intensity-component":
        return new IntensityComponentFeature(model, tokens[1], tokens[2]);

      case "luma-component":
        return new LumaComponentFeature(model, tokens[1], tokens[2]);

      case "brighten":
        int increment = Integer.parseInt(tokens[1]);
        return new BrightenFeature(model, increment, tokens[2], tokens[3]);

      case "rgb-split":
        return new RBGSplitFeature(model, tokens[1], tokens[2], tokens[3], tokens[4]);

      default:
        throw new IllegalArgumentException("Invalid command");
    }
  }

  private static void runScript(String path, ImageModel model) {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.trim().isEmpty()) {
          continue;
        }
        FeatureInterface cmd = parse(line, model);
        String message = cmd.execute();
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

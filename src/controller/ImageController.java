package controller;

import controller.features.FeatureInterface;
import controller.features.LoadFeature;
import controller.features.SaveFeature;
import model.ImageModel;
import view.ImageView;

public class ImageController {

  private final ImageView view;
  private final ImageModel model;

  public ImageController(ImageView view, ImageModel model) {
    this.view = view;
    this.model = model;
  }
  public void process() {
    boolean status = false;
    FeatureInterface feature;
    while (true) {
      String command = view.getCommand();

      try {
        String[] tokens =command.split(" ");

        switch (tokens[0]) {
          case "load":
            feature = new LoadFeature(model,tokens[1],tokens[2]);
            status = feature.execute();
            break;
          case "save":
            feature = new SaveFeature(model, tokens[1], tokens[2]);
            status = feature.execute();
            break;
        }
        if (status) {
          view.display(tokens[0] + " executed successfully");
        } else {
          view.display("error executing " + tokens[0]);
        }
      } catch (Exception e) {
        view.display("Please enter correct command format");
      }
    }
  }
}

import Controller.ImageController;
import Model.ImageModel;
import View.CLIView;

public class Application {
  public static void main(String[] args) {
    CLIView view = new CLIView();
    ImageModel model = new ImageModel();

    ImageController controller = new ImageController(view, model);
    controller.process();
  }
}

import controller.ImageController;
import controller.ImageControllerInterface;
import model.ImageModel;
import model.ImageModelInterface;
import view.ImageView;
import view.ImageViewInterface;

public class Application {
  public static void main(String[] args) {
    ImageViewInterface view = new ImageView();
    ImageModelInterface model = new ImageModel();

    ImageControllerInterface controller = new ImageController(view,model);
    controller.process();
  }
}

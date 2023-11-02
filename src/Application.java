import controller.ImageController;
import controller.ImageControllerInterface;
import model.ImageModel;
import model.ImageModelInterface;
import view.ImageView;
import view.ImageViewInterface;

/**
 * The Application class serves as the entry point for the image
 * processing application. It initializes the main components
 * of the application, including the view, model, and controller,
 * and starts the image processing.
 */
public class Application {
  public static void main(String[] args) {
    ImageViewInterface view = new ImageView();
    ImageModelInterface model = new ImageModel();

    ImageControllerInterface controller = new ImageController(view,model);

    controller.process();
  }
}

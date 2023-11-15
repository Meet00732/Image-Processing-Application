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

  /**
   * The main method of the application, which serves as the entry point.
   * It initializes the view, model, and controller components, and then
   * initiates the image processing.
   *
   * @param args The command-line arguments, if any. These are not used in
   *             this application.
   */
  public static void main(String[] args) {
    ImageViewInterface view = new ImageView();
    ImageModelInterface model = new ImageModel();

    ImageControllerInterface controller = new ImageController(view, model);

    controller.process();
  }
}

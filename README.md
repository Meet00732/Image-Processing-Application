# IME: Image Manipulation and Enhancement

This project is built using the Java MVC architecture to provide image manipulation and enhancement functionalities.

## Model

The Model component in MVC architecture represents the application's data structures and business logic. It directly manages the data and the rules to manipulate that data.

### Classes in the Model Directory

#### Pixel Class

**Package:** `model`

The `Pixel` class represents a color pixel with its red, green, and blue components, each being an integer value ranging from 0 to 255.

**Methods:**

- **Constructor (`Pixel(int red, int green, int blue)`):** Constructs a Pixel object using the specified red, green, and blue components, ensuring they remain within the valid range [0, 255].

- **`getRed()`:** Returns the red component value of the pixel.

- **`getGreen()`:** Returns the green component value of the pixel.

- **`getBlue()`:** Returns the blue component value of the pixel.

#### Image Class

**Package:** `model`

The `Image` class represents a two-dimensional array of `Pixel` objects, forming an image. This class provides methods to access and manipulate the individual pixels that make up the image.

**Methods:**

- **Constructor (`Image(Pixel[][] pixels)`):** Constructs an `Image` object using the specified two-dimensional array of `Pixel` objects.

- **`getPixels()`:** Returns the two-dimensional array of `Pixel` objects representing the image.

- **`redComponent()`:** Extracts and returns a new image containing only the red component of the original image.

- **`greenComponent()`:** Extracts and returns a new image containing only the green component of the original image.

- **`blueComponent()`:** Extracts and returns a new image containing only the blue component of the original image.

- **`valueComponent()`:** Creates and returns a new image where all color components (red, green, and blue) have the same value, which is the maximum pixel value of all RGB channels.

- **`intensityComponent()`:** Creates and returns a new grayscale image where each pixel's color components have the same average value, representing grayscale intensity.

- **`lumaComponent()`:** Creates and returns a new image where each pixel's color components are transformed to represent the luma (brightness) of the image.

- **`sepia()`:** Applies a sepia tone filter to the image, giving it a warm, brownish tint, and returns the result as a new image.

- **`flipVertical()`:** Flips the specified image vertically and returns the result as a new image.

- **`flipHorizontal()`:** Flips the specified image horizontally and returns the result as a new image.

- **`brighten(int increment)`:** Brightens the image by adding a specified increment to the red, green, and blue components of each pixel. Returns the result as a new image.

- **`blur()`:** Applies a blur filter to the image, creating a new image with a blurred appearance.

- **`sharpen()`:** Applies a sharpening filter to the image, creating a new image with enhanced sharpness.

- **`applyFilter(SplitStrategy strategy)`:** Applies a filter to the image using the specified `SplitStrategy` and returns the filtered image.

- **`histogram()`:** Generates a histogram image representing the pixel value distribution of the original image. Returns the histogram image as a new image.

- **`correctImage()`:** Corrects the colors of the image by aligning the meaningful peaks of its histogram. Returns the corrected image as a new image.

- **`levelsAdjust(int b, int m, int w)`:** Adjusts the levels of the image using the specified black (b), mid (m), and white (w) values. Returns the adjusted image as a new image.

- **`correctColors(BufferedImage image)`:** Internal method that corrects the colors of an image based on the provided BufferedImage. Used in `correctImage()`.

- **`applyKernel(double[][] kernel)`:** Internal method for applying a convolution kernel to the image. Used in `blur()` and `sharpen()`.

- **`convertToPixelsArray(BufferedImage bufferedImage)`:** Internal method for converting a BufferedImage into a two-dimensional array of Pixels. Used in `histogram()` and `correctImage()`.

- **`findMeaningfulPeak(int[] histogram)`:** Internal method that finds the meaningful peak in a histogram. Used in `correctColors()`.

- **`offsetValue(int value, int currentPeak, int averagePeak)`:** Internal method that offsets a pixel value based on peaks. Used in `correctColors()`.

- **`calculateQuadraticCoefficient(int shadow, int mid, int highlight)`:** Internal method for calculating the quadratic coefficient used in level adjustment. Used in `applyLevelAdjustment()`.

- **`calculateLinearCoefficient(int shadow, int mid, int highlight)`:** Internal method for calculating the linear coefficient used in level adjustment. Used in `applyLevelAdjustment()`.

- **`calculateConstantCoefficient(int shadow, int mid, int highlight)`:** Internal method for calculating the constant coefficient used in level adjustment. Used in `applyLevelAdjustment()`.

### ImageModelInterface

**Package:** `model`

The `ImageModelInterface` defines a set of methods for managing and manipulating images. Classes implementing this interface provide functionality for image processing and manipulation.

**Methods:**

- **`addImage(String name, Image image)`:** Adds an image to the model with the specified name.

- **`redComponentCommand(String imageName, String destinationImageName)`:** Extracts the red component of the specified image, creating a new image with only the red component.

- **`greenComponentCommand(String imageName, String destinationImageName)`:** Extracts the green component, creating a new image with only the green component.

- **`blueComponentCommand(String imageName, String destinationImageName)`:** Extracts the blue component, creating a new image with only the blue component.

- **`valueComponentCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Creates a new image where all color components (red, green, and blue) have the same value.

- **`intensityComponentCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Creates a grayscale intensity image.

- **`lumaComponentCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Transforms to represent the luma (brightness) of the image.

- **`brightenCommand(String imageName, String destinationImageName, int increment)`:** Brightens the image by adding a specified increment to the pixel color components.

- **`combineCommand(String imageRed, String imageGreen, String imageBlue, String imageName)`:** Combines three images (red, green, blue channels) into one color image.

- **`blurCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Applies a blur filter.

- **`sharpenCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Enhances sharpness using a sharpening filter.

- **`sepiaCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Applies a sepia tone, giving the image a brownish tint.

- **`verticalFlipCommand(String imageName, String destinationImageName)`:** Flips the image vertically.

- **`horizontalFlipCommand(String imageName, String destinationImageName)`:** Flips the image horizontally.

- **`imageExists(String imageName)`:** Checks if an image with the specified name exists.

- **`getImage(String imageName)`:** Retrieves the Image object associated with a given name.

- **`rgbSplitCommand(String redImageName, String greenImageName, String blueImageName, String imageName)`:** Splits an image into its RGB components.

- **`compressImage(String imageName, String destinationImageName, double percentage)`:** Compresses the specified image using the Haar Wavelet Transform and stores the result in the destination image with the specified compression percentage.

- **`histogramCommand(String imageName, String destinationImageName)`:** Displays the histogram of the specified image and stores the result in the destination image.

- **`colorCorrectionCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Applies color correction to the specified image and stores the result in the destination image with the specified split percentage.

- **`levelsAdjustmentCommand(int b, int m, int w, String imageName,String destinationImageName, Optional<Double> splitPercentage)`:** Adjusts the levels of the specified image and stores the result in the destination image with the specified parameters and split percentage.

### Design Changes and Justification:

Introduction of Optional Split View:
- The `ImageModeInterface` now supports an optional split view feature.
- Utilizes the `Optional<Double> splitPercentage` parameter in various methods.

Justification:
- **Enhanced Flexibility:**
  - Users can now apply image processing operations, like grayscale conversion and sepia tone, to a specific  portion of the image.
  - Provides greater creative control over the application of effects.
- **Adherence to Open-Closed Principle:**
  - The model follows the open-closed principle, allowing for extension without modifying existing code.
  - Addition of new functionalities, such as split view, without altering the current code structure.
- **Integration with Strategy Pattern:**
  - The model's methods align with the implemented `SplitStrategy`` pattern in the strategy package.
  - Particularly relevant to the `SplitDecorator` class, which now requires a split percentage for proper functioning.
- **Consistency:**
  - Maintaining a consistent approach to optional parameters across different methods.
  - Ensures uniformity and predictability for developers implementing the model.

### ImageModel Class
**Package:** `model`

The `ImageModel` class represents a model for managing and manipulating images. It implements the `ImageModelInterface` and provides various methods for image processing and manipulation.

- **`redComponentCommand(String imageName, String destinationImageName)`:** Extracts the red component of the specified image, creating a new image with only the red component.

- **`greenComponentCommand(String imageName, String destinationImageName)`:** Extracts the green component, creating a new image with only the green component.

- **`blueComponentCommand(String imageName, String destinationImageName)`:** Extracts the blue component, creating a new image with only the blue component.

- **`valueComponentCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Creates a new image where all color components (red, green, and blue) have the same value.

- **`intensityComponentCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Creates a grayscale intensity image.

- **`lumaComponentCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Transforms to represent the luma (brightness) of the image.

- **`brightenCommand(String imageName, String destinationImageName, int increment)`:** Brightens the image by adding a specified increment to the pixel color components.

- **`combineCommand(String imageRed, String imageGreen, String imageBlue, String imageName)`:** Combines three images (red, green, blue channels) into one color image.

- **`blurCommand(String imageName, String destinationImageName)`:** Applies a blur filter.

- **`sharpenCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Enhances sharpness using a sharpening filter.

- **`sepiaCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Applies a sepia tone, giving the image a brownish tint.

- **`verticalFlipCommand(String imageName, String destinationImageName)`:** Flips the image vertically.

- **`horizontalFlipCommand(String imageName, String destinationImageName)`:** Flips the image horizontally.

- **`imageExists(String imageName):`** Checks if an image with the specified name exists.

- **`getImage(String imageName):`** Retrieves the Image object associated with a given name.

- **`rgbSplitCommand(String redImageName, String greenImageName, String blueImageName, String imageName)`:** Splits an image into its RGB components.

- **`compressImage(String imageName, String destinationImageName, double percentage)`:** Compresses the specified image using the Haar Wavelet Transform with the given compression percentage.

- **`histogramCommand(String imageName, String destinationImageName)`:** Displays the histogram of the specified image.

- **`colorCorrectionCommand(String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Applies color correction to the specified image.

- **`levelsAdjustmentCommand(int b, int m, int w, String imageName, String destinationImageName, Optional<Double> splitPercentage)`:** Adjusts the levels of the specified image.

### Design Changes and Justification:

Refactoring to Image Class:
- Originally, the image processing logic was housed within the `ImageModel` class.
- The design was modified to relocate the image processing logic into the `Image` class.

Justification:
- **Encapsulation:**
  - Shifting the logic to the `Image` class encapsulates the behavior with the data it manipulates, aligning with Object-Oriented Programming (OOP) principles.
- **Cohesion:**
  - The `Image` class becomes more cohesive by consolidating all operations directly related to image data within it.
- **Separation of Concerns:**
  - `ImageModel` is now exclusively responsible for managing the storage and retrieval of `Image` objects.
  - `Image`, on the other hand, handles the image processing logic.
  - This separation ensures clearer organization and allows for easier testing and maintenance of each component.

### SplitStrategy Interface

**Package:** `model.strategy`

The `SplitStrategy` interface defines a contract for classes that implement image splitting strategies. Image splitting is the process of dividing an image into multiple parts based on a specific strategy. 

**Methods:**

- **`apply(Image image)`:** Applies the defined splitting strategy to the given `Image`.

### SplitDecorator Class

**Package:** `model.strategy`

The `SplitDecorator` class implements the `SplitStrategy` interface and serves as a decorator for applying additional splitting functionality to the result of an underlying `SplitStrategy`. The splitting is performed based on a specified percentage of the image width.

- **`apply(Image image)`:** Applies the defined splitting strategy to the given `Image`.

### BlurStrategy Class

**Package:** `model.strategy`

The `BlurStrategy` class implements the `SplitStrategy` interface to provide a strategy for applying a blurring effect to an image.

- **`apply(Image image)`:** Applies the blurring strategy to the given `Image`.

### ColorCorrectionStrategy Class

**Package:** `model.strategy`

The `ColorCorrectionStrategy` class implements the `SplitStrategy` interface to provide a strategy for applying color correction to an image.

- **`apply(Image image)`:** Applies the color correction strategy to the given `Image`.

### IntensityStrategy Class

**Package:** `model.strategy`

The `IntensityStrategy` class implements the `SplitStrategy` interface to provide a strategy for isolating the intensity component of an image.

- **`apply(Image image)`:** Applies the intensity component isolation strategy to the given `Image`.

### LevelAdjustmentStrategy Class

**Package:** `model.strategy`

The `LevelAdjustmentStrategy` class implements the `SplitStrategy` interface to provide a strategy for adjusting the levels of an image.

- **`apply(Image image)`:** Applies the levels adjustment strategy to the given `Image` using the specified parameters.

### LumaStrategy Class

**Package:** `model.strategy`

The `LumaStrategy` class implements the `SplitStrategy` interface to provide a strategy for isolating the luma (luminance) component of an image.

- **`apply(Image image)`:** Applies the luma component isolation strategy to the given `Image`.

### SepiaStrategy Class

**Package:** `model.strategy`

The `SepiaStrategy` class implements the `SplitStrategy` interface to provide a strategy for applying a sepia tone effect to an image.

- **`apply(Image image)`:** Applies the sepia tone effect strategy to the given `Image`.

### SharpenStrategy Class

**Package:** `model.strategy`

The `SharpenStrategy` class implements the `SplitStrategy` interface to provide a strategy for applying a sharpening effect to an image.

- **`apply(Image image)`:** Applies the sharpening effect strategy to the given `Image`.

### ValueStrategy Class

**Package:** `model.strategy`

The `ValueStrategy` class implements the `SplitStrategy` interface to provide a strategy for applying a sharpening effect to an image.

- **`apply(Image image)`:** Applies the value component isolation strategy to the given `Image`.

---

## View

The View component is responsible for displaying the application's user interface (UI). It represents the UI of the application in terms of elements users interact with.

### Classes in the View Directory

#### ImageViewInterface Interface

**Package:** `view`

The `ImageViewInterface` is the main conduit for user interaction in the image processing application. It defines essential methods for receiving user commands and displaying messages, thereby facilitating the communication between the application and its users.

**Methods:**

- **`getCommand()`:** Retrieves a command input by the user, which can then be processed by the application.

- **`display(String message)`:** Presents messages to the user, such as confirmations, errors, or other feedback related to the image processing operations.

#### ImageView Class

**Package:** `view`

The `ImageView` class acts as a conduit between the user and the image processing system. It handles user input and output, allowing commands to be entered and responses, including error messages, to be displayed.

**Methods:**

- **`getCommand()`:** Prompts the user and retrieves the command line input from the standard input stream.
- **`display(String message)`:** Outputs a string message to the standard output stream, typically to show the results of an operation or error messages.

## Controller

The Controller acts as an interface between Model and View. It takes the user's input from the View, processes it (with potential updates to the Model), and returns the display output in the View.

### Classes in the Controller Directory

#### ImageControllerInterface

**Package:** `controller`

The `ImageControllerInterface` defines the contractual framework for controllers within an image processing application. It outlines essential methods for managing user commands and directing the flow of the application. Implementing classes will take on the responsibility of parsing user commands, conducting image processing tasks, and coordinating the exchange between the user interface and the image processing logic.

**Methods:**

- **`process()`:** Engages the user command handling system and governs the application's operational behavior, typically looping to receive and execute user commands.

- **`processor(String command)`:** Addresses a specific user command, ensuring it is acted upon by the correct operational components within the application.

#### ImageController

**Package:** `controller`

The `ImageController` class acts as a mediator between the user interface (`ImageView`) and the image processing engine (`ImageModel`). It is designed to handle the execution of image processing commands and manage user interactions effectively. This controller facilitates a broad spectrum of operations such as loading, saving, filtering, and transforming images by delegating commands to specialized command classes.

**Methods:**

- **Constructor (`ImageController(ImageView view, ImageModel model)`):** Initializes a new instance of `ImageController` with the given `ImageView` and `ImageModel`. It raises an `IllegalArgumentException` if either argument is null.

- **`process()`:** Begins the cycle of reading and executing user commands from the `ImageView`. It continues until it encounters a termination command, addressing errors for unsuccessful command executions along the way.

- **`processor(String command)`:** Interprets and processes a single user command by routing it to the corresponding command class for execution. Returns `true` if the command is executed successfully, `false` otherwise.

- **`runScript(String path)`:** Executes a batch of image processing commands from a script file identified by the given file path. It returns `true` if all commands are carried out successfully, or `false` if an error occurs.


#### CommandInterface Interface

**Package:** `controller.commands`

The `CommandInterface` sets the standard for all command objects, ensuring they facilitate the translation of user commands into actionable tasks by `ImageModel`.

---

#### ImageParserInterface Interface

**Package:** `controller.commands`

The `ImageParserInterface` dictates the controller's approach to parsing image data, guiding how user commands for image parsing are delivered to the `ImageModel`.

---

#### AbstractBaseCommand Class

**Package:** `controller.commands`

The `AbstractBaseCommand` class acts as an abstract framework for command objects in the controller, facilitating the interaction between the user interface and the image processing model by routing commands to the appropriate methods in `ImageModel`.

---

#### AbstractImageFormat Class

**Package:** `controller.commands`

The `AbstractImageFormat` class defines a template for supporting various image formats such as `jpg` or `jpeg` and `png`, enabling the controller to correctly direct format-specific image loading and saving commands to `ImageModel`.

---

#### AbstractLoaderSaver Class

**Package:** `controller.commands`

The `AbstractLoaderSaver` class provides a generic structure for loading and saving images, allowing the controller to delegate these actions to the `ImageModel` while handling different image file formats.

---

#### ImageJPEG Class

**Package:** `controller.commands`

The `ImageJPEG` class handles JPEG image format interactions within the controller, ensuring user commands related to JPEG files are processed by `ImageModel` appropriately.

---

#### ImageJPG Class

**Package:** `controller.commands`

The `ImageJPG` class focuses on facilitating the controller's handling of JPG image file interactions, directing user commands to the `ImageModel` for loading and saving JPG files.

---

#### ImagePNG Class

**Package:** `controller.commands`

The `ImagePNG` class ensures that PNG-related user commands are accurately relayed by the controller to `ImageModel`, which manages PNG image processing.

---

#### ImagePPM Class

**Package:** `controller.commands`

The `ImagePPM` class is tailored to bridge user commands for PPM images with `ImageModel`, facilitating the PPM image handling procedures.

---

#### LoadCommand Class

**Package:** `controller.commands`

The `LoadCommand` class streamlines the process of image loading by interpreting user commands and directing them to the `ImageModel`'s loading functionalities.

**Usage:**

  ```bash
  load <image-path> <image-name>
  ```

---

#### SaveCommand Class

**Package:** `controller.commands`

The `SaveCommand` class streamlines the user requests to ensure that save images are correctly passed on to `ImageModel`'s saving mechanisms.

**Usage:**

  ```bash
  save <image-path> <image-name>
  ```

---

#### BlurCommand Class

**Package:** `controller.commands`

The `BlurCommand` class operates within the controller to interpret user requests for blurring an image, guiding these requests to the corresponding blur methods in `ImageModel`.

**Usage:**

  ```bash
  blur <image-name> <dest-image-name>
  ```

---

#### SharpenCommand Class

**Package:** `controller.commands`

The `SharpenCommand` class operates within the controller to interpret user requests for sharpening an image, guiding these requests to the corresponding sharpening methods in `ImageModel`.

**Usage:**

  ```bash
  sharpen <image-name> <dest-image-name>
  ```

---

#### SepiaCommand Class

**Package:** `controller.commands`

The `SepiaCommand` class operates within the controller to interpret user requests for adding a sepia effect to an image, guiding these requests to the corresponding sepia effect methods in `ImageModel`.

**Usage:**

  ```bash
  sepia <image-name> <dest-image-name>
  ```

---

#### RedComponentCommand Class

**Package:** `controller.commands`

The `RedComponentCommand` class operates within the controller to interpret user requests for red component extraction, routing them from the user interface to the `ImageModel` for processing.

**Usage:**

  ```bash
  red-component <image-name> <dest-image-name>
  ```

---

#### GreenComponentCommand Class

**Package:** `controller.commands`

The `GreenComponentCommand` class operates within the controller to interpret user requests for green component extraction, routing them from the user interface to the `ImageModel` for processing.

**Usage:**

  ```bash
  green-component <image-name> <dest-image-name>
  ```

---

#### BlueComponentCommand Class

**Package:** `controller.commands`

The `BlueComponentCommand` class operates within the controller to interpret user requests for blue component extraction, routing them from the user interface to the `ImageModel` for processing.

**Usage:**

  ```bash
  blue-component <image-name> <dest-image-name>
  ```

---

#### ValueComponentCommand Class

**Package:** `controller.commands`

The `ValueComponentCommand` class ensures that commands for altering the value component of images are properly directed from the user to the `ImageModel`.

**Usage:**

  ```bash
  value-component <image-name> <dest-image-name>
  ```

---

#### IntensityComponentCommand Class

**Package:** `controller.commands`

The `IntensityComponentCommand` class mediates between the user interface and `ImageModel`, passing along commands that alter image intensity to the `ImageModel`.

**Usage:**

  ```bash
  intensity-component <image-name> <dest-image-name>
  ```

---

#### LumaComponentCommand Class

**Package:** `controller.commands`

The `LumaComponentCommand` class conveys user instructions for luma-based image manipulation from the user interface to the `ImageModel`.

**Usage:**

  ```bash
  luma-component <image-name> <dest-image-name>
  ```

---

#### BrightenCommand Class

**Package:** `controller.commands`

The `BrightenCommand` class manages commands for adjusting image brightness, directing them from the user interface to the `ImageModel`'s brightness modification methods.

**Usage:**

  ```bash
  brighten <increment> <image-name> <dest-image-name>
  ```

---

#### CombineCommand Class

**Package:** `controller.commands`

The `CombineCommand` class orchestrates the combination of RGB channels of the image by conveying user commands to the `ImageModel`, which handles the actual merging process.

**Usage:**

  ```bash
  rgb-combine <image-name> <red-image-name> <green-image-name> <blue-image-name>
  ```

---

#### RGBSplit Class

**Package:** `controller.commands`

The `RGBSplit` command translates the user's request to split an image into its RGB components, forwarding this task to the `ImageModel` to handle the actual separation.

**Usage:**

  ```bash
  rgb-split <image-name> <dest-image-name-red> <dest-image-name-green> <dest-image-name-blue>
  ```

---

#### HorizontalFlipCommand Class

**Package:** `controller.commands`

The `HorizontalFlipCommand` class functions as a conduit in the controller, taking horizontal flip commands from the user and passing them to `ImageModel` for execution.

**Usage:**

  ```bash
  horizontal-flip <image-name> <dest-image-name>
  ```

---

#### VerticalFlipCommand Class

**Package:** `controller.commands`

The `VerticalFlipCommand` class functions as a conduit in the controller, taking vertical flip commands from the user and passing them to `ImageModel` for execution.

**Usage:**

  ```bash
  vertical-flip <image-name> <dest-image-name>
  ```

---

#### ColorCorrectionCommand Class

**Package:** `controller.commands`

The `ColorCorrectCommand` class is responsible for performing color correction on an image by aligning the meaningful peaks of its histogram. This class serves as an intermediary in the controller, receiving color correction commands from the user and delegating them to the `ImageModel` for execution.

**Usage:**

  ```bash
  color-correct <image-name> <dest-image-name>
  ```

---

#### LevelsAdjustmentCommand Class

**Package:** `controller.commands`

The `LevelsAdjustCommand` class enables users to adjust the levels of an image. This class serves as a command handler in the controller, receiving level adjustment commands and delegating them to the `ImageModel` for execution.

**Usage:**

  ```bash
  levels-adjust <b> <m> <w> <image-name> <dest-image-name>
  ```

---

#### CompressCommand Class

**Package:** `controller.commands`

The `CompressCommand` class allows users to create a compressed version of an image. This class acts as a command handler in the controller, receiving compression commands and delegating them to the `ImageModel` for execution.

**Usage:**

  ```bash
  compress <percentage> <image-name> <dest-image-name>
  ```

---

#### HistogramCommand Class

**Package:** `controller.commands`

The `HistogramCommand` class allows users to generate an image that represents the histogram of a given image. This class serves as a command handler in the controller, receiving histogram generation commands and creating the histogram image using the `ImageModel`.

**Usage:**

  ```bash
  histogram <image-name> <dest-image-name>
  ```

---

#### Split Command Argument

**Package:** `controller.commands`

The `Split Command Argument` allows users to provide a percentage as an argument that will split the image and perform certain `<command>` on a split part of the image. The `<command>` can be: `blur`, `sharpen`, `sepia`, `luma`, `value`, `intensity`, `color-correct` and `levels-adjust`.

**Usage:**

  ```bash
  <command> <image-name> <dest-image-name> split <p>
  ```

---

## Running Script Commands:

### Running a Script at Program Start:
To execute a script on start of the application, use the following syntax:
```bash
    java -jar program.jar -file <filename>
```
- Place your script file (example: commands.txt) in the `res` folder of your project.
- Run the jar file by using the command `java -jar program.jar -file res/commands.txt`.
- The application will sequentially execute commands from `commands.txt`, storing the results to the specified directory and exit program execution.

### Running a Script After Program Start:
A user can also run a script after the application has started by following the below steps:

```bash
    run <filename>
```

- Place the script file (example: commands.txt) in the `res` folder of your project.
- Run the `jar` file by using the command `java -jar program.jar`.
- When prompted for commands, type out: `run res/commands.txt`.
- The application will sequentially execute commands from `commands.txt`, outputting results to the specified directory.

## Image Source

**Citation:** Image used in this project is licensed by PixaBay and the image source and license are provided below:
- Image Source: [Image Source URL](https://pixabay.com/photos/boat-lake-trees-forest-fall-8332114/)
- Terms of Usage: [Link to Terms of Usage](https://pixabay.com/service/license-summary/)
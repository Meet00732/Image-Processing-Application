# USEME - Image Processor Application Usage Instructions

## Running Script Commands:

### Running a Script at Program Start:
To execute a script on start of the application, use the following syntax:
```bash
    java -jar Assignment5.jar -file <filename>
```
- Use the script file `testNewFeaturesJar.txt` in the `res` folder of the project.
- Run the jar file by using the command `java -jar Assignment5.jar -file testNewFeaturesJar.txt`, to test the newly added features in the assignment-5.
- Run the jar file by using the command `java -jar Assignment5.jar -file testFeaturesJar.txt`, to test all the features in the assignment-4 and assignment-5.
- The application will sequentially execute commands from `testNewFeaturesJar.txt`, storing the results to the specified directory and exit program execution.

### Running a Script After Program Start:
A user can also run a script after the application has started by following the below steps:

```bash
    run <filename>
```

- Place the script file (example: commands.txt) in the `res` folder of your project.
- Run the `jar` file by using the command `java -jar Assignment5.jar`.
- When prompted for commands, type out: `run res/commands.txt`.
- The application will sequentially execute commands from `commands.txt`, outputting results to the specified directory.

### Running Individual Commands using Command Line:
All the supported command classes are provided below, refer the syntax usage on command line:

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
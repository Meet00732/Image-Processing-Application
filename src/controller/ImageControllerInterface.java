package controller;

import java.io.FileNotFoundException;

/**
 * The ImageControllerInterface defines the contract for an image controller in the
 * context of an image processing application. It specifies two essential methods
 * for processing user commands and controlling the application's behavior.
 * Implementing classes are responsible for interpreting user commands, executing
 * image processing operations, and managing interactions between the user interface
 * and the image processing model.
 */
public interface ImageControllerInterface {

  /**
   * Starts the process of handling user commands and controlling
   * the application's behavior.
   * This method typically runs in a loop, continuously reading and
   * executing user commands.
   */
  void process();

  /**
   * Processes a specific user command by delegating the
   * execution to the appropriate handlers.
   *
   * @param command The user command to process.
   * @return True if the command was executed successfully, false otherwise.
   */
  boolean processor(String command);

  /**
   * Executes a script file containing a sequence of
   * image processing commands.
   *
   * @param path The path to the script file.
   * @return True if all commands in the script were executed
   *         successfully, false otherwise.
   * @throws FileNotFoundException when an invalid path is given.
   */
  public boolean runScript(String path) throws FileNotFoundException;
}

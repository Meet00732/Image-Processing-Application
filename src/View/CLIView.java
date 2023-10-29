package View;

import java.util.Scanner;

public class CLIView {

  private final Scanner scanner;

  public CLIView() {
    this.scanner = new Scanner(System.in);
  }

  public String getCommand() {
    System.out.print("Enter command: ");
    return scanner.nextLine();
  }

  public void displayMessage(String message) {
    System.out.println(message);
  }
}

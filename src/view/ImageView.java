package view;

import java.util.Scanner;

public class ImageView {

  private final Scanner scanner;

  public ImageView() {
    this.scanner = new Scanner(System.in);
  }

  public String getCommand() {
    System.out.print("Enter command: ");
    return scanner.nextLine();
  }

  public void display(String message) {
    System.out.println(message);
  }

}

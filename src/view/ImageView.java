package view;

import java.util.Scanner;

public class ImageView implements ImageViewInterface {

  private final Scanner scanner;

  public ImageView() {
    this.scanner = new Scanner(System.in);
  }

  public String getCommand() {
    return scanner.nextLine();
  }

  public void display(String message) {
    System.out.println(message);
  }

}

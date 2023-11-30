package controller.commands;

public interface CommandFactoryInterface {
  CommandGroup invokeCommand(String actionCommand) throws IllegalArgumentException;
}

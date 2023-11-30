package controller.commands;

public class CommandGroup {
  private CommandInterface previewCommand;
  private CommandInterface applyCommand;

  public CommandGroup(CommandInterface previewCommand, CommandInterface applyCommand) {
    this.previewCommand = previewCommand;
    this.applyCommand = applyCommand;
  }

  public CommandInterface getPreviewCommand() { return previewCommand; }
  public CommandInterface getApplyCommand() { return applyCommand; }
  public boolean hasPreview() { return previewCommand != null; }
  public boolean hasApply() { return applyCommand != null; }
}


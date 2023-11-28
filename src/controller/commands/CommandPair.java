package controller.commands;

public class CommandPair {
  private CommandInterface previewCommand;
  private CommandInterface applyCommand;

  public CommandPair(CommandInterface previewCommand, CommandInterface applyCommand) {
    this.previewCommand = previewCommand;
    this.applyCommand = applyCommand;
  }

  public CommandInterface getPreviewCommand() { return previewCommand; }
  public CommandInterface getApplyCommand() { return applyCommand; }
  public boolean hasPreview() { return previewCommand != null; }
  public boolean hasApply() { return applyCommand != null; }
}

